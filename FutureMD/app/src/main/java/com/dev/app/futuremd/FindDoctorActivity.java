package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FindDoctorActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_logo)
    ImageView toolbarLogo;
    @BindView(R.id.et_find_doctor_searching)
    EditText etFindDoctorSearching;
    @BindView(R.id.iv_find_doctor_filter)
    ImageView ivFindDoctorFilter;
    @BindView(R.id.tv_find_doctor_filter_data)
    TextView tvFindDoctorFilterData;
    @BindView(R.id.rv_find_doctor_list_doctors)
    RecyclerView rvFindDoctorListDoctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvFindDoctorListDoctors.setLayoutManager(layoutManager);
        rvFindDoctorListDoctors.setAdapter(new FindDoctorAdapter());
    }

    @OnClick(R.id.iv_find_doctor_filter)
    public void showEditDialog() {
        FragmentManager fm = getSupportFragmentManager();
        FindDoctorDialogFragment findDoctorDialogFragment = FindDoctorDialogFragment.newInstance();
        findDoctorDialogFragment.show(fm, "fragment_edit_name");
    }

}
