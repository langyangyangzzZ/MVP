package com.example.myapplication.mvp.frame;

public class Config {
    //这里是接口的前半段
    public static String BASEURL;
    private static int type = 1;

    /**
     * 1,外网正式服务器
     * 2，外网测试服务器
     * 3，内网测试服务器
     */

    //在一种环境下可能有多个服务器
    //相当于写Retrofit接口中的前半段
    static {
        if (type == 1){
            BASEURL = "http://newwasj.zhangtongdongli.com/";
        } else if (type == 2){
            BASEURL = "http://baidu.com/";
        } else {
            BASEURL = "http://sina.com/";
        }
    }
}
