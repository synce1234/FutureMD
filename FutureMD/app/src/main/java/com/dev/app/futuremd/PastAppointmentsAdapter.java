package com.dev.app.futuremd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tinh.tran on 9/19/2017.
 */

public class PastAppointmentsAdapter extends RecyclerView.Adapter<PastAppointmentsAdapter.PastAppointmentViewHolder> {

    @Override
    public PastAppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_item_past_appointment, parent, false);
        return new PastAppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PastAppointmentViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class PastAppointmentViewHolder extends RecyclerView.ViewHolder{

        public PastAppointmentViewHolder(View itemView) {
            super(itemView);
        }
    }
}
