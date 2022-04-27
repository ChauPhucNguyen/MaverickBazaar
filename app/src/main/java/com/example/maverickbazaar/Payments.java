package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Payments extends AppCompatActivity {

    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        total=findViewById(R.id.item_total);
        total.setText(Double.toString(getIntent().getDoubleExtra("item_total",00)));

    }
}