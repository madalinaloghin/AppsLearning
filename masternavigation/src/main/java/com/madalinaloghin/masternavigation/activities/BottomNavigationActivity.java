package com.madalinaloghin.masternavigation.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.madalinaloghin.masternavigation.R;
import com.madalinaloghin.masternavigation.fragments.FragmentA;
import com.madalinaloghin.masternavigation.fragments.FragmentB;
import com.madalinaloghin.masternavigation.fragments.FragmentC;

public class BottomNavigationActivity extends AppCompatActivity {

    private void replaceFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commitNow();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_fragment_a:
                        replaceFragment(FragmentA.newInstance());
                        return true;
                    case R.id.navigation_fragment_b:
                        replaceFragment(FragmentB.newInstance("Message", "From Bottom Navigation"));
                        return true;
                    case R.id.navigation_fragment_c:
                        replaceFragment(FragmentC.newInstance());
                        return true;
                }
                return false;
            }
        });

        navigation.setSelectedItemId(R.id.navigation_fragment_a);
    }

}
