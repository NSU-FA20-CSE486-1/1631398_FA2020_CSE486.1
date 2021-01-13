package com.jubair.nsu.cse486.sec1.foodies.Chef;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.android.material.navigation.NavigationView;

import com.jubair.nsu.cse486.sec1.foodies.R;

public class Chef_Homepage extends AppCompatActivity {
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Menu menu;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_homepage);

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