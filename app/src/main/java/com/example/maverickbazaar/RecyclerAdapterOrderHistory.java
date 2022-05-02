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

public class RecyclerAdapterOrderHistory extends RecyclerView.Adapter<RecyclerAdapterOrderHistory.MyViewHolder2> {
    Context context;
    ArrayList<orderInfo> list;


    public RecyclerAdapterOrderHistory(Context context, ArrayList<orderInfo> list){
        this.context = context;
        this.list=list;
    }

    @NonNull
    @Override
    public RecyclerAdapterOrderHistory.MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_history_list,parent,false);
        return new RecyclerAdapterOrderHistory.MyViewHolder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterOrderHistory.MyViewHolder2 holder, int position) {
        orderInfo currentOrder = list.get(position);


        holder.order.setText(currentOrder.getDate());
        holder.user.setText(currentOrder.getUser());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public static class MyViewHolder2 extends RecyclerView.ViewHolder{
        TextView order, user;
        public MyViewHolder2(@NonNull View itemView){
            super(itemView);
            order = itemView.findViewById(R.id.orderDateView);
            user  = itemView.findViewById(R.id.orderUserView);
        }
    }
}