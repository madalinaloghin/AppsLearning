package com.madalinaloghin.scrollandrecycler.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.madalinaloghin.scrollandrecycler.R;

import java.util.List;

/**
 * Created by madalina.loghin on 7/17/2017.
 */

public class RecyclerViewCats extends AppCompatActivity {

    private RecyclerView m_rv_cats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        m_rv_cats = (RecyclerView) findViewById(R.id.rv_recycler_view);
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        m_rv_cats.setLayoutManager(new GridLayoutManager(this, 2));
       // m_rv_cats.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        List<Cat> data = Cat.createCatsList();

        AdapterCats adapter = new AdapterCats(data);
        m_rv_cats.setAdapter(adapter);
    }


}
