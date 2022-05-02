package com.example.maverickbazaar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import android.os.Bundle;

public class RecyclerAdapterClubs extends RecyclerView.Adapter<RecyclerAdapterClubs.MyViewHolder> {
    Context context;
    ArrayList<clubInfo> list;


    public RecyclerAdapterClubs(Context context, ArrayList<clubInfo> list){
        this.context = context;
        this.list= list;
    }

    @NonNull
    @Override
    public RecyclerAdapterClubs.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_club,parent,false);
        return new RecyclerAdapterClubs.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterClubs.MyViewHolder holder, int position) {
        clubInfo currentClub = list.get(position);
        holder.clubName.setText(currentClub.getClub_name());
        holder.clubDetails.setText(currentClub.getClub_details());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView clubName, clubDetails;
        Context context;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            clubName = itemView.findViewById(R.id.tvClubNames);
            clubDetails  = itemView.findViewById(R.id.tvClubDetails);
            itemView.setOnClickListener(this);
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,itemDisplay.class);
            context.startActivity(intent);
        }
    }
}