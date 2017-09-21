package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingActivity extends AppCompatActivity {

    private String[] arraySpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        this.arraySpinner = new String[] {
                "1", "2", "3", "4", "5"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner_payment_type);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);
    }
}
