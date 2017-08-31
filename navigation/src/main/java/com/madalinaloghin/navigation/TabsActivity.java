package com.madalinaloghin.navigation;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.madalinaloghin.navigation.Fragments.FragmentA;
import com.madalinaloghin.navigation.Fragments.FragmentB;
import com.madalinaloghin.navigation.Fragments.FragmentC;
import com.madalinaloghin.navigation.Fragments.FragmentD;
import com.madalinaloghin.navigation.Fragments.FragmentE;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabsActivity extends AppCompatActivity {

    private SectionPagerAdapter mSectionPagerAdapter;

    @BindView(R.id.vp_tabs_activity)
    ViewPager mViewPagerTabs;

    @BindView(R.id.tl_tabs)
    TabLayout mTabLayout;


    // @BindView(R.id.toolbar)
    // Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        ButterKnife.bind(this);

        //   setSupportActionBar(mToolbar);

        mSectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        mTabLayout.setupWithViewPager(mViewPagerTabs);
        mViewPagerTabs.setAdapter(mSectionPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FragmentA.newInstance();
                case 1:
                    return FragmentB.newInstance();
                case 2:
                    return FragmentC.newInstance();
                case 3:
                    return FragmentD.newInstance();
                default:
                    return FragmentE.newInstance();
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Fragment A";
                case 1:
                    return "Fragment B";
                case 2:
                    return "Fragment C";
                case 3:
                    return "Fragment D";
            }
            return null;
        }


    }


}
