package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateForm extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    String name, email, description;

    EditText nameInput;
    EditText emailInput;
    EditText descriptionInput;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_form);

        nameInput = (EditText) findViewById(R.id.nameInput);
        emailInput = (EditText) findViewById(R.id.emailInput);
        descriptionInput = (EditText) findViewById(R.id.descriptionInput);

        submitButton = (Button) findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(v -> {
           name = nameInput.getText().toString();
           email = emailInput.getText().toString();
           description = descriptionInput.getText().toString();

           Toast.makeText(getApplicationContext() , "Submitted!", Toast.LENGTH_SHORT).show();
           Intent intent = new Intent(v.getContext(), Clubs.class);
           startActivity(intent);
        });
    }

}