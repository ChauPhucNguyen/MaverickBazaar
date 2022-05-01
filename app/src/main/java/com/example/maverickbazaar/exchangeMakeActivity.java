package com.example.maverickbazaar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class exchangeMakeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange_make);



        Button makeExchangeButton = findViewById(R.id.postExchangeButton);

        mAuth = FirebaseAuth.getInstance();

        makeExchangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeExchange();
            }
        });
    }

    private void makeExchange() {

        EditText headerInputEdit = findViewById(R.id.headerInput);
        EditText bodyInputEdit = findViewById(R.id.bodyInput);

        String headerInput = headerInputEdit.getText().toString();
        String bodyInput = bodyInputEdit.getText().toString();

        //String id = reference.push().getKey();

        if (headerInput.isEmpty() || bodyInput.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_LONG).show();
            return;
        }

        if(appropriateExchange(headerInput)||appropriateExchange(bodyInput)){
            Toast.makeText(this, "This exchange contains profane words, please revise it.", Toast.LENGTH_LONG).show();
            return;
        }

        exchangeInfo exchange = new exchangeInfo(headerInput,bodyInput);
        rootNode = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com");

        reference = rootNode.getReference("exchanges");
        reference.push().setValue(exchange);
        Toast.makeText(getApplicationContext() , "Exchange has been made", Toast.LENGTH_SHORT).show();

        showMainActivity();
    }

    private boolean appropriateExchange(String stringInput){
        String[] profanities = {"fuck", "shit", "faggot", "retard", "porn", "TESTINGCASE1"};
        //Yes, these are bad words, but this is going to help prevent bad words in the future, except TESTINGCASE1

        for(String regex: profanities){
            if(stringInput.contains(regex)){
                return true;
            }
        }

        return false;
    }



    private void showMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}