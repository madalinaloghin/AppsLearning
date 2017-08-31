package com.madalinaloghin.activitiestest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityB extends BaseLogActivity {


    private final static String TAG = ActivityB.class.getSimpleName();

    private Button mBtnActiv1;
    private Button mBtnActiv3;

    @Override
    String getTag() {
        return TAG;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mBtnActiv1 = (Button) findViewById(R.id.btn_activity1);
        mBtnActiv1.setText(getResources().getString(R.string.activity1));

        mBtnActiv3 = (Button) findViewById(R.id.btn_activityC);
        mBtnActiv3.setText(getResources().getString(R.string.activity3));


        mBtnActiv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityAIntent = new Intent(ActivityB.this, ActivityA.class);
                startActivity(activityAIntent);
            }
        });

        mBtnActiv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityB.this, ActivityC.class));
            }
        });
    }

}
