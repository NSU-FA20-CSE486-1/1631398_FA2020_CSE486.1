package com.jubair.nsu.cse486.sec1.foodies.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jubair.nsu.cse486.sec1.foodies.Model.modelOrder;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.ArrayList;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.myviewholder>
{
    ArrayList<modelOrder> datalist;

    public OrderAdapter(ArrayList<modelOrder> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public OrderAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_test,parent,false);
        return new OrderAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.myviewholder holder, int position) {
        holder.menu.setText(datalist.get(position).getMenu());
        holder.quantity.setText(datalist.get(position).getQuantity());
        holder.date.setText(datalist.get(position).getEventDate());
        holder.amount.setText(datalist.get(position).getTotalAmount());
        holder.name.setText(datalist.get(position).getCustomerName());
        holder.phone.setText(datalist.get(position).getCustomerPhone());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView menu,quantity,date,amount,name,phone;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            menu=(TextView)itemView.findViewById(R.id.setType);
            quantity=(TextView)itemView.findViewById(R.id.showQuantity);
            date=(TextView)itemView.findViewById(R.id.showDate);
            amount=(TextView)itemView.findViewById(R.id.showAmount);
            name=(TextView)itemView.findViewById(R.id.showName);
            phone=(TextView)itemView.findViewById(R.id.showPhone);
        }
    }

}
