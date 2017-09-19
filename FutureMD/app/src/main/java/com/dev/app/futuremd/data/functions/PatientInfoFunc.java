package com.dev.app.futuremd.data.functions;

import android.content.Context;

import com.dev.app.futuremd.data.apimanager.MDService;
import com.dev.app.futuremd.data.dataresponse.UserPatient;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NEO on 9/16/2017.
 */

public class PatientInfoFunc {
    MDService mdService;
    public PatientInfoFunc(Context context, MDService service) {
        this.mdService = service;
    }

    public void getPatientInfo(String username, String password) {
        final UserPatient info = new UserPatient();
        mdService.getPatientInfo(username, password).enqueue(new Callback<UserPatient>() {
            @Override
            public void onResponse(Call<UserPatient> call, Response<UserPatient> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        
                        info.setFullName(response.body().getFullName());
                        info.setEmail(response.body().getEmail());
                        info.setGender(response.body().getGender());
                        info.setPhoneNumber(response.body().getPhoneNumber());
                        info.setBirthday(response.body().getBirthday());
                        info.setAge(response.body().getAge());
                    }
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<UserPatient> call, Throwable t) {

            }
        });
    }

    public void setPatientInfo(UserPatient patientInfo) {
        mdService.setPatientInfo(patientInfo).enqueue(new Callback<UserPatient>() {
            @Override
            public void onResponse(Call<UserPatient> call, Response<UserPatient> response) {
                if(response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<UserPatient> call, Throwable t) {

            }
        });
    }
}
