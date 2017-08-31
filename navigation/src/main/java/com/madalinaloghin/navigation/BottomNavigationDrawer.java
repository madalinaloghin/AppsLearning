package com.madalinaloghin.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.madalinaloghin.navigation.Fragments.FragmentA;
import com.madalinaloghin.navigation.Fragments.FragmentB;
import com.madalinaloghin.navigation.Fragments.FragmentC;
import com.madalinaloghin.navigation.Fragments.FragmentD;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BottomNavigationDrawer extends AppCompatActivity {

    private void replaceFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_bottom_activ, fragment).commitNow();

    }

    @BindView(R.id.btv_nav_bottom)
    BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_drawer);

        ButterKnife.bind(this);


        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_fragment_a:
                        replaceFragment(FragmentA.newInstance());
                        return true;

                    case R.id.navigation_fragment_b:
                        replaceFragment(FragmentB.newInstance());
                        return true;

                    case R.id.navigation_fragment_c:
                        replaceFragment(FragmentC.newInstance());
                        return true;

                    case R.id.navigation_fragment_d:
                        replaceFragment(FragmentD.newInstance());
                        return true;
                }
                return false;
            }
        });
        navigation.setSelectedItemId(R.id.navigation_fragment_a);
    }

    @Override
    public void overridePendingTransition(int enterAnim, int exitAnim) {
        super.overridePendingTransition(0, 0);
    }
}