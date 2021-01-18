package com.jubair.nsu.cse486.sec1.foodies.Chef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import com.google.firebase.auth.FirebaseAuth;
import com.jubair.nsu.cse486.sec1.foodies.Adapter.FoodAdapter;
import com.jubair.nsu.cse486.sec1.foodies.Adapter.myadapter;
import com.jubair.nsu.cse486.sec1.foodies.MainActivity;
import com.jubair.nsu.cse486.sec1.foodies.Model.ItemModel;
import com.jubair.nsu.cse486.sec1.foodies.Model.model;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.ArrayList;
import java.util.List;

public class Chef_Kitchen extends AppCompatActivity {
//    RecyclerView recview;
//    FoodAdapter adapter;

    RecyclerView recview;
    ArrayList<model> datalist;
    FirebaseFirestore db;
    myadapter adapter;
    FirebaseAuth mFirebaseAuth;
    String chefID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_kitchen);


        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapter=new myadapter(datalist);
        recview.setAdapter(adapter);

        mFirebaseAuth = FirebaseAuth.getInstance();
        chefID = mFirebaseAuth.getCurrentUser().getEmail() ;

        db=FirebaseFirestore.getInstance();
        db.collection("Chef_Item").document(
                "1").collection(chefID).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                        for(DocumentSnapshot d:list)
                        {
                            model obj=d.toObject(model.class);
                            datalist.add(obj);
                        }
                        adapter.notifyDataSetChanged();
                    }
                });

/*
        recview=(RecyclerView)findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ItemModel> options =
                new FirebaseRecyclerOptions.Builder<ItemModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Chef_Item"), ItemModel.class)
                        .build();

        adapter=new FoodAdapter(options);
        recview.setAdapter(adapter);
*/

    }






    public void addItem(View v) {
        startActivity(new Intent(Chef_Kitchen.this, Chef_AddItem.class));
    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Chef_Homepage.class));
    }


}