package com.madalinaloghin.masterwidgets;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class CollageActivity extends AppCompatActivity {
    private static final int GRID_COLUMNS_NUMBER = 3;
    
    private RecyclerView rvColorsList;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_collage);
        
        initViews();
        setUpRecyclerView();
    }
    
    private void initViews() {
        // TODO: 3/18/17 findViewById
    }
    
    private void setUpRecyclerView() {
        // TODO: 3/18/17 to be completed in class
    }
}
