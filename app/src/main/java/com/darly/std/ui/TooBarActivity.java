/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.event.BaseEvent;
import com.darly.chinese.event.EventController;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.bean.TooBarEvent;
import com.darly.std.databinding.ActivityToobarBinding;
import com.darly.std.vm.ToolBarViewModel;

/**
 * Description TODO:TooBar测试
 * Package com.darly.qtest.ui
 *
 * @author zhangyuhui
 * @date 2019/8/22 16:46
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class TooBarActivity extends BaseActivity<ActivityToobarBinding, ToolBarViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.activity_toobar;
    }

    @Override
    protected int initVariableId() {
        return BR.toolBarViewModel;
    }

    @Override
    protected ToolBarViewModel initViewModel() {
        return ViewModelProviders.of(this).get(ToolBarViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        binding.toolbar.setCenterTitle(getIntent().getStringExtra("id"));
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void initObservableView() {
        EventController.postMessage(new TooBarEvent());
    }


    @Override
    protected void onResume() {
        super.onResume();
        EventController.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventController.unregister(this);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        EventController.postMessage(new TooBarEvent());
        return true;
    }

    @Override
    public void onUiMessage(BaseEvent event) {
        Log.d("TooBarActivity", "onUiMessage() called with: event = [" + event.position() + "]");
    }

    @Override
    public void onTrMessage(BaseEvent event) {
        Log.d("TooBarActivity", "onTrMessage() called with: event = [" + event.position() + "]");
    }
}
