package com.madalinaloghin.navigation.Fragments;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.madalinaloghin.navigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentF extends DialogFragment {


    public FragmentF() {
        // Required empty public constructor
    }

    public static FragmentF newInstance(){
        FragmentF fragmentF = new FragmentF();
        return fragmentF;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_f, container, false);
    }



}
