package com.dev.app.futuremd;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl_main_container)
    FrameLayout llMainContainer;
    @BindView(R.id.tv_nav_item_my_account)
    TextView tvNavItemMyAccount;
    @BindView(R.id.tv_nav_item_find_doctor)
    TextView tvNavItemFindDoctor;
    @BindView(R.id.tv_nav_item_medical_vault)
    TextView tvNavItemMedicalVault;
    @BindView(R.id.tv_nav_item_appointments)
    TextView tvNavItemAppointments;
    @BindView(R.id.tv_nav_item_favorites)
    TextView tvNavItemFavorites;
    @BindView(R.id.tv_nav_item_messages)
    TextView tvNavItemMessages;
    @BindView(R.id.tv_nav_item_invite_friends)
    TextView tvNavItemInviteFriends;
    @BindView(R.id.tv_nav_item_support)
    TextView tvNavItemSupport;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindViews({R.id.tv_nav_item_my_account, R.id.tv_nav_item_find_doctor, R.id.tv_nav_item_medical_vault, R.id.tv_nav_item_appointments, R.id.tv_nav_item_favorites, R.id.tv_nav_item_messages, R.id.tv_nav_item_invite_friends, R.id.tv_nav_item_support})
    List<TextView> funcItemViews;

    public static Bus bus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_container,new DashBoardFragment(), DashBoardFragment.TAG).commit();
        bus = new Bus(ThreadEnforcer.MAIN);
        MainActivity.bus.register(this);
    }

    @Override
    protected void onDestroy() {
        bus.unregister(this);
        super.onDestroy();
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

    private void toggleDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Subscribe
    public void getMessage(BusEvent busEvent) {
        switch (busEvent){
            case TOGGLE_DRAWER_MENU:
                toggleDrawer();
                break;
        }
    }

    @Subscribe
    public void openFragmentWith(String tag){
        openFragment(tag);
    }

    @OnClick({R.id.tv_nav_item_my_account, R.id.tv_nav_item_find_doctor, R.id.tv_nav_item_medical_vault, R.id.tv_nav_item_appointments, R.id.tv_nav_item_favorites, R.id.tv_nav_item_messages, R.id.tv_nav_item_invite_friends, R.id.tv_nav_item_support})
    public void onViewClicked(View view) {
        ButterKnife.apply(funcItemViews, SELECTED, false);
        ButterKnife.apply(view, SELECTED, true);

        toggleDrawer();

        switch (view.getId()) {
            case R.id.tv_nav_item_my_account:
                break;
            case R.id.tv_nav_item_find_doctor:
                openFragment(FindDoctorFragment.TAG);
                break;
            case R.id.tv_nav_item_medical_vault:
                break;
            case R.id.tv_nav_item_appointments:
                openFragment(MyAppointmentsFragment.TAG);
                break;
            case R.id.tv_nav_item_favorites:
                break;
            case R.id.tv_nav_item_messages:
                openFragment(MessageFragment.TAG);
                break;
            case R.id.tv_nav_item_invite_friends:
                break;
            case R.id.tv_nav_item_support:
                break;
        }
    }

    private void openFragment(String tag){
        BaseFragment baseFragment = (BaseFragment)getSupportFragmentManager().findFragmentByTag(tag);
        if(baseFragment== null){
            switch (tag){
                case FindDoctorFragment.TAG:
                    baseFragment = new FindDoctorFragment();
                    break;
                case MyAppointmentsFragment.TAG:
                    baseFragment = new MyAppointmentsFragment();
                    break;
                case MessageFragment.TAG:
                    baseFragment = new MessageFragment();
                    break;
            }
        }

        if(baseFragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_main_container,baseFragment, tag).commit();
        }
    }

    static final ButterKnife.Setter<View, Boolean> SELECTED = new ButterKnife.Setter<View, Boolean>() {
        @Override
        public void set(View view, Boolean value, int index) {
            view.setSelected(value);
        }
    };

    public enum BusEvent{
        TOGGLE_DRAWER_MENU
    }
}
