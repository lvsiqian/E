package com.example.last_1.data.net.ok;

import java.util.HashMap;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiService {
    //post请求
    @POST
    @FormUrlEncoded
    Observable<String> doPost(@Url String  url, @HeaderMap HashMap<String,Object> heads, @FieldMap HashMap<String,Object> parms);
   @GET
    Observable<String> doGet(@Url String  url, @HeaderMap HashMap<String,Object> heads, @QueryMap HashMap<String,Object> parms);
}
