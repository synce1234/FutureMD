package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.otto.Bus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Admin on 9/16/2017.
 */
//tinh.tran
public class SignUpFragment extends BaseFragment {
    public static final String TAG = "com.dev.app.futuremd.SignUpFragment";
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
    Unbinder unbinder;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, null, true);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tv_sign_up_sign_in)
    public void onViewClicked() {
        LoginActivity.bus.post(SignUpFragment.TAG);
    }


    public static SignUpFragment getInstance() {
        return new SignUpFragment();
    }
}
