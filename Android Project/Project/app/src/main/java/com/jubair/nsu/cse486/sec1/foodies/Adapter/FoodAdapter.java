package com.jubair.nsu.cse486.sec1.foodies.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.jubair.nsu.cse486.sec1.foodies.Model.ItemModel;
import com.jubair.nsu.cse486.sec1.foodies.R;



public class FoodAdapter extends FirebaseRecyclerAdapter<ItemModel,FoodAdapter.myviewholder>{

    public FoodAdapter(@NonNull FirebaseRecyclerOptions<ItemModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull ItemModel model)
    {
        holder.foodName.setText(model.getName());
        holder.price.setText(model.getPrice());
        Glide.with(holder.img.getContext()).load(model.getPurl()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_chef,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView foodName,price;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.imgCard);
            foodName=(TextView)itemView.findViewById(R.id.foodnameText);
            price=(TextView)itemView.findViewById(R.id.priceShow);
        }
    }

}
