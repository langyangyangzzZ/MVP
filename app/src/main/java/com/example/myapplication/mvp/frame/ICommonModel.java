package com.example.myapplication.mvp.frame;


public interface ICommonModel<P> {
    void getData(int whichApi, ICommonView presenterCallBack, P... params);
}
