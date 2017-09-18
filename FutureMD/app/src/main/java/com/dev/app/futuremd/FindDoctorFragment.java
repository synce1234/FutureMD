package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FindDoctorFragment extends BaseFragment {
    public static final String TAG = "com.dev.app.futuremd.FindDoctorFragment";
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
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_doctor, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvFindDoctorListDoctors.setLayoutManager(layoutManager);
        rvFindDoctorListDoctors.setAdapter(new FindDoctorAdapter());
    }

    @OnClick(R.id.iv_find_doctor_filter)
    public void showEditDialog() {
        FragmentManager fm = getFragmentManager();
        FindDoctorDialogFragment findDoctorDialogFragment = FindDoctorDialogFragment.newInstance();
        findDoctorDialogFragment.show(fm, "fragment_edit_name");
    }

    @OnClick(R.id.toolbar_logo)
    public void toggleMenu() {
        MainActivity.bus.post(MainActivity.BusEvent.TOGGLE_DRAWER_MENU);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
