package com.jubair.nsu.cse486.sec1.foodies.Customer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_AddItem;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Homepage;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Kitchen;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Profile;
import com.jubair.nsu.cse486.sec1.foodies.LandingPage;
import com.jubair.nsu.cse486.sec1.foodies.R;

public class Customer_Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_hompage);

        /*---------------------Navigation Drawer------------------------*/
        drawerLayout=findViewById(R.id.drawer_layout_chef);
        navigationView=findViewById(R.id.nav_view);

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
    }



    public void exploreItems(View v) {
        startActivity(new Intent(this, Customer_Items.class));
    }

    public void event(View v) {
        startActivity(new Intent(this, Customer_Event.class));
    }

    public void monthlyPlan(View v) {
        startActivity(new Intent(this, Customer_MonthlyPlan.class));
    }

    public void profile_customer(View v) {
        startActivity(new Intent(this, Customer_Profile.class));
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(this, Chef_Homepage.class);
                startActivity(intent);
                break;
            case R.id.nav_account:
                break;
            case R.id.nav_profile:
                Intent i = new Intent(this, Chef_Profile.class);
                startActivity(i);
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_logout:
                mFirebaseAuth.getInstance().signOut();
                Toast.makeText(Customer_Homepage.this, "Logged Out Successfully",Toast.LENGTH_SHORT).show();
                Intent i2 = new Intent(this, LandingPage.class);
                startActivity(i2);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

