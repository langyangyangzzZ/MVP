package com.example.myapplication.mvp.frame;

import java.lang.ref.WeakReference;


public class BasePresenter<V extends ICommonView, M extends ICommonModel> {
    private WeakReference<V> mView;
    private WeakReference<M> mModel;

    public void bind(V pView, M pModel) {
        mModel = new WeakReference<>(pModel);
        mView = new WeakReference<>(pView);
    }

    public void unBind() {
        if (mView != null){
            mView.clear();
            mView = null;
        }
        if (mModel != null){
            mModel.clear();
            mModel = null;
        }
    }

    public V getView() {
        return mView != null ? mView.get() : null;
    }

    public M getModel(){
        return mModel != null ? mModel.get() : null;
    }

}
