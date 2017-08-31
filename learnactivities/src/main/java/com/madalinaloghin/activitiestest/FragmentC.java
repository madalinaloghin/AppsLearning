package com.madalinaloghin.activitiestest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentC extends Fragment {

    private static final String TAG = "FragmentC";


    public FragmentC() {
    }

    public static FragmentC newInstance() {
        FragmentC fragment = new FragmentC();
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView() calleg with: inflater = [ "+ inflater + " ], container = [ "+ container + "]. savedInstanceState = [ "+ savedInstanceState+ "] .");
        View contentView = inflater.inflate(R.layout.fragment_c, container, false);
        return contentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyView() called ");
    }

}
