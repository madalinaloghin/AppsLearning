package com.madalinaloghin.activitiestest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentA extends Fragment {


    private static final String TAG = "FragmentA";
    private static final String MESSAGE = "message";

    public FragmentA() {
    }

    public static FragmentA newInstance(@Nullable String message) {
        FragmentA fragment = new FragmentA();
        if(!TextUtils.isEmpty(message)){
            Bundle args = new Bundle();
            args.putString(MESSAGE, message);
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() calleg with: inflater = [ "+ inflater + " ], container = [ "+ container + "]. savedInstanceState = [ "+ savedInstanceState+ "] .");
        View contentView = inflater.inflate(R.layout.fragment_a, container, false);
        Bundle args = getArguments();
        if( args != null){
            String message  = args.getString(MESSAGE, "FragmentA");
            ((TextView) contentView.findViewById(R.id.tv_label_fragA)).setText(message);
        }
        return contentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyView() called ");
    }
}
