package com.example.maverickbazaar;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.List;


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
