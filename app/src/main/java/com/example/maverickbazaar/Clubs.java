package com.example.maverickbazaar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Clubs extends AppCompatActivity {

    int[] img = {R.drawable.club1};
    String names[] = {"Club 1"};
    String detail[] = {"Test Org"};
    private RecyclerAdapterClubs adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        recyclerView = findViewById(R.id.rvClubs);
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapterClubs(img,names,detail,this,"Clubs");
        recyclerView.setAdapter(adapter);

        final Button button = (Button) findViewById(R.id.buttonFormClub);
        button.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Toast.makeText(getApplicationContext() , "Opening Form", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), CreateForm.class);
            startActivity(intent);
        });
    }
}