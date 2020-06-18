package com.example.myapplication.mvp.model;

import com.example.myapplication.mvp.frame.Config;
import com.example.myapplication.mvp.frame.ICommonModel;
import com.example.myapplication.mvp.frame.ICommonView;
import com.example.myapplication.mvp.frame.NetManager;

import java.util.HashMap;

import okhttp3.RequestBody;

import static com.example.myapplication.mvp.frame.ApiConfig.TEXT_CODE;
import static com.example.myapplication.mvp.frame.ApiConfig.TOKEN_CODE;


public class TestModel implements ICommonModel {

    @Override
    public void getData(final int whichApi, final ICommonView presenterCallBack, Object[] params) {
        NetManager manager = NetManager.getNetManager();
        switch (whichApi){
            case TEXT_CODE:
                //一行代码请求网络数据                                            //每次强转为对应的就ok
                manager.method(manager.getNetService(Config.BASEURL).getCodeRRData((String) params[0]),whichApi,presenterCallBack);
                break;
            case TOKEN_CODE:
                HashMap<String, String> map = new HashMap<>();
                map.put("uid", (String) params[0]);
                map.put("app_key",(String) params[1]);
                RequestBody body = NetManager.getRequestBody(map);
                //RequestBody请求 非常简单方便 ！！！
                manager.method(manager.getNetService(Config.BASEURL).getTokenBean(body),whichApi,presenterCallBack);
                break;
        }
    }
}
