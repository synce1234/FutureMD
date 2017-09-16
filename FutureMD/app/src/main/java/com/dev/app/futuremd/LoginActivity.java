package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

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
    public void getMessage(String s) {
        if(s.equals(SignInFragment.TAG)){
            //Move to SignUpFragment to start signing up;
            SignUpFragment signUpFragment = SignUpFragment.getInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,signUpFragment, signUpFragment.TAG).commit();
        }else if(s.equals(SignUpFragment.TAG)){
            //Move to SignInFragment to start signing in;
            SignInFragment signInFragment = SignInFragment.getInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,signInFragment, SignInFragment.TAG).commit();
        }
    }
}
