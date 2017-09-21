package com.dev.app.futuremd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.app.futuremd.data.DumpMessage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sev_user on 9/20/2017.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.BaseViewHolder> {
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    List<DumpMessage> listMessages;

    public MessageAdapter(List<DumpMessage> listMessages) {
        this.listMessages = listMessages;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_item_message_sent, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_item_message_received, parent, false);
            return new ReceivedMessageHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(listMessages.get(position));
    }

    @Override
    public int getItemCount() {
        return listMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (listMessages.get(position).getUserId().equals(MessageFragment.getCurrentUser())) {
            return VIEW_TYPE_MESSAGE_SENT;
        } else {
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    public class SentMessageHolder extends BaseViewHolder {
        @BindView(R.id.tv_item_message_message_sender)
        TextView tvItemMessageMessageSender;
        @BindView(R.id.iv_item_message_avatar_sender)
        ImageView ivItemMessageAvatarSender;
        @BindView(R.id.iv_item_message_time_sender)
        TextView ivItemMessageTimeSender;

        public SentMessageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(DumpMessage dumpMessage) {
            tvItemMessageMessageSender.setText(dumpMessage.getMessage());
        }
    }

    public class ReceivedMessageHolder extends BaseViewHolder {
        @BindView(R.id.tv_item_message_message_receiver)
        TextView tvItemMessageMessageReceiver;
        @BindView(R.id.iv_item_message_avatar_receiver)
        ImageView ivItemMessageAvatarReceiver;
        @BindView(R.id.iv_item_message_time_receiver)
        TextView ivItemMessageTimeReceiver;

        public ReceivedMessageHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(DumpMessage dumpMessage) {
            tvItemMessageMessageReceiver.setText(dumpMessage.getMessage());
        }
    }

    public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void bind(DumpMessage dumpMessage);
    }
}
