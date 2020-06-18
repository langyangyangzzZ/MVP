package com.example.myapplication.mvp.frame;

import android.text.TextUtils;

import com.example.myapplication.mvp.frame.convert.MyGsonConverterFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


public class NetManager {
    private static volatile NetManager sNetManager;

    private NetManager() {
    }

    public static NetManager getNetManager() {
        if (sNetManager == null) {//考虑效率问题
            synchronized (NetManager.class) {
                if (sNetManager == null) {//考虑多个线程问题
                    sNetManager = new NetManager();
                }
            }
        }
        return sNetManager;
    }

    public <T> INetService getNetService(T... t) {
        INetService service = new Retrofit.Builder()
                .baseUrl(t != null && t.length != 0 && !TextUtils.isEmpty((String) t[0]) ? (String) t[0] : Config.BASEURL)
                .addConverterFactory(MyGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(NetInterceptor.getNetInterceptor().getClientWithoutCache())
                .build().create(INetService.class);
        return service;
    }

    public <T> void method(Observable<T> pObservable, final int whichApi, final ICommonView presenterCallBack) {
        pObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver() {
                    @Override
                    public void onSuccess(Object value) {
                        presenterCallBack.onSuccess(whichApi, value);
                    }

                    @Override
                    public void onFailed(Throwable value) {
                        presenterCallBack.onFailed(whichApi, value);
                    }
                });
    }
    public static RequestBody getRequestBody(HashMap<String, String> hashMap) {
        StringBuffer data = new StringBuffer();
        if (hashMap != null && hashMap.size() > 0) {
            Iterator iter = hashMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                data.append(key).append("=").append(val).append("&");
            }
        }
        String jso = data.substring(0, data.length() - 1);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"),jso);

        return requestBody;
    }
}
