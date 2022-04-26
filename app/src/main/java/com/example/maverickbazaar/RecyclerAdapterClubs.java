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

public class RecyclerAdapterClubs extends RecyclerView.Adapter<RecyclerAdapterClubs.ImageViewHolder> {
    private int[] images;
    private String[] name,details;
    String callingActivity;
    private Context context;

    public RecyclerAdapterClubs(int[] images, String[] name, String [] details, Context context, String callingActivity){
        this.images=images;
        this.name=name;
        this.details=details;
        this.context=context;
        this.callingActivity=callingActivity;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_club,parent,false);
        ImageViewHolder imageViewHolder=new ImageViewHolder(view,context,images,name,details,callingActivity);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        int image_id=images[position];
        holder.img.setImageResource(image_id);
        holder.img_name.setText(name[position]);
        holder.img_det.setText(details[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        ImageView img;
        TextView img_det,img_name;
        Context context;
        int[] images;
        String[] details, name;
        String callingActivity;
        public ImageViewHolder(@NonNull View itemView, Context context, int[] images, String[] details, String[] name, String callingActivity) {
            super(itemView);
            img=itemView.findViewById(R.id.RelativeLayout);
            img_name=itemView.findViewById(R.id.clubName);
            img_det=itemView.findViewById(R.id.club_details);
            itemView.setOnClickListener(this);
            this.context=context;
            this.images = images;
            this.details = details;
            this.name = name;
            this.callingActivity= this.callingActivity;
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context,clubDisplay.class);
            System.out.println(callingActivity);
            intent.putExtra("image_id",images[getAdapterPosition()]);
            intent.putExtra("club_details",details[getAdapterPosition()]);
            intent.putExtra("club_name",name[getAdapterPosition()]);
            intent.putExtra("CALLING_ACTIVITY",callingActivity);
            context.startActivity(intent);
        }

    }
}
