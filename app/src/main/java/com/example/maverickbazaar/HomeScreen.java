package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final Button clubBtn = (Button) findViewById(R.id.Club);
        clubBtn.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), Clubs.class);
            startActivity(intent);
        });

        final Button storeBtn = (Button) findViewById(R.id.Store);
        storeBtn.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), Store.class);
            startActivity(intent);
        });

        final Button exchangeBtn = (Button) findViewById(R.id.Exchanges);
        exchangeBtn.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), Exchanges.class);
            startActivity(intent);
        });

    }
}