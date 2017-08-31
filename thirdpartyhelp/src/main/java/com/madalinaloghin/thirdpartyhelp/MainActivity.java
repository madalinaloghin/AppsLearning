package com.madalinaloghin.thirdpartyhelp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_images)
    public RecyclerView rvImages;

    private AdapterImages adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
    }


    private void setupRecyclerView(){

        List<Images> data  = Values.getDummyImagesList();
        adapter = new AdapterImages();
        adapter.setItems(data);

        rvImages.setLayoutManager(new LinearLayoutManager(this));
        rvImages.setAdapter(adapter);
    }

}
