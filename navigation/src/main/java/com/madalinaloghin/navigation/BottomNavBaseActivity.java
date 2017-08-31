package com.madalinaloghin.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BottomNavBaseActivity extends AppCompatActivity {

    @BindView(R.id.btv_nav_bottom_tabs)
    BottomNavigationView navigation;

    @BindView(R.id.fl_parent)
    public FrameLayout flParent;


    protected void onCreate(Bundle savedInstanceState, final int layout) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav_with_tabs);

        ButterKnife.bind(this);

        View view = getLayoutInflater().inflate(layout, flParent, false);
        flParent.addView(view, 0);

        switch (getType()) {
            case SIMPLE:
                navigation.setSelectedItemId(R.id.navigation_activ_simple);
                break;
            case TABS:
                navigation.setSelectedItemId(R.id.navigation_activ_tabs);
                break;
        }

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.isChecked()) {
                    return false;
                }
                switch (item.getItemId()) {
                    case R.id.navigation_activ_simple:
                        startActivity(new Intent(BottomNavBaseActivity.this, SimpleActivity.class));
                        overridePendingTransition(R.animator.no_anim, R.animator.no_anim);
                        return true;

                    case R.id.navigation_activ_tabs:
                        startActivity(new Intent(BottomNavBaseActivity.this, BasicTabsActivity.class));
                        overridePendingTransition(R.animator.no_anim, R.animator.no_anim);
                        return true;
                }
                return false;
            }
        });


    }


    @Override
    public void onBackPressed()
    {
        //sa ma duca pe prima activ
        super.onBackPressed();
    }

    protected abstract BottomActivityType getType();

    public static enum BottomActivityType {
        SIMPLE,
        TABS
    }


}
