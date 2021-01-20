package com.jubair.nsu.cse486.sec1.foodies.Chef;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.jubair.nsu.cse486.sec1.foodies.Adapter.TestAdapter;
import com.jubair.nsu.cse486.sec1.foodies.Model.modelTest;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.ArrayList;
import java.util.List;

public class Chef_Homepage extends AppCompatActivity {

    RecyclerView recview;
    ArrayList<modelTest> datalist;
    FirebaseFirestore db;
    TestAdapter adapter;

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Menu menu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_homepage);


        recview=(RecyclerView)findViewById(R.id.recViewHome);
        recview.setLayoutManager(new LinearLayoutManager(this));
        datalist=new ArrayList<>();
        adapter=new TestAdapter(datalist);
        recview.setAdapter(adapter);

     //   mFirebaseAuth = FirebaseAuth.getInstance();
        //    chefID = mFirebaseAuth.getCurrentUser().getEmail() ;

        db=FirebaseFirestore.getInstance();
        db.collection("Orders").document(
                "Event").collection("rohan123@gmail.com").get()
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






        /*---------------------Hooks------------------------*/
   //     drawerLayout=findViewById(R.id.drawer_layout_chef);
   //     navigationView=findViewById(R.id.nav_view);
   //     textView=findViewById(R.id.textView);
    }



    public void myKitchen(View v) {
        startActivity(new Intent(Chef_Homepage.this, Chef_Kitchen.class));
    }

    public void payments(View v) {
      //  startActivity(new Intent(MainActivity.this, Chef_login.class));
    }

    public void profile(View v) {
        startActivity(new Intent(this, Chef_Profile.class));
    }




}