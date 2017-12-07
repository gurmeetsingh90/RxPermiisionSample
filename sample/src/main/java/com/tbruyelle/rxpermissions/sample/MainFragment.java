package com.tbruyelle.rxpermissions.sample;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

/**
 * Created by mahendra on 29/11/17.
 */

public class MainFragment extends BaseFragment implements View.OnClickListener {


    private View view;
    private SurfaceView surfaceView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.act_main, container, false);
        initBtnClickListner();

        return view;
    }

    private void initBtnClickListner() {
        view.findViewById(R.id.fragment_one).setOnClickListener(this);
        view.findViewById(R.id.fragment_two).setOnClickListener(this);
        view.findViewById(R.id.fragment_three).setOnClickListener(this);
        view.findViewById(R.id.fragment_four).setOnClickListener(this);
        view.findViewById(R.id.fragment_five).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onClick(View view) {

        BaseFragment baseFragment = null;

        switch (view.getId()) {
            case R.id.fragment_one:
                baseFragment = new FirstFragment();

                break;

            case R.id.fragment_two:

                baseFragment = new SecondFragment();
                break;

            case R.id.fragment_three:

                baseFragment = new ThirdFragment();
                break;

            case R.id.fragment_four:

                baseFragment = new FourthFragment();
                break;
            case R.id.fragment_five:

                baseFragment = new FiveFragment();
                break;

        }
        ((MainActivity) getActivity()).replaceFragmentWithDefaultAnimation(new WeakReference<Activity>(getActivity()), baseFragment, null, "secondfrag", true);

    }
}
