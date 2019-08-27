/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.event.BaseEvent;
import com.darly.chinese.event.EventController;
import com.darly.std.databinding.ActivityMainBinding;
import com.darly.std.ui.RecyclerViewActivity;
import com.darly.std.vm.MainViewModel;

/**
 * Description 该类功能为：首界面
 * Package com.darly.std
 *
 * @author zhangyuhui
 * @date 2019/8/21
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int initVariableId() {
        return BR.mainViewModel;
    }

    @Override
    protected MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        binding.toolbar.setCenterTitle(R.string.app_name);
        setSupportActionBar(binding.toolbar);

        OperController.init();
    }

    @Override
    public void initObservableView() {
        viewModel.getAction().observe(this, new Observer<MainViewModel.Action>() {
            @Override
            public void onChanged(MainViewModel.Action action) {
                if (action != null) {
                    doAction(action);
                }
            }
        });
    }

    /**
     * 开始调用
     *
     * @param action 传递Action
     */
    private void doAction(MainViewModel.Action action) {
        String  authorModel = (String) action.getParam();
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        intent.putExtra("Title", authorModel);
        startActivity(intent);
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
    public void onUiMessage(BaseEvent event) {
        super.onUiMessage(event);
        Log.d("MainActivity", "onUiMessage() called with: event = [" + event.position() + "]");
    }

    @Override
    public void onTrMessage(BaseEvent event) {
        super.onTrMessage(event);
        Log.d("MainActivity", "onTrMessage() called with: event = [" + event.position() + "]");
    }
}
