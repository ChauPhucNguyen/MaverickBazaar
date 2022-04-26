package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ListItem extends AppCompatActivity {

    ImageButton itemImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemImageButton = (ImageButton) findViewById(R.id.itemImageButton);
        itemImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ListItem.this, "Upload a Photo", Toast.LENGTH_SHORT).show();
            }
        });

        Button listItem= (Button) findViewById(R.id.ListItemButton);
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ListItem.this, "Item Listed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), Store.class);
                startActivity(intent);
            }
        });
    }
}