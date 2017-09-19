package com.dev.app.futuremd.data.apimanager;

import com.dev.app.futuremd.data.dataresponse.UserPatient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by NEO on 9/16/2017.
 */

public interface MDService {
    //Get Patient Login info
    @GET("http://kajlfdkj.com")
    Call<UserPatient> getPatientInfo(@Query("username") String username, @Query("password") String password);

    //Post Patient Register info
    @POST("http://post")
    @FormUrlEncoded
    Call<UserPatient> setPatientInfo(@Body UserPatient patientInfo);
}
