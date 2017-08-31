package com.madalinaloghin.activitiestest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityA extends BaseLogActivity {

    private final static String TAG = ActivityA.class.getSimpleName();

    private Button mBtnActiv2;

    @Override
    String getTag() {
        return TAG;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        mBtnActiv2 = (Button) findViewById(R.id.btn_activity2);
        mBtnActiv2.setText(getResources().getString(R.string.activity2));

        mBtnActiv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityBIntent = new Intent(ActivityA.this, ActivityB.class);
                startActivity(activityBIntent);
            }
        });
    }


}
