package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        final ImageButton buttonStore = (ImageButton) findViewById(R.id.Store);
        buttonStore.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), Store.class);
            startActivity(intent);
        });

        final ImageButton buttonClubs = (ImageButton) findViewById(R.id.Clubs);
        buttonClubs.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Intent intent = new Intent(v.getContext(), Clubs.class);
            startActivity(intent);
        });

        final ImageButton buttonExchanges = (ImageButton) findViewById(R.id.makeExchanges);
        buttonExchanges.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Toast.makeText(HomeScreen.this, "Entering Exchange Screen", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), Exchanges.class);
            startActivity(intent);
        });

        final ImageButton buttonOrder = (ImageButton) findViewById(R.id.viewOrderHistory);
        buttonOrder.setOnClickListener(v -> {
            // Code here executes on main thread after user presses button
            Toast.makeText(HomeScreen.this, "Entering Order History Screen", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), orderHistoryList.class);
            startActivity(intent);
        });
        //fab for chats
        FloatingActionButton OpenComms = (FloatingActionButton) findViewById(R.id.ChatLinkButton);
        OpenComms.setOnClickListener(new View.OnClickListener(){
            public void onClick(View H){
                startActivity(new Intent(HomeScreen.this,ChatsMainActivity.class));
            }
        });

    }

}