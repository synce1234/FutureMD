package com.dev.app.futuremd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by sev_user on 9/18/2017.
 */

public class FindDoctorDialogFragment extends DialogFragment {
    public static final String TAG = "com.dev.app.futuremd.FindDoctorDialogFragment";
    @BindView(R.id.rb_dialog_find_doctor_filter_mapview)
    RadioButton rbDialogFindDoctorFilterMapview;
    @BindView(R.id.rb_dialog_find_doctor_filter_listview)
    RadioButton rbDialogFindDoctorFilterListview;
    @BindView(R.id.rb_dialog_find_doctor_filter_rating)
    RadioButton rbDialogFindDoctorFilterRating;
    @BindView(R.id.rg_dialog_find_doctor_filter_view_type)
    RadioGroup rgDialogFindDoctorFilterViewType;
    @BindView(R.id.spinner_dialog_find_doctor_filter_doctor_type)
    Spinner spinnerDialogFindDoctorFilterDoctorType;
    @BindView(R.id.spinner_dialog_find_doctor_filter_appointment_type)
    Spinner spinnerDialogFindDoctorFilterAppointmentType;
    @BindView(R.id.tv_dialog_find_doctor_filter_distance_title)
    TextView tvDialogFindDoctorFilterDistanceTitle;
    @BindView(R.id.iv_dialog_find_doctor_filter_distance_value)
    TextView ivDialogFindDoctorFilterDistanceValue;
    @BindView(R.id.sb_dialog_find_doctor_filter_distance)
    SeekBar sbDialogFindDoctorFilterDistance;
    @BindView(R.id.bt_dialog_find_doctor_filter_filter)
    Button btDialogFindDoctorFilterFilter;
    @BindView(R.id.iv_dialog_find_doctor_filter_toolbar_close)
    ImageView ivDialogFindDoctorFilterToolbarClose;
    Unbinder unbinder;

    public static FindDoctorDialogFragment newInstance() {
        FindDoctorDialogFragment frag = new FindDoctorDialogFragment();
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomizedDialog);

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_find_doctor_filter, null);
        unbinder = ButterKnife.bind(this, view);
        builder.setView(view);

        return builder.create();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.iv_dialog_find_doctor_filter_toolbar_close)
    public void onViewClicked() {
        dismiss();
    }
}
