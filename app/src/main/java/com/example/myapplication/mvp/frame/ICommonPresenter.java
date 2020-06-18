package com.example.myapplication.mvp.frame;


public interface ICommonPresenter<P> {
    void getData(int whichApi, P... params);
}
