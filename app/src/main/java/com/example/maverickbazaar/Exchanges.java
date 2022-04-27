package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Exchanges extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchanges2);

        final Button mainActivityButton = findViewById(R.id.backButton);
        mainActivityButton.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), HomeScreen.class);
            startActivity(intent);
        });

        final Button makeExchangeButton = findViewById(R.id.makeExchangesButton);
        makeExchangeButton.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), exchangeMakeActivity.class);
            startActivity(intent);
        });

        final Button viewExchangeButton = findViewById(R.id.viewExchangesButton);
        viewExchangeButton.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), ExchangeList.class);
            startActivity(intent);
        });



    }

}