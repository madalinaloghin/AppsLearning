package com.madalinaloghin.scrollandrecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.madalinaloghin.scrollandrecycler.recycler_view.RecyclerViewCats;
import com.madalinaloghin.scrollandrecycler.scroll_view.ScrollView;

public class MainActivity extends AppCompatActivity {


    TextView m_tv_scrollview;
    TextView m_tv_recyclerview;
    TextView m_tv_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_tv_recyclerview = (TextView) findViewById(R.id.tv_recyclerview);
        m_tv_scrollview = (TextView) findViewById(R.id.tv_scrollview);
        m_tv_long = (TextView) findViewById(R.id.tv_scroll_text_mains);
        m_tv_long.setMovementMethod(new ScrollingMovementMethod());

        m_tv_recyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RecyclerViewCats.class));
            }
        });

        m_tv_scrollview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScrollView.class));
            }
        });


    }
}
