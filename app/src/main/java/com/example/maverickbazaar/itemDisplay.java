package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class itemDisplay extends AppCompatActivity {

    ImageView imageView;
    TextView name, price;
    Button order;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_display);

        imageView = findViewById(R.id.itemDisplay);
        name = findViewById(R.id.itemName);
        price = findViewById(R.id.itemPrice);
        order = findViewById(R.id.placeOrder);

        imageView.setImageResource((getIntent().getIntExtra("image_id",00)));
        name.setText(getIntent().getStringExtra("item_name"));
        price.setText(Double.toString(getIntent().getDoubleExtra("item_price",00)));

        final String item_name = getIntent().getStringExtra("item_name");
        final int img = getIntent().getIntExtra("imageID", 00);
        final double item_price = getIntent().getDoubleExtra("item_price",00);
        final double item_tax = 0.37;
        final double item_total = 6.36;

        order.setOnClickListener(v -> {
            Intent intent=new Intent(itemDisplay.this,Checkout.class);
            intent.putExtra("item_name",item_name);
            intent.putExtra("image_ID",img);
            intent.putExtra("item_price",item_price);
            intent.putExtra("item_tax",item_tax);
            intent.putExtra("item_total",item_total);
            startActivity(intent);
        });
    }
}