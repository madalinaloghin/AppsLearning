package com.madalinaloghin.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.madalinaloghin.navigation.Fragments.FragmentA;
import com.madalinaloghin.navigation.Fragments.FragmentB;
import com.madalinaloghin.navigation.Fragments.FragmentC;
import com.madalinaloghin.navigation.Fragments.FragmentD;
import com.madalinaloghin.navigation.Fragments.FragmentE;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabsActivityWithAnther extends AppCompatActivity {

    @BindView(R.id.vp_tabs_activity_another)
    ViewPager mViewPagerTabs;

    private SectionPagerAdapter mSectionPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_with_anther);

        ButterKnife.bind(this);


        mSectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        mViewPagerTabs.setAdapter(mSectionPagerAdapter);

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
