package com.dev.app.futuremd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tinh.tran on 9/19/2017.
 */

public class UpComingAppointmentsAdapter extends RecyclerView.Adapter<UpComingAppointmentsAdapter.UpComingAppointmentViewHolder> {

    @Override
    public UpComingAppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_item_up_coming_appointment, parent, false);
        return new UpComingAppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UpComingAppointmentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class UpComingAppointmentViewHolder extends RecyclerView.ViewHolder{

        public UpComingAppointmentViewHolder(View itemView) {
            super(itemView);
        }
    }
}
