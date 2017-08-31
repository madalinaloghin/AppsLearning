package com.madalinaloghin.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }



    @OnClick(R.id.btn_open_tabs_activ_another)
    void openTabsActivityAnother() {
        startActivity(new Intent(MainActivity.this, TabsActivityWithAnther.class));
    }


    @OnClick(R.id.btn_open_tabs_activ)
    void openTabsActivity() {
        startActivity(new Intent(MainActivity.this, TabsActivity.class));
    }

    @OnClick(R.id.btn_open_navigation_drawer_activ)
    void openNavigDrawerActivity() {
        startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
    }

    @OnClick(R.id.btn_open_bottom_navig_drawer)
    void openBottomDrawerActivity(){
        startActivity(new Intent(MainActivity.this, BottomNavigationDrawer.class));
    }

    @OnClick(R.id.btn_bottom_nav_with_tabs)
    void openBottomNavWithTabsIn(){
        startActivity(new Intent(MainActivity.this, SimpleActivity.class));
    }



}
