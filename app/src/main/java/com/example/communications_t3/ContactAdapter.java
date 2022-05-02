package com.example.communications_t3;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.personsViewholder>{
    List<Contact> contactList;
    public ContactAdapter(List<Contact> contactList){
        this.contactList=contactList;
    }
    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent,int viewType)
    {
        View view
                = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_contact_adapter, parent, false);
        return new ContactAdapter.personsViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull personsViewholder holder, int position) {
        Contact model = contactList.get(position);
        holder.Cname.setText(model.getName());
        holder.PNumber.setText(model.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class personsViewholder
            extends RecyclerView.ViewHolder {
        TextView Cname, PNumber;
        //Cname.setText()
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);

            Cname = (TextView) itemView.findViewById(R.id.NameField);
            PNumber = (TextView) itemView.findViewById(R.id.PhoneField);

        }
    }
}
