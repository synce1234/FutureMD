package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dev.app.futuremd.data.Utils.AESUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SignInFragment extends BaseFragment {
    public static final String TAG = "com.dev.app.futuremd.SignInFragment";

    @BindView(R.id.et_sign_in_username)
    EditText etLoginUsername;
    @BindView(R.id.et_sign_in_password)
    EditText etLoginPassword;
    Unbinder unbinder;
    @BindView(R.id.bt_sign_in_sign_in)
    Button btLoginSignIn;
    @BindView(R.id.tv_sign_in_sign_up)
    TextView tvLoginSignUp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, null, true);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public static SignInFragment getInstance() {
        return new SignInFragment();
    }

    @OnClick({R.id.bt_sign_in_sign_in, R.id.tv_sign_in_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_sign_in_sign_in:
                String email = AESUtils.encrypt(etLoginUsername.getText().toString());
                String password = AESUtils.encrypt(etLoginPassword.getText().toString());
                ((LoginActivity) getActivity()).setLoginInfo(email, password);
                LoginActivity.bus.post(LoginActivity.BusEvent.SIGN_IN);
                break;
            case R.id.tv_sign_in_sign_up:
                LoginActivity.bus.post(LoginActivity.BusEvent.MOVE_TO_SIGN_UP);
                break;
        }
    }
}
