package com.example.maverickbazaar;

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

public class CreateForm extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    ImageButton clubImageButton;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_form);

        submitButton = (Button) findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeClub();
            }
        });
    }

    private void makeClub() {
        EditText club_name = findViewById(R.id.editClubName);
        EditText club_description = findViewById(R.id.editClubDescription);

        String clubName = club_name.getText().toString();
        String clubDescription = club_description.getText().toString();

        if (clubName.isEmpty() || clubDescription.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        clubInfo club = new clubInfo(clubName,clubDescription);
        rootNode = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com");
        reference = rootNode.getReference("clubs");
        reference.push().setValue(club);
        showClubActivity();
    }

    private void showClubActivity() {
        Toast.makeText(this, "Club Created", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Clubs.class);
        startActivity(intent);
        finish();
    }
}