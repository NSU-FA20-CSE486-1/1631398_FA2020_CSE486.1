package com.jubair.nsu.cse486.sec1.foodies.Customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.jubair.nsu.cse486.sec1.foodies.Adapter.CustomerAdapter;
import com.jubair.nsu.cse486.sec1.foodies.Model.modelCustomer;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.ArrayList;
import java.util.List;

public class Customer_ShowItem extends AppCompatActivity {

    RecyclerView recview;
    ArrayList<modelCustomer> datalist;
    FirebaseFirestore db;
    CustomerAdapter adapter;
    FirebaseAuth mFirebaseAuth;
    String chefID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_show_item);


        recview=(RecyclerView)findViewById(R.id.recViewCustomer);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapter=new CustomerAdapter(datalist);
        recview.setAdapter(adapter);

   //     mFirebaseAuth = FirebaseAuth.getInstance();
   //     chefID = mFirebaseAuth.getCurrentUser().getEmail() ;

        db=FirebaseFirestore.getInstance();
        db.collection("Chef_Item").document(
                "1").collection("rohan123@gmail.com").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            modelCustomer obj1=d.toObject(modelCustomer.class);
                            datalist.add(obj1);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Customer_Items.class));
    }
}