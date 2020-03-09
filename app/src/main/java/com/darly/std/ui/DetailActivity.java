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

import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.db.chinese.bean.BaseBean;
import com.darly.chinese.db.chinese.bean.SongCiAuthorModel;
import com.darly.chinese.db.chinese.bean.SongCiModel;
import com.darly.chinese.event.BaseEvent;
import com.darly.chinese.event.EventController;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.bean.TooBarEvent;
import com.darly.std.databinding.ActivityDetailBinding;
import com.darly.std.vm.DetailViewModel;
import com.darly.widget.titlebar.TitleBar;

/**
 * Description TODO:详细信息界面
 * Package com.darly.std.ui
 *
 * @author zhangyuhui
 * @date 2019/8/22 16:46
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class DetailActivity extends BaseActivity<ActivityDetailBinding, DetailViewModel> {

    @Override
    protected TitleBar getTitleBar() {
        BaseBean bean = (BaseBean) getIntent().getSerializableExtra("BaseBean");
        viewModel.initModel(bean);
        if (bean instanceof SongCiAuthorModel) {
            binding.toolbar.setCenterTitle(((SongCiAuthorModel) bean).getName());
        } else if (bean instanceof SongCiModel) {
            binding.toolbar.setCenterTitle(((SongCiModel) bean).getRhythmic());
        } else {
            binding.toolbar.setCenterTitle(bean.getUUID().toString());
        }
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        return binding.toolbar;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected int initVariableId() {
        return BR.detailViewModel;
    }

    @Override
    protected DetailViewModel initViewModel() {
        return ViewModelProviders.of(this).get(DetailViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {

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
        Log.d("DetailActivity", "onUiMessage() called with: event = [" + event.position() + "]");
    }

    @Override
    public void onTrMessage(BaseEvent event) {
        Log.d("DetailActivity", "onTrMessage() called with: event = [" + event.position() + "]");
    }
}
