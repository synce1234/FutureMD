package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.dev.app.futuremd.data.dataresponse.UserPatient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    @BindView(R.id.toolbar_logo)
    ImageView toolBarLogo;
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

    UserPatient userPatient;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, null, true);
        userPatient = new UserPatient();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.toolbar_logo, R.id.bt_sign_up_create, R.id.tv_sign_up_sign_in})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_logo:
                getActivity().finish();
                break;
            case R.id.bt_sign_up_create:
                Date dob = stringToDate(etSignUpBirthday.getText().toString());
                userPatient.setFullName(etSignUpFirstName.getText().toString() + " " + etSignUpLastName.getText().toString());
                userPatient.setEmail(etSignUpEmail.getText().toString());
                userPatient.setBirthday(dob);
                userPatient.setPassword(etSignUpPassword.getText().toString());
                userPatient.setGender(spinnerSignUpGender.getSelectedItem().toString());
                userPatient.setAge(getAge(dob));
                ((LoginActivity) getActivity()).setSignUpInfo(userPatient);
                LoginActivity.bus.post(LoginActivity.BusEvent.SIGN_UP);
                break;
            case R.id.tv_sign_up_sign_in:
                LoginActivity.bus.post(LoginActivity.BusEvent.MOVE_TO_SIGN_IN);
                break;
        }
    }

    public static SignUpFragment getInstance() {
        return new SignUpFragment();
    }

    private Date stringToDate(String s) {
        SimpleDateFormat format = new SimpleDateFormat("MMMMM dd, yyyy");
        try {
            Date date = format.parse(s);
            return date;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Calendar.getInstance().getTime();
        }
    }

    private int getAge(Date dob){
        Calendar today = Calendar.getInstance();
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.setTime(dob);
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        return age;
    }
}
