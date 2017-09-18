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

    public UserPatient getPatientInfo(String username, String password) {
        final UserPatient info = new UserPatient();
        mdService.getPatientInfo(username, password).enqueue(new Callback<List<UserPatient>>() {
            @Override
            public void onResponse(Call<List<UserPatient>> call, Response<List<UserPatient>> response) {
                if(response.isSuccessful()) {
                    if(response.body().size() > 0) {
                        info.setFullName(response.body().get(0).getFullName());
                        info.setEmail(response.body().get(0).getEmail());
                        info.setGender(response.body().get(0).getGender());
                        info.setPhoneNumber(response.body().get(0).getPhoneNumber());
                        info.setBirthday(response.body().get(0).getBirthday());
                        info.setAge(response.body().get(0).getAge());
                    }
                } else {
                    int statusCode = response.code();
                }
            }

            @Override
            public void onFailure(Call<List<UserPatient>> call, Throwable t) {

            }
        });

        return info;
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
