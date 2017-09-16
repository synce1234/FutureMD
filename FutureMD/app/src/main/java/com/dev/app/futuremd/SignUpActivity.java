package com.dev.app.futuremd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Admin on 9/16/2017.
 */

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.et_sign_up_first_name)
    EditText etSignUpFirstName;
    @BindView(R.id.et_sign_up_last_name)
    EditText etSignUpLastName;
    @BindView(R.id.et_sign_up_email)
    EditText etSignUpEmail;
    @BindView(R.id.et_sign_up_password)
    EditText etSignUpPassword;
    @BindView(R.id.et_sign_up_birthday)
    EditText etSignUpBirthday;
    @BindView(R.id.spinner_sign_up_gender)
    Spinner spinnerSignUpGender;
    @BindView(R.id.bt_sign_up_create)
    Button btSignUpCreate;
    @BindView(R.id.tv_sign_up_sign_in)
    TextView tvSignUpSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_sign_up_sign_in)
    public void onViewClicked() {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
