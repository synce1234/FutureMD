package com.dev.app.futuremd;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyAppointmentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyAppointmentsFragment extends BaseFragment {
    public static final String TAG = "com.dev.app.futuremd.MyAppointmentsFragment";
    public static final String TAB_TITLES[] = {"Past Appointments", "Up-coming Appointments"};
    @BindView(R.id.toolbar_logo)
    ImageView toolbarLogo;
    @BindView(R.id.toolbar_add)
    ImageView toolbarAdd;
    @BindView(R.id.tab_layout_my_appointments)
    TabLayout tabLayoutMyAppointments;
    @BindView(R.id.vp_my_appointments)
    ViewPager vpMyAppointments;
    Unbinder unbinder;

    RecyclerView rvPastAppointments, rvUpcomingAppointments;

    public static MyAppointmentsFragment newInstance(String param1, String param2) {
        MyAppointmentsFragment fragment = new MyAppointmentsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_appointments, container, false);
        unbinder = ButterKnife.bind(this, view);

        rvPastAppointments = (RecyclerView) inflater.inflate(R.layout.layout_appointments, null);
        rvUpcomingAppointments = (RecyclerView) inflater.inflate(R.layout.layout_appointments, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         * RecycleView of Past Appointment
         */
        LinearLayoutManager pastAppointmentsLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        pastAppointmentsLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(getContext().getApplicationContext(),
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(getActivity(), R.drawable.horizontal_divider_appointment_list);
        horizontalDecoration.setDrawable(horizontalDivider);
        rvPastAppointments.addItemDecoration(horizontalDecoration);
        rvPastAppointments.setLayoutManager(pastAppointmentsLayoutManager);
        rvPastAppointments.setAdapter(new PastAppointmentsAdapter());

        /**
         * RecycleView of Up Coming Appointment
         */
        LinearLayoutManager upCommingAppointmentsLayoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        upCommingAppointmentsLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvUpcomingAppointments.addItemDecoration(horizontalDecoration);
        rvUpcomingAppointments.setLayoutManager(upCommingAppointmentsLayoutManager);
        rvUpcomingAppointments.setAdapter(new UpComingAppointmentsAdapter());

        AppointmentsPagerAdapter appointmentsPagerAdapter =  new AppointmentsPagerAdapter(getContext().getApplicationContext());
        vpMyAppointments.setAdapter(appointmentsPagerAdapter);
        tabLayoutMyAppointments.setupWithViewPager(vpMyAppointments);
        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabLayoutMyAppointments.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayoutMyAppointments.getTabAt(i);
            tab.setCustomView(appointmentsPagerAdapter.getTabView(i));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.toolbar_logo, R.id.toolbar_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_logo:
                MainActivity.bus.post(MainActivity.BusEvent.TOGGLE_DRAWER_MENU);
                break;
            case R.id.toolbar_add:
                break;
        }
    }

    public abstract class ViewPagerAdapter extends PagerAdapter{
        private Context mContext = null;
        private Map<String, View> viewState = new HashMap<>();

        public ViewPagerAdapter(Context ctx ){
            mContext = ctx;
        }

        public abstract View getView(int position);


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (View)object == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = (View) getView(position);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }

    public class AppointmentsPagerAdapter extends ViewPagerAdapter{

        public AppointmentsPagerAdapter(Context ctx) {
            super(ctx);
        }

        @Override
        public int getCount() {
            return TAB_TITLES.length;
        }

        @Override
        public View getView(int position) {
            if(position == 0){
                return rvPastAppointments;
            }else{
                return rvUpcomingAppointments;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TAB_TITLES[position];
        }

        public View getTabView(int position) {
            View tab = getActivity().getLayoutInflater().inflate(R.layout.layout_custom_tab, null);
            TextView tv = (TextView) tab.findViewById(R.id.custom_text);
            tv.setText(getPageTitle(position));
            return tab;
        }
    }
}
