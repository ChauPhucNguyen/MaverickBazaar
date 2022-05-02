package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Store extends AppCompatActivity {

    int[] img = {R.drawable.notebook1, R.drawable.notebook2, R.drawable.book1, R.drawable.pencil1};
    String names[] = {"Notebook 1", "Notebook 2", "Textbook", "Mechanical Pencil"};
    double[] prices= {5.99,7.99,129.99,1.99};
    private RecyclerAdapterStore adapter;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        recyclerView = findViewById(R.id.rvStore);
        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapterStore(img,names,prices,this,"Store");
        recyclerView.setAdapter(adapter);

        Button addItem = findViewById(R.id.addItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListItem.class);
                startActivity(intent);
            }
        });
    }
}