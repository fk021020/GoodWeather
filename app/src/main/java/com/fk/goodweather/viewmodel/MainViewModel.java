package com.fk.goodweather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.fk.goodweather.bean.SearchCityResponse;
import com.fk.goodweather.repository.SearchCityRepository;
import com.fk.library.base.BaseViewModel;

/**
 * 主页面ViewModel
 * {@link com.example.goodweather.MainActivity}
 */
public class MainViewModel extends BaseViewModel {

    public MutableLiveData<SearchCityResponse> searchCityResponseMutableLiveData = new MutableLiveData<>();

    /**
     * 搜索成功
     * @param cityName 城市名称
     */
    public void searchCity(String cityName) {
        new SearchCityRepository().searchCity(searchCityResponseMutableLiveData, failed, cityName);
    }
}
