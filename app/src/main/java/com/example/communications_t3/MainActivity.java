package com.example.communications_t3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance("https://maverickbazaar-default-rtdb.firebaseio.com/");
    private final DatabaseReference mDatabaseReference = mDatabase.getReference().child("Contact Information:");
    private ListView ContactInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactInfoList = (ListView) findViewById(R.id.ContactsList);
        FloatingActionButton fabAddCont = (FloatingActionButton) findViewById(R.id.fabRequests);
        FloatingActionButton AddContact = (FloatingActionButton) findViewById(R.id.fabAddCont);
        //add listeners for the fabs - start with requests - needs to open a new activity
        fabAddCont.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Requests.class));
            }
        });
        //listener for the add contacts activity
        AddContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View z) {
                startActivity(new Intent(MainActivity.this, AddContacts.class));
            }
        });
        //create the chat shit here:
        //check if there exists any values in the DB - if not: let user know, else don't really do anything
        CharSequence noContWarning = ("No Contacts Exist, Add Some Friends!");
        Context context2 = getApplicationContext();
        int duration2 = Toast.LENGTH_LONG;
        DatabaseReference peopleReference = FirebaseDatabase.getInstance().getReference().child("Contact Information:");
        //ContactInfoList.setAdapter(new FirebaseListAdapter<Contact>(this, Contact.class, android.R.layout.two_line_list_item, peopleReference));
    }
}