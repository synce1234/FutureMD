package com.dev.app.futuremd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dev.app.futuremd.data.Utils.Instance;
import com.dev.app.futuremd.data.apimanager.APIUtils;
import com.dev.app.futuremd.data.apimanager.MDService;
import com.dev.app.futuremd.data.dataresponse.DataResponse;
import com.dev.app.futuremd.data.dataresponse.UserPatient;
import com.dev.app.futuremd.data.functions.PatientInfoFunc;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public static Bus bus;
    UserPatient signupInfo;
    MDService mdService;

    String email, password;
    String firstName, lastName, regEmail, regPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignInFragment signInFragment = SignInFragment.getInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,signInFragment, SignInFragment.TAG).commit();
        mdService = APIUtils.getService();

        bus = new Bus(ThreadEnforcer.ANY);
        bus.register(this);
    }

    @Subscribe
    public void getMessage(BusEvent busEvent) {
        switch (busEvent){
            case SIGN_IN:
                loginInfo(Instance.TOKEN, email,password);
                break;

            case SIGN_UP:
                signupInfo(Instance.TOKEN, firstName, lastName, regEmail, regPassword);
                break;

            case MOVE_TO_SIGN_UP:
                SignUpFragment signUpFragment = SignUpFragment.getInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,signUpFragment, signUpFragment.TAG).commit();
                break;

            case MOVE_TO_SIGN_IN:
                SignInFragment signInFragment = SignInFragment.getInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,signInFragment, SignInFragment.TAG).commit();

                break;
        }
    }

    public enum BusEvent{
        MOVE_TO_SIGN_UP,
        MOVE_TO_SIGN_IN,
        SIGN_IN,
        SIGN_UP
    }

    public void loginInfo(String token, String email, String password) {
        final UserPatient info = new UserPatient();
        mdService.getPatientInfo(token, email, password).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null) {
                        /*info.setFullName(response.body().getFullName());
                        info.setEmail(response.body().getEmail());
                        info.setGender(response.body().getGender());
                        info.setPhoneNumber(response.body().getPhoneNumber());
                        info.setBirthday(response.body().getBirthday());
                        info.setAge(response.body().getAge());

                        Bundle bundle = new Bundle();
                        bundle.putSerializable(Instance.PATIENT_LOGIN_INFO_INTENT, info);*/

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        //intent.putExtras(bundle);
                        startActivity(intent);
                    }
                } else {
                    int statusCode = response.code();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }

    public void signupInfo(String token, String fistName, String lastName, String username, String password) {
        mdService.setPatientInfo(token, fistName, lastName, username, password).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                if(response.isSuccessful()) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });
    }

    public void setSignUpInfo(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.regEmail = email;
        this.regPassword = password;
    }

    public void setLoginInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
