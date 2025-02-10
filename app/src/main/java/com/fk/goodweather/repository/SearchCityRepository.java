package com.fk.goodweather.repository;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.fk.goodweather.Constant;
import com.fk.goodweather.api.ApiService;
import com.fk.goodweather.bean.SearchCityResponse;
import com.fk.library.network.ApiType;
import com.fk.library.network.NetworkApi;
import com.fk.library.network.observer.BaseObserver;

/**
 * 搜索城市存储库，数据处理
 */
@SuppressLint("CheckResult")
public class SearchCityRepository {

    private static final String TAG = SearchCityRepository.class.getSimpleName();

    public void searchCity(MutableLiveData<SearchCityResponse> responseLiveData,
                           MutableLiveData<String> failed, String cityName) {

        NetworkApi.createService(ApiService.class, ApiType.SEARCH).searchCity(cityName)
                .compose(NetworkApi.applySchedulers(new BaseObserver<>() {
                    @Override
                    public void onSuccess(SearchCityResponse searchCityResponse) {
                        if (searchCityResponse == null) {
                            failed.postValue("搜索城市数据为null，请检查城市名称是否正确。");
                            return;
                        }
                        //请求接口成功返回数据，失败返回状态码
                        if (Constant.SUCCESS.equals(searchCityResponse.getCode())) {
                            responseLiveData.postValue(searchCityResponse);
                        } else {
                            failed.postValue(searchCityResponse.getCode());
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        Log.e(TAG, "onFailure: " + e.getMessage());
                        failed.postValue(e.getMessage());
                    }
                }));
    }
}
