package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class clubDisplay extends AppCompatActivity {

    ImageView imageView;
    TextView name, detail;
    Button join;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_display);

        name = findViewById(R.id.clubName);
        detail = findViewById(R.id.clubDetails);
        join = findViewById(R.id.joinClub);

        name.setText(getIntent().getStringExtra("club_name"));
        detail.setText(getIntent().getStringExtra("club_details"));

        final String club_name = getIntent().getStringExtra("club_name");
        final String club_details = getIntent().getStringExtra("club_details");

        join.setOnClickListener(v -> {
            Toast.makeText(clubDisplay.this, "You have joined the club", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(clubDisplay.this, clubList.class);
            startActivity(intent);
        });
    }
}