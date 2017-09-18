package com.dev.app.futuremd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;

/**
 * Created by sev_user on 9/18/2017.
 */

public class FindDoctorDialogFragment extends DialogFragment {
    public static final String TAG = "com.dev.app.futuremd.FindDoctorDialogFragment";

    public static FindDoctorDialogFragment newInstance() {
        FindDoctorDialogFragment frag = new FindDoctorDialogFragment();
        return frag;
    }


//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.dialog_find_doctor_filter, container, false);
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.CustomizedDialog) ;

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_find_doctor_filter, null);
        builder.setView(view);

        return builder.create();
    }
}
