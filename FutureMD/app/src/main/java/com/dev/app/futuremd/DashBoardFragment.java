package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class DashBoardFragment extends BaseFragment {
    public static final String TAG = "com.dev.app.futuremd.DashBoardFragment";
    @BindView(R.id.toolbar_logo)
    ImageView ivToolbarLogo;
    @BindView(R.id.iv_dashboard_avatar)
    ImageView ivDashboardAvatar;
    @BindView(R.id.tv_dashboard_name)
    TextView tvDashboardName;
    @BindView(R.id.tv_dashboard_age)
    TextView tvDashboardAge;
    @BindView(R.id.tv_dashboard_gender)
    TextView tvDashboardGender;
    @BindView(R.id.ll_dashboard_item_my_account)
    LinearLayout llDashboardItemMyAccount;
    @BindView(R.id.ll_dashboard_item_find_doctor)
    LinearLayout llDashboardItemFindDoctor;
    @BindView(R.id.ll_dashboard_item_appointments)
    LinearLayout llDashboardItemAppointments;
    @BindView(R.id.ll_dashboard_item_medical_vault)
    LinearLayout llDashboardItemMedicalVault;
    @BindView(R.id.ll_dashboard_item_favorites)
    LinearLayout llDashboardItemFavorites;
    @BindView(R.id.ll_dashboard_item_settings)
    LinearLayout llDashboardItemSettings;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dash_board, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.toolbar_logo)
    public void onViewClicked() {
        MainActivity.bus.post(MainActivity.BusEvent.TOGGLE_DRAWER_MENU);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.ll_dashboard_item_my_account, R.id.ll_dashboard_item_find_doctor, R.id.ll_dashboard_item_appointments, R.id.ll_dashboard_item_medical_vault, R.id.ll_dashboard_item_favorites, R.id.ll_dashboard_item_settings})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_dashboard_item_my_account:
                break;
            case R.id.ll_dashboard_item_find_doctor:
                MainActivity.bus.post(FindDoctorFragment.TAG);
                break;
            case R.id.ll_dashboard_item_appointments:
                MainActivity.bus.post(MyAppointmentsFragment.TAG);
                break;
            case R.id.ll_dashboard_item_medical_vault:
                break;
            case R.id.ll_dashboard_item_favorites:
                break;
            case R.id.ll_dashboard_item_settings:
                break;
        }
    }
}
