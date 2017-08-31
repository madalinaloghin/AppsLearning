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
public class FragmentE extends DialogFragment {


    public FragmentE() {
        // Required empty public constructor
    }

    public static FragmentE newInstance(){
        FragmentE fragmentE = new FragmentE();
        return fragmentE;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_e, container, false);
    }

}
