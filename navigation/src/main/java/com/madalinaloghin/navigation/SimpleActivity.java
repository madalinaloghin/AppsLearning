package com.madalinaloghin.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import static com.madalinaloghin.navigation.BottomNavBaseActivity.BottomActivityType.SIMPLE;

public class SimpleActivity extends BottomNavBaseActivity {

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_simple);
    }

    @Override
    protected BottomActivityType getType() {
        return SIMPLE;
    }

}
