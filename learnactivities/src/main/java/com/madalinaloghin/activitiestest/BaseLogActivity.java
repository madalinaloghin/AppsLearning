package com.madalinaloghin.activitiestest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by madalina.loghin on 7/13/2017.
 */

public abstract class BaseLogActivity extends AppCompatActivity {


    abstract String getTag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getTag(), "onCreate() method called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(getTag(), "onStart() method called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getTag(), "onResume() method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getTag(), "onPause() method called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(getTag(), "onStop() method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getTag(), "onDestroy() method called");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(getTag(), "onActivityResult() method called");
    }
}
