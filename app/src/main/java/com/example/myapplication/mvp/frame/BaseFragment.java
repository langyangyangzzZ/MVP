package com.example.myapplication.mvp.frame;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 史振江 on 2019/10/27.
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    public Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initMvp();
        initData();
        initListener();
        return view;
    }

    public void initListener() {

    }

    public void initData() {

    }

    public void initMvp() {

    }

    public void initView() {

    }

    public abstract int getLayoutId();


    public void showLog(String msg){
        Log.d(getClass().getSimpleName(),msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }
}
