package Data.Functions;

import android.content.Context;

import java.util.List;

import Data.APIManage.MDService;
import Data.ResponseInfo.UserPatient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NEO on 9/16/2017.
 */

public class PatienInfoFunc {
    MDService mdService;
    public PatienInfoFunc(Context context, MDService service) {
        this.mdService = service;
    }

    public UserPatient getPatientInfo(String username, String password) {
        final UserPatient info = new UserPatient();
        mdService.getPatientInfo(username, password).enqueue(new Callback<List<UserPatient>>() {
            @Override
            public void onResponse(Call<List<UserPatient>> call, Response<List<UserPatient>> response) {
                if(response.isSuccessful()) {
                    info.setFullName(response.body().get(0).getFullName());


                    //continue
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
}
