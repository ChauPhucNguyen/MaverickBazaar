package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final Button buttonStore = (Button) findViewById(R.id.Store);
        buttonStore.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), Store.class);
            startActivity(intent);
        });

        final Button buttonClubs = (Button) findViewById(R.id.Clubs);
        buttonClubs.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), Clubs.class);
            startActivity(intent);
        });

        final Button buttonExchanges = (Button) findViewById(R.id.homeExchangesButton);
        buttonExchanges.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Toast.makeText(HomeScreen.this, "Entering Exchange Screen", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), Exchanges.class);
            startActivity(intent);
        });

    }

}