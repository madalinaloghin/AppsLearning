package com.madalinaloghin.navigation;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.madalinaloghin.navigation.Fragments.FragmentA;
import com.madalinaloghin.navigation.Fragments.FragmentB;
import com.madalinaloghin.navigation.Fragments.FragmentC;
import com.madalinaloghin.navigation.Fragments.FragmentD;
import com.madalinaloghin.navigation.Fragments.FragmentE;
import com.madalinaloghin.navigation.Fragments.FragmentF;

import butterknife.ButterKnife;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        navigationView.getMenu().getItem(0).setChecked(true);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));

        getSupportActionBar().setTitle("FragmentA");
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.navigation_fragment_a:
                replaceFragment(FragmentA.newInstance(), "FragmentA");
                break;
            case R.id.navigation_fragment_b:
                replaceFragment(FragmentB.newInstance(), "FragmentB");
                break;
            case R.id.navigation_fragment_c:
                replaceFragment(FragmentC.newInstance(), "FragmentC");
                break;
            case R.id.navigation_fragment_d:
                replaceFragment(FragmentD.newInstance(), "FragmentD");
                break;
            case R.id.navigation_fragment_e:
                showDialogFragment(FragmentE.newInstance());
                break;
            case R.id.navigation_fragment_f:
                showDialogFragment(FragmentF.newInstance());
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    private void replaceFragment(@NonNull Fragment fragment, String title) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commitNow();
        toolbar.setTitle(title);
    }

    private void showDialogFragment(@NonNull DialogFragment dialogFragment) {
        dialogFragment.show(getSupportFragmentManager(), "");
    }
}
