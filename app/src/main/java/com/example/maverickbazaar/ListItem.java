package com.example.maverickbazaar;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Objects;
import java.util.UUID;

public class ListItem extends AppCompatActivity {

    Uri imageUri;
    private ImageView imageView;

    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    FirebaseStorage storeStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        imageView = (ImageView) findViewById(R.id.itemImg);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContentStore.launch("image/*");
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

    private void uploadImage() {
        if (imageUri != null) {
            StorageReference reference = storeStorage.getReference().child("ItemImages/" + UUID.randomUUID().toString());
            reference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                    if(task.isSuccessful()) {

                        Toast.makeText(ListItem.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                        showStoreActivity();

                    }
                    else {
                        Toast.makeText(ListItem.this, "Image failed to upload", Toast.LENGTH_SHORT).show();
                        showStoreActivity();
                    }

                }
            });
        }
    }

    ActivityResultLauncher<String> mGetContentStore = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {

                    if (result != null) {
                        imageView.setImageURI((result));
                        imageUri = result;
                    }

                }
            });

    private void showStoreActivity() {
        Toast.makeText(this, "item listed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Store.class);
        startActivity(intent);
        finish();
    }
}