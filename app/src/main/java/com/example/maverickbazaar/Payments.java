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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class Payments extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase rootNode;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        EditText cardName = (EditText) findViewById(R.id.cardName);
        EditText cardNumber = (EditText) findViewById(R.id.cardNumber);
        EditText cardCVV = (EditText) findViewById(R.id.cardCVV);
        EditText cardExpiration = (EditText) findViewById(R.id.cardExpiration);

        Button Debit = findViewById(R.id.selectDebit);
        Debit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Payments.this,"Debit option has been selected",Toast.LENGTH_SHORT).show();
            }
        });

        Button Credit = findViewById(R.id.selectCredit);
        Credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Payments.this,"Credit option has been selected",Toast.LENGTH_SHORT).show();
            }
        });

        Button Pay = (Button) findViewById(R.id.placeOrder);
        Pay.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String cardNameString = cardName.getText().toString();
                String cardNumberString = cardNumber.getText().toString();
                String cardCVVString = cardCVV.getText().toString();
                String cardExpirationString = cardExpiration.getText().toString();

                if(cardNameString.equals("John") && cardNumberString.equals("123") && cardCVVString.equals("420") && cardExpirationString.equals("4/20")){
                    Toast.makeText(Payments.this,"Successful payment, order has been made",Toast.LENGTH_SHORT).show();

                    //This is an addition to allow the user to make an order thru this class specifically
                    makeOrder();

                    switchMainActivity();
                }
                else{
                    Toast.makeText(Payments.this,"Invalid information, please try again",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void makeOrder() {
        mAuth = FirebaseAuth.getInstance();

        String currentDate, currentUserString;

        //TODO: Find the date and find the user
        Date currentTime = Calendar.getInstance().getTime();
        currentDate = currentTime.toString();


        rootNode = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com");


        FirebaseUser currentUser = mAuth.getCurrentUser();
        currentUserString = currentUser.getEmail();


        orderInfo userOrder = new orderInfo(currentDate, currentUserString);

        reference = rootNode.getReference("orders");
        reference.push().setValue(userOrder);
    }

    private void switchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}