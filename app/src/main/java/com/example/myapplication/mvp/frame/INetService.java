package com.example.myapplication.mvp.frame;

import com.example.myapplication.mvp.bean.CodeBean;
import com.example.myapplication.mvp.bean.TokenBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface INetService {

    //post请求
    @POST("APP/Public/sendsms")
    @FormUrlEncoded
    Observable<CodeBean> getCodeRRData(@Field("phone") String phone);

    @POST("APP/Public/get_token")
    Observable<TokenBean> getTokenBean(@Body RequestBody body);
}
