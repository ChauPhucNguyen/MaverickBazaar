package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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
        price.setText(Integer.toString(getIntent().getIntExtra("item_price",00)));

        final String item_name = getIntent().getStringExtra("item_details");
        final int img = getIntent().getIntExtra("imageID", 00);
        final int item_price = getIntent().getIntExtra("item_price",00);

        order.setOnClickListener(v -> {
            Intent intent=new Intent(itemDisplay.this,Checkout.class);
            intent.putExtra("Item_Name",item_name);
            intent.putExtra("imageID",img);
            intent.putExtra("Item_Name",item_price);
            startActivity(intent);
        });

    }
}