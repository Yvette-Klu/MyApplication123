package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class serviceAdapter extends RecyclerView.Adapter<serviceAdapter.ViewHolder> {
    private ArrayList<serviceModel> serviceModels;
    private ArrayList<Integer> mImages;


    private Context context;

    public serviceAdapter(ArrayList<serviceModel> serviceModels,ArrayList<Integer> mImages , Context context) {
        this.serviceModels = serviceModels;
        this.mImages = mImages;
        this.context = context;
    }

    @NonNull
    @Override
    public serviceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.service_list,parent,false);
        ViewHolder viewHolder = new serviceAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull serviceAdapter.ViewHolder holder, int position) {
        final  serviceModel model = serviceModels.get(position);
        holder.Date.setText(serviceModels.get(position).getDateCreated());
        holder.Id.setText(serviceModels.get(position).getId());
        holder.Title.setText(serviceModels.get(position).getTitle());
        Picasso.get().load(serviceModels.get(position).getImage()).into(holder.Image);
        Glide.with(context)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.Image);

        holder.image.setText(serviceModels.get(position).getImage());


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,dashboard.class);
                intent.putExtra("id",model.getId());
                intent.putExtra("Date",model.getDateCreated());
                intent.putExtra("Title",model.getTitle());
                intent.putExtra("image",model.getImage());




                context.startActivity(intent);
            }
        });





    }

    @Override
    public int getItemCount() {
        return serviceModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Image;
        TextView Title;
        TextView Date;
        TextView image;
        TextView Id;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.image);
            Title = itemView.findViewById(R.id.title);
            Id = itemView.findViewById(R.id.number);
            image = itemView.findViewById(R.id.Image);
            Date = itemView.findViewById(R.id.date);
            linearLayout = itemView.findViewById(R.id.linear);

        }
    }
}

