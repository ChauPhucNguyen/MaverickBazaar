package com.example.maverickbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddContacts extends AppCompatActivity {


    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com/");
    private final DatabaseReference mDatabaseReference = mDatabase.getReference().child("Contact Information:");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        EditText ContactName = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText ContactPhone = (EditText) findViewById(R.id.editTextPhone);
        Button EnterInfo = (Button) findViewById(R.id.SubmitButton);
        Button ReturnChatPg = (Button)findViewById(R.id.ReturnButton);


        CharSequence TestText = ("Submitted");
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        EnterInfo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String ContactFullName = ContactName.getText().toString();
                String CtPhone = ContactPhone.getText().toString();
                HashMap<String,String> ContactMap = new HashMap<>();
                ContactMap.put("Name",ContactFullName);
                ContactMap.put("phone",CtPhone);
                mDatabaseReference.push().setValue(ContactMap);
                Toast.makeText(context,TestText,duration).show();
            }
        });

        ReturnChatPg.setOnClickListener(new View.OnClickListener(){
            public void onClick(View r){
                startActivity(new Intent(AddContacts.this, MainActivity.class));
            }
        });

    }
}