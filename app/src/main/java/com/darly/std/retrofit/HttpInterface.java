package com.darly.std.retrofit;

import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * author:zhangyuhui
 * date:2020-05-2317:52
 * description:
 */
public interface HttpInterface {

    //@FormUrlEncoded//添加这行注解，否则参数报错。Post请求
    @GET("mobile/key")
    Observable<JsonObject> getKey(@Query("ip") String ip);

    @POST("mobile/value")
    Observable<JsonObject> postValue(@Body RequestBody route);

    @GET("mobile/list")
    Observable<JsonObject> getList(@Query("ip") String ip);

}
