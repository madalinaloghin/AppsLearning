package com.madalinaloghin.masternavigation.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.madalinaloghin.masternavigation.R;


public class FragmentF extends DialogFragment {

    public static FragmentF newInstance() {
        FragmentF fragment = new FragmentF();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_f, container, false);
    }
}
