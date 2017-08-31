package com.madalinaloghin.activitiestest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class ActivityC extends FragmentActivity{

    private final static String FRAGMENT_B_TAG = "fragmentB";
    private final static String FRAGMENT_A_TAG = "fragmentA";

    private Button mSwitchFragments;
    private Button mSwitchFragmentImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        if(savedInstanceState == null){
            FragmentB fragmentB = FragmentB.newInstance("Message from ActivityC ");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.layout_container, fragmentB, FRAGMENT_B_TAG);
            fragmentTransaction.commitNow();
        }

        mSwitchFragments = (Button) findViewById(R.id.btn_switch_fragment);
        mSwitchFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentA fragmentA = FragmentA.newInstance("This is fragment A ^^ ");
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.layout_container, fragmentA, FRAGMENT_A_TAG);
                fragmentTransaction2.commitNow();
            }
        });

        mSwitchFragmentImage = (Button) findViewById(R.id.btn_switch_fragment_image);
        mSwitchFragmentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentC fragmentC = FragmentC.newInstance();
                FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction3.replace(R.id.layout_container, fragmentC);
                fragmentTransaction3.commitNow();
            }
        });


    }
}
