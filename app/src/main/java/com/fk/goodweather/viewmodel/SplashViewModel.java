package com.fk.goodweather.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.fk.goodweather.db.bean.BingResponse;
import com.fk.goodweather.db.bean.Province;
import com.fk.goodweather.repository.BingRepository;
import com.fk.goodweather.repository.CityRepository;
import com.fk.library.base.BaseViewModel;

import java.util.List;

/**
 * 启动页ViewModel
 * {@link com.fk.goodweather.ui.SplashActivity}
 */
public class SplashViewModel extends BaseViewModel {

    public MutableLiveData<List<Province>> listMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<BingResponse> bingResponseMutableLiveData = new MutableLiveData<>();

    /**
     * 添加城市数据
     */
    public void addCityData(List<Province> provinceList) {
        CityRepository.getInstance().addCityData(provinceList);
    }

    /**
     * 获取所有城市数据
     */
    public void getAllCityData() {
        CityRepository.getInstance().getCityData(listMutableLiveData);
    }

    /**
     * 必应壁纸
     */
    public void bing() {
        BingRepository.getInstance().bing(bingResponseMutableLiveData, failed);
    }

}

