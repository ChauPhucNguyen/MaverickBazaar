package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Store extends AppCompatActivity {

    ImageButton AndroidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        AndroidImageButton = findViewById(R.id.imageButtonTest);
        AndroidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Store.this, "IT WORKS", Toast.LENGTH_SHORT).show();
            }
        });

        Button addItem= findViewById(R.id.addItem);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Store.this, "ADD ITEM TEST", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), CreateForm.class);
                startActivity(intent);
            }
        });
    }
}