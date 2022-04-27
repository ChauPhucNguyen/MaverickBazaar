package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.Key;

public class Checkout extends AppCompatActivity {

    ImageView imageView;
    TextView itemName,itemPrice,tax,total;
    ImageButton payments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        imageView = findViewById(R.id.item_display);
        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.SubTotal);
        tax = findViewById(R.id.Taxes);
        total = findViewById(R.id.Total);
        payments = findViewById(R.id.payment);

        itemPrice.setText(Double.toString(getIntent().getDoubleExtra("item_price",00)));
        tax.setText(Double.toString(getIntent().getDoubleExtra("item_tax",00)));
        total.setText(Double.toString(getIntent().getDoubleExtra("item_total",00)));

        final double item_total = getIntent().getDoubleExtra("item_total",00);

        payments.setOnClickListener(v -> {
            Intent intent=new Intent(Checkout.this,Payments.class);
            intent.putExtra("item_total",item_total);
            startActivity(intent);
        });




    }
}