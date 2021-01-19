package com.jubair.nsu.cse486.sec1.foodies.Chef;

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
import com.jubair.nsu.cse486.sec1.foodies.Adapter.OrderAdapter;
import com.jubair.nsu.cse486.sec1.foodies.Adapter.TestAdapter;
import com.jubair.nsu.cse486.sec1.foodies.Model.modelOrder;
import com.jubair.nsu.cse486.sec1.foodies.Model.modelTest;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.ArrayList;
import java.util.List;

public class Chef_Orders extends AppCompatActivity {
    RecyclerView recview;
    ArrayList<modelTest> datalist;
    FirebaseFirestore db;
    TestAdapter adapter;
 //   FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_orders);

        recview=(RecyclerView)findViewById(R.id.recViewOrders);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapter=new TestAdapter(datalist);
        recview.setAdapter(adapter);

     //   mFirebaseAuth = FirebaseAuth.getInstance();
        //    chefID = mFirebaseAuth.getCurrentUser().getEmail() ;

        db=FirebaseFirestore.getInstance();
        db.collection("Orders").document(
                "Event").collection("sayem123@gmail.com").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            modelTest obj=d.toObject(modelTest.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });


    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Chef_Homepage.class));
    }
}