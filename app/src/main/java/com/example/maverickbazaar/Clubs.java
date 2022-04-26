package com.example.maverickbazaar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Clubs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        final Button button = (Button) findViewById(R.id.buttonFormClub);
        button.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Toast.makeText(getApplicationContext() , "Opening Form", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), CreateForm.class);
            startActivity(intent);
        });
    }
}