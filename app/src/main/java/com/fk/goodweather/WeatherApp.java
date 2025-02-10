package com.fk.goodweather;

import com.baidu.location.LocationClient;
import com.fk.library.base.BaseApplication;
import com.fk.library.network.NetworkApi;
import com.fk.library.network.INetworkRequiredInfo;
import com.fk.library.network.INetworkRequiredInfo;
import com.fk.library.network.INetworkRequiredInfo;
import com.fk.library.network.INetworkRequiredInfo;
import com.fk.library.network.INetworkRequiredInfo;

public class WeatherApp extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //使用定位需要同意隐私合规政策
        LocationClient.setAgreePrivacy(true);
        //初始化网络框架
        NetworkApi.init(new NetworkRequiredInfo(this));
    }
}
