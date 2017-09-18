package com.dev.app.futuremd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

public class LoginActivity extends AppCompatActivity {
    public static Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignInFragment signInFragment = SignInFragment.getInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,signInFragment, SignInFragment.TAG).commit();
        bus = new Bus(ThreadEnforcer.ANY);
        bus.register(this);
    }

    @Subscribe
    public void getMessage(BusEvent busEvent) {
        switch (busEvent){
            case SIGN_IN:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            case SIGN_UP:

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
}
