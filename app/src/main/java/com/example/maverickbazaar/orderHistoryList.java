package com.example.maverickbazaar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class orderHistoryList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<exchangeInfo> list;
    DatabaseReference databaseReference;
    RecyclerAdapterExchanges adapter;

    EditText editText;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(orderHistoryList.this, MainActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_adapter_exchanges);

        recyclerView = findViewById(R.id.recyclerView);
        databaseReference = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com").getReference("orders");
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapterExchanges(this, list);
        recyclerView.setAdapter(adapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    exchangeInfo exchange = dataSnapshot.getValue(exchangeInfo.class);
                    list.add(exchange);
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}