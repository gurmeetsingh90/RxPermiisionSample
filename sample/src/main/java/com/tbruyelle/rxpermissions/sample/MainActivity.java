package com.tbruyelle.rxpermissions.sample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tbruyelle.rxpermissions.RxPermissionsFragment;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxPermissionsSample";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        MainFragment mainFragment = (MainFragment) getFragmentManager().findFragmentById(R.id.container);
        replaceFragmentWithDefaultAnimation(new WeakReference<Activity>(MainActivity.this), mainFragment, null, "mainfrag", true);
    }


    public void replaceFragmentWithDefaultAnimation(WeakReference<Activity> act,
                                                    Fragment fragment,
                                                    Bundle datas,
                                                    String fragTag, boolean addToBackstack) {
        FragmentManager fragmentManager = ((Activity) act.get()).getFragmentManager();

        FragmentTransaction transaction =
                fragmentManager.beginTransaction();
        if (datas != null) {
            fragment.setArguments(datas);
        }
        transaction.replace(((Activity) act.get()).findViewById(R.id.container).getId(),
                fragment,
                fragTag);
        if (addToBackstack) {
            transaction.addToBackStack(fragTag);
        }
        transaction.show(fragment);
        transaction.commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }



}
