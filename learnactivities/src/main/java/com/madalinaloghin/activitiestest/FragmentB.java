package com.madalinaloghin.activitiestest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentB extends Fragment {
    private static final String TAG = "FragmentB";
    private static final String MESSAGE = "message";

    private Button btn_activ2Fragment;
    public FragmentB() {
    }

    public static FragmentB newInstance(@Nullable String message) {
        FragmentB fragment = new FragmentB();
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
        final View contentView = inflater.inflate(R.layout.fragment_b, container, false);

        btn_activ2Fragment = contentView.findViewById(R.id.btn_fragmentb);

        Bundle args = getArguments();
        if( args != null){
            String message  = args.getString(MESSAGE, "FragmentB");
            ((TextView) contentView.findViewById(R.id.tv_label)).setText(message);
        }

        btn_activ2Fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ActivityB.class));
            }
        });

        return contentView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroyView() called ");
    }
}
