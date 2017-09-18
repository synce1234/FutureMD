package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashBoardActivity extends AppCompatActivity {
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
    @BindView(R.id.tv_dashboard_nav_item_my_account)
    TextView tvDashboardNavItemMyAccount;
    @BindView(R.id.tv_dashboard_nav_item_find_doctor)
    TextView tvDashboardNavItemFindDoctor;
    @BindView(R.id.tv_dashboard_nav_item_medical_vault)
    TextView tvDashboardNavItemMedicalVault;
    @BindView(R.id.tv_dashboard_nav_item_appointments)
    TextView tvDashboardNavItemAppointments;
    @BindView(R.id.tv_dashboard_nav_item_favorites)
    TextView tvDashboardNavItemFavorites;
    @BindView(R.id.tv_dashboard_nav_item_messages)
    TextView tvDashboardNavItemMessages;
    @BindView(R.id.tv_dashboard_nav_item_invite_friends)
    TextView tvDashboardNavItemInviteFriends;
    @BindView(R.id.tv_dashboard_nav_item_support)
    TextView tvDashboardNavItemSupport;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindViews({R.id.tv_dashboard_nav_item_my_account, R.id.tv_dashboard_nav_item_find_doctor, R.id.tv_dashboard_nav_item_medical_vault, R.id.tv_dashboard_nav_item_appointments, R.id.tv_dashboard_nav_item_favorites, R.id.tv_dashboard_nav_item_messages, R.id.tv_dashboard_nav_item_invite_friends, R.id.tv_dashboard_nav_item_support})
    List<TextView> funcItemViews;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }

    @OnClick(R.id.toolbar_logo)
    public void onViewClicked() {
        toggleDrawer();
    }

    private void toggleDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @OnClick({R.id.tv_dashboard_nav_item_my_account, R.id.tv_dashboard_nav_item_find_doctor, R.id.tv_dashboard_nav_item_medical_vault, R.id.tv_dashboard_nav_item_appointments, R.id.tv_dashboard_nav_item_favorites, R.id.tv_dashboard_nav_item_messages, R.id.tv_dashboard_nav_item_invite_friends, R.id.tv_dashboard_nav_item_support})
    public void onViewClicked(View view) {
        ButterKnife.apply(funcItemViews, SELECTED, false);
        ButterKnife.apply(view, SELECTED, true);

        switch (view.getId()) {
            case R.id.tv_dashboard_nav_item_my_account:
                break;
            case R.id.tv_dashboard_nav_item_find_doctor:
                break;
            case R.id.tv_dashboard_nav_item_medical_vault:
                break;
            case R.id.tv_dashboard_nav_item_appointments:
                break;
            case R.id.tv_dashboard_nav_item_favorites:
                break;
            case R.id.tv_dashboard_nav_item_messages:
                break;
            case R.id.tv_dashboard_nav_item_invite_friends:
                break;
            case R.id.tv_dashboard_nav_item_support:
                break;
        }
    }

    static final ButterKnife.Setter<View, Boolean> SELECTED = new ButterKnife.Setter<View, Boolean>() {
        @Override public void set(View view, Boolean value, int index) {
            view.setSelected(value);
        }
    };
}
