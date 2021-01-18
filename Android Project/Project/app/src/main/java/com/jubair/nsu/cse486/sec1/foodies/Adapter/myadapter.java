package com.jubair.nsu.cse486.sec1.foodies.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jubair.nsu.cse486.sec1.foodies.Model.model;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>
{
    ArrayList<model> datalist;

    public myadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_chef,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.foodName.setText(datalist.get(position).getName());
        holder.price.setText(datalist.get(position).getPrice());
        Glide.with(holder.img.getContext()).load(model.getImageUri()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView foodName,price;
        ImageView img;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            foodName=itemView.findViewById(R.id.foodnameText);
            price=itemView.findViewById(R.id.priceShow);
            img= (ImageView)itemView.findViewById(R.id.imgCard);
        }
    }
}
