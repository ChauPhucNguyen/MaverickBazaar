package com.example.maverickbazaar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class clubList extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    RecyclerAdapterClubs adapter;
    ArrayList<clubInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        recyclerView = findViewById(R.id.rvClubs);

        databaseReference = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com").getReference("clubs");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new RecyclerAdapterClubs(this, list);
        recyclerView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    clubInfo club = dataSnapshot.getValue(clubInfo.class);
                    list.add(club);
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        final Button button = (Button) findViewById(R.id.buttonFormClub);
        button.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Toast.makeText(getApplicationContext() , "Opening Form", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), CreateForm.class);
            startActivity(intent);
        });

    }
}