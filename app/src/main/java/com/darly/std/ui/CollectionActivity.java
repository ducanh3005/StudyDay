/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.ui;


import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.databinding.ActivityCollectionBinding;
import com.darly.std.vm.CollectionViewModel;
import com.darly.widget.titlebar.TitleBar;

/**
 * Description TODO: 列表界面，展示数据
 * Package com.darly.std.ui
 *
 * @author zhangyuhui
 * @date 2019/8/23 15:07
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class CollectionActivity extends BaseActivity<ActivityCollectionBinding, CollectionViewModel> {
    @Override
    protected TitleBar getTitleBar() {
        String title = getIntent().getStringExtra("Title");
        binding.toolbar.setCenterTitle(title);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        return binding.toolbar;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected int initVariableId() {
        return BR.collectionViewModel;
    }

    @Override
    protected CollectionViewModel initViewModel() {
        return ViewModelProviders.of(this).get(CollectionViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initObservableView() {

    }
}
