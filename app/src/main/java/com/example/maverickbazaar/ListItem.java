package com.example.maverickbazaar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class ListItem extends AppCompatActivity {

    ImageButton itemImageButton;
    private FirebaseAuth mAuth;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

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
                registerItem();
            }
        });
    }

    private void registerItem() {
        EditText itemName = findViewById(R.id.editItemName);
        EditText itemPrice = findViewById(R.id.editItemPrice);
        EditText itemDetails = findViewById(R.id.editItemDetails);

        String item_name = itemName.getText().toString();
        String item_details = itemDetails.getText().toString();
        String item_price = itemPrice.getText().toString();

        if (item_name.isEmpty() || item_price.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        storeInfo item = new storeInfo(item_name,item_details,item_price);
        rootNode = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com");
        reference = rootNode.getReference("items");
        reference.push().setValue(item);
        showStoreActivity();
    }

    private void showStoreActivity() {
        Toast.makeText(this, "item listed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Store.class);
        startActivity(intent);
        finish();
    }
}