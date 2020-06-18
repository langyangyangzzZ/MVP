package com.example.myapplication.mvp.frame;

public interface ICommonView<S> {
    void onSuccess(int whichApi, S successResult);
    void onFailed(int whichApi, Throwable failedResult);
}
