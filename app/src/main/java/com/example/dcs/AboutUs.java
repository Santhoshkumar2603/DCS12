package com.example.dcs;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class AboutUs extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        drawerLayout = findViewById(R.id.drawer_layout);
    }
    public  void ClickMenu(View view){
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickDashboard(View view){
        MainActivity.redirectActivity(this,Dashboard.class);
    }
    public void ClickAboutUs(View view){

        recreate();
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}