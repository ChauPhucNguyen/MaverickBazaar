package com.example.maverickbazaar;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class CreateForm extends AppCompatActivity {

    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    Button submitButton;

    Uri imageUri;
    private ImageView imageView;

    FirebaseStorage clubStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_form);

        imageView = (ImageView) findViewById(R.id.clubImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGetContentClubs.launch("image/*");
            }
        });

        clubStorage = FirebaseStorage.getInstance();

        submitButton = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(view -> makeClub());

    }

    private void makeClub() {
        EditText club_name = findViewById(R.id.editClubName);
        EditText club_details= findViewById(R.id.editClubDescription);

        String clubName = club_name.getText().toString();
        String clubDescription = club_details.getText().toString();

        if (clubName.isEmpty() || clubDescription.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }


        clubInfo club = new clubInfo(clubName,clubDescription);
        rootNode = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com");
        reference = rootNode.getReference("clubs");
        reference.push().setValue(club);
        uploadImage();
    }

    private void uploadImage() {
        if (imageUri != null) {
            StorageReference reference = clubStorage.getReference().child("images/" + UUID.randomUUID().toString());
            reference.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                    if(task.isSuccessful()) {

                        Toast.makeText(CreateForm.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                        showClubActivity();

                    }
                    else {
                        Toast.makeText(CreateForm.this, "Image failed to upload", Toast.LENGTH_SHORT).show();
                        showClubActivity();
                    }

                }
            });
        }
    }

    ActivityResultLauncher<String> mGetContentClubs = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {

                    if (result != null) {
                        imageView.setImageURI((result));
                        imageUri = result;
                    }

                }
            });

    private void showClubActivity() {
        Toast.makeText(this, "Club Created", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, clubList.class);
        startActivity(intent);
        finish();
    }
}