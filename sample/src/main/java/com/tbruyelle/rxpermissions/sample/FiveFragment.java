package com.tbruyelle.rxpermissions.sample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import com.tbruyelle.rxpermissions.RxPermissions;

import rx.Observer;

import static android.content.ContentValues.TAG;

/**
 * Created by mahendra on 5/12/17.
 */

public class FiveFragment extends BaseFragment {

    private View view;
    private SurfaceView surfaceView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.act_fifth, container, false);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        askForPermissionToReadSMS(getActivity());

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

     /*   CAMERA(Manifest.permission.CAMERA, "Camera Permission", false),
    READ_SMS(Manifest.permission.READ_SMS, "SMS Permission", false),
    RECEIVE_SMS(Manifest.permission.RECEIVE_SMS, "SMS Permission", false),
    ACCESS_FINE_LOCATION(Manifest.permission.ACCESS_FINE_LOCATION, "Location Permission", true),
    RECORD_AUDIO(Manifest.permission.RECORD_AUDIO, "Microphone Permission", false),
    WRITE_EXTERNAL_STORAGE(Manifest.permission.WRITE_EXTERNAL_STORAGE, "External Storage Permission", true)*//*,*/

    private void askForPermissionToReadSMS(Activity activity) {
        getInstance(activity)
                .request(android.Manifest.permission.RECEIVE_SMS,
                        android.Manifest.permission.READ_SMS,
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.RECORD_AUDIO,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE

                )
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "oncomplete");
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError");
                    }


                    @Override
                    public void onNext(Boolean aBoolean) {
                        Log.d(TAG, "onNext");
                    }
                });
    }

    public RxPermissions getInstance(Activity activity) {
        RxPermissions rxPermissions = new RxPermissions(activity);
        rxPermissions.setLogging(true);
        return rxPermissions;
    }
}
