package com.madalinaloghin.masterwidgets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvGotoLinearLayout;
    private TextView tvGotoRelativeLayout;
    private TextView tvGotoFrameLayout;
    private TextView tvGotoCardView;
    private TextView tvGotoMultipleLayouts;
    private TextView tvGotoProgrammaticViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setViewsActions();
    }

    private void initViews() {
        tvGotoMultipleLayouts = (TextView) findViewById(R.id.tv_multiple_layouts);
        tvGotoLinearLayout = (TextView) findViewById(R.id.tv_linearlayout);
        tvGotoRelativeLayout = (TextView) findViewById(R.id.tv_relativelayout);
        tvGotoFrameLayout = (TextView) findViewById(R.id.tv_framelayout);
        tvGotoCardView = (TextView) findViewById(R.id.tv_cardview);
        tvGotoProgrammaticViews = (TextView) findViewById(R.id.tv_programmatic_views);
    }

    private void setViewsActions() {
        tvGotoFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FrameLayoutActivity.class));
            }
        });

        tvGotoRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RelativeLayoutActivity.class));
            }
        });

        tvGotoLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class));
            }
        });

        tvGotoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardViewActivity.class));
            }
        });

        tvGotoProgrammaticViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProgrammaticViewsActivity.class));
            }
        });
    }
}
