package com.fk.goodweather.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.fk.goodweather.WeatherApp;
import com.fk.goodweather.db.bean.Province;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * 城市存储库，用于获取城市数据
 */
public class CityRepository {

    private static final String TAG = CityRepository.class.getSimpleName();

    private static final class CityRepositoryHolder {
        private static final CityRepository mInstance = new CityRepository();
    }

    public static CityRepository getInstance() {
        return CityRepositoryHolder.mInstance;
    }

    /**
     * 添加城市数据
     */
    public void addCityData(List<Province> cityList) {
        Province[] provinceArray = cityList.toArray(new Province[0]);
        Completable insertAll = WeatherApp.getDb().provinceDao().insertAll(provinceArray);
        com.fk.goodweather.repository.CustomDisposable.addDisposable(insertAll, () -> Log.d(TAG, "addCityData: 插入数据成功。"));
    }

    /**
     * 获取城市数据
     */
    public void getCityData(MutableLiveData<List<Province>> listMutableLiveData) {
        Flowable<List<Province>> listFlowable = WeatherApp.getDb().provinceDao().getAll();
        com.fk.goodweather.repository.CustomDisposable.addDisposable(listFlowable, listMutableLiveData::postValue);
    }
}
