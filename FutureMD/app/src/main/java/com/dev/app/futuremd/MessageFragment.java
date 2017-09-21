package com.dev.app.futuremd;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.dev.app.futuremd.data.DumpMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by sev_user on 9/20/2017.
 */

public class MessageFragment extends BaseFragment {
    public static final String TAG = "com.dev.app.futuremd.MessageFragment";
    private static final String DUMP_MESSAGES [] = {"compileSdkVersion", "compile 'com.squareup.retrofit2:converter-gson:2.1.0'", "JSON Parsing", "compile fileTree(include: ['*.jar'], dir: 'libs')", "proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'"};
    @BindView(R.id.toolbar_logo)
    ImageView toolbarLogo;
    @BindView(R.id.rv_message_list)
    RecyclerView rvMessageList;
    @BindView(R.id.iv_message_attach)
    ImageView ivMessageAttach;
    @BindView(R.id.et_message_input)
    EditText etMessageInput;
    @BindView(R.id.iv_message_avatar)
    ImageView ivMessageAvatar;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext().getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMessageList.setLayoutManager(layoutManager);
        Random random = new Random();
        String dumpUserId[] = {"abc","123"};
        List<DumpMessage> dumpMessageList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            dumpMessageList.add(new DumpMessage(dumpUserId[random.nextInt(100)%2], DUMP_MESSAGES[random.nextInt(100)%DUMP_MESSAGES.length]));
            random.setSeed(SystemClock.uptimeMillis());
        }
        MessageAdapter messageAdapter = new MessageAdapter(dumpMessageList);
        rvMessageList.setAdapter(messageAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.toolbar_logo, R.id.iv_message_attach, R.id.iv_message_avatar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_logo:
                break;
            case R.id.iv_message_attach:
                break;
            case R.id.iv_message_avatar:
                break;
        }
    }

    public static final String getCurrentUser(){
        return "abc";
    }
}
