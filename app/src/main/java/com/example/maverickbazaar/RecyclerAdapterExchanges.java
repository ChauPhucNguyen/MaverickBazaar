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

public class RecyclerAdapterExchanges extends RecyclerView.Adapter<RecyclerAdapterExchanges.MyViewHolder>{
    Context context;
    ArrayList<exchangeInfo> list;


    public RecyclerAdapterExchanges(Context context, ArrayList<exchangeInfo> list){
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.exchangelayout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        exchangeInfo currentExchange = list.get(position);


        holder.header.setText(currentExchange.getHeader());
        holder.body.setText(currentExchange.getBody());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView header, body;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            header= itemView.findViewById(R.id.headerView);
            body  = itemView.findViewById(R.id.bodyView);
        }
    }
}
