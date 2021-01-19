package com.jubair.nsu.cse486.sec1.foodies.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jubair.nsu.cse486.sec1.foodies.Model.modelTest;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.myviewholder>
{
    ArrayList<modelTest> datalist;

    public TestAdapter(ArrayList<modelTest> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public TestAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow_test,parent,false);
        return new TestAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestAdapter.myviewholder holder, int position) {
        holder.menu.setText(datalist.get(position).getMenu());
        holder.name.setText(datalist.get(position).getCustomerName());
   //     holder.amount.setText(datalist.get(position).getTotalAmount());
        holder.date.setText(datalist.get(position).getEventDate());
        holder.quantity.setText(datalist.get(position).getQuantity());
        holder.phone.setText(datalist.get(position).getCustomerPhone());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView menu,name,date,quantity,phone;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            menu=(TextView)itemView.findViewById(R.id.setType);
            name=(TextView)itemView.findViewById(R.id.showName);
  //          amount=(TextView)itemView.findViewById(R.id.showAmount);
            date=(TextView)itemView.findViewById(R.id.showDate);
            quantity=(TextView)itemView.findViewById(R.id.showQuantity);
            phone=(TextView)itemView.findViewById(R.id.showPhone);
        }
    }

}
