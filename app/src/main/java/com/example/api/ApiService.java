package com.example.api;


import com.example.mvp.bean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiService {
    @GET("signin/")
    Call<ResponseBody> getAll(@Query("account") String showapi_appid, @Query("password") String showapi_sign, @Query("ui") String page);


    @GET
    Observable<bean> course_prepares(@Url String url, @Header("x-sub-host")String host, @Header("x-token")String token, @Query("with") String with, @Query("teach_eid") String teach_eid, @Query("page") String page, @Query("pagesize") String pagesize);
}
