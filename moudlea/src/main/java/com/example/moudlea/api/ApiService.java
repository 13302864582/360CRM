package com.example.moudlea.api;



import com.example.moudlea.bean.TestBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("970-1/")
    Observable<TestBean> getAll(@Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign, @Query("page") String page);
}
