package com.example.maverickbazaar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapterStore extends RecyclerView.Adapter<RecyclerAdapterStore.ImageViewHolder> {
    private int[] images;
    private String[] name;
    double[] prices;
    String callingActivity;
    private Context context;

    public RecyclerAdapterStore(int[] images, String[] name, double[] prices, Context context, String callingActivity){
        this.images=images;
        this.name=name;
        this.prices=prices;
        this.context=context;
        this.callingActivity=callingActivity;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ImageViewHolder imageViewHolder=new ImageViewHolder(view,context,images,name,prices,callingActivity);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int image_id=images[position];
        holder.img.setImageResource(image_id);
        holder.img_det.setText(name[position]);
        holder.img_price.setText(Double.toString(prices[position]));
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView img;
        TextView img_det,img_price;
        Context context;
        int[] images;
        String[] details;
        double[] prices;
        String callingActivity;
        public ImageViewHolder(@NonNull View itemView, Context context, int[] images, String[] details, double[] prices, String callingActivity) {
            super(itemView);
            img=itemView.findViewById(R.id.imageView);
            img_det=itemView.findViewById(R.id.item_name);
            img_price=itemView.findViewById(R.id.item_price);
            itemView.setOnClickListener(this);
            this.context=context;
            this.images=images;
            this.details=details;
            this.prices=prices;
            this.callingActivity= this.callingActivity;
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,itemDisplay.class);
            intent.putExtra("image_id",images[getAdapterPosition()]);
            intent.putExtra("item_name",details[getAdapterPosition()]);
            intent.putExtra("item_price",prices[getAdapterPosition()]);
            intent.putExtra("CALLING_ACTIVITY",callingActivity);
            context.startActivity(intent);
        }

    }
}