package com.example.api;


import com.example.mvp.bean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {
    @GET("signin/")
    Call<ResponseBody> getAll(@Query("account") String showapi_appid, @Query("password") String showapi_sign, @Query("ui") String page);

    @GET("course_prepares/")
    @Headers({
            "x-sub-host: base",
            "x-token: 31bfff7901a603996da4ce05f7120177"
    })
    Observable<bean> course_prepares(@Query("with") String with, @Query("teach_eid") String teach_eid, @Query("page") String page, @Query("pagesize") String pagesize);
}
