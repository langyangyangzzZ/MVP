package com.example.myapplication.mvp.activity;

import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.mvp.bean.CodeBean;
import com.example.myapplication.mvp.bean.TokenBean;
import com.example.myapplication.mvp.frame.BaseMvpActivity;
import com.example.myapplication.mvp.model.TestModel;
import com.yiyatech.utils.ext.ToastUtils;

import static com.example.myapplication.mvp.frame.ApiConfig.TEXT_CODE;
import static com.example.myapplication.mvp.frame.ApiConfig.TOKEN_CODE;


public class MainActivity extends BaseMvpActivity<TestModel> {


    @Override
    public TestModel setModel() {
        //只需要返回你的model层就可以
        return new TestModel();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
            ToastUtils.show(MainActivity.this,123 + "");
    }

    @Override
    public void onSuccess(int whichApi, Object successResult) {

    }

}