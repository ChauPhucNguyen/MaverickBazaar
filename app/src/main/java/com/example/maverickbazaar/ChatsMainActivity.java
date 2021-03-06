package com.example.maverickbazaar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatsMainActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com/");
    private final DatabaseReference mDatabaseReference = mDatabase.getReference().child("Contact Information:");
    private RecyclerView ContactInfoList;
    ContactAdapter adapter;
    FloatingActionButton AddContact = (FloatingActionButton) findViewById(R.id.fabAddCont);
    FloatingActionButton fabTextTest = (FloatingActionButton) findViewById(R.id.fabTextTest);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View z) {
                startActivity(new Intent(ChatsMainActivity.this, AddContacts.class));
            }
        });


        fabTextTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ChatsMainActivity.this, Text.class));
            }
        });


        CharSequence noContWarning = ("No Contacts Exist, Add Some Friends!");
        Context context2 = getApplicationContext();
        int duration2 = Toast.LENGTH_LONG;
        ContactInfoList = findViewById(R.id.ContactsList);
        ContactInfoList.setLayoutManager(new LinearLayoutManager(this));

        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean dataExists = snapshot.exists();
                Log.e("Exists?",String.valueOf(dataExists));
                Log.e("String Data",String.valueOf(snapshot.hasChildren()));

                List<Contact> contList = new ArrayList<Contact>();

                for (DataSnapshot child : snapshot.getChildren()) {
                    Log.e("Child",child.toString());
                    //Log.e("Child has children?",String.valueOf(child.hasChildren()));
                    String name = "";
                    String phnNo = "";
                    for (DataSnapshot contactChild:child.getChildren()) {
                        Log.e("Property",contactChild.getValue(String.class));
                        if(contactChild.getKey().equals("Name")){
                            name=contactChild.getValue(String.class);
                        }
                        else{
                            phnNo=contactChild.getValue(String.class);
                        }

                    }
                    Contact newPerson = new Contact(name,phnNo);
                    contList.add(newPerson);
                    Log.e("Check:",newPerson.getName() + " " + newPerson.getPhoneNumber());


                }
                Log.e("List Check",String.valueOf(contList.size()));
                //FirebaseRecyclerOptions<Contact>options=new FirebaseRecyclerOptions.Builder<Contact>().setQuery(mDatabaseReference,Contact.class).build();
                adapter=new ContactAdapter(contList);
                ContactInfoList.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Exitsts?", error.getDetails());
            }
        };
        mDatabaseReference.addValueEventListener(postListener);
    }
}