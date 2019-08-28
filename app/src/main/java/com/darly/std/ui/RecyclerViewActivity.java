/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.db.chinese.bean.BaseBean;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.databinding.ActivityRecyclerBinding;
import com.darly.std.vm.RecyclerViewModel;

/**
 * Description TODO: 列表界面，展示数据
 * Package com.darly.std.ui
 *
 * @author zhangyuhui
 * @date 2019/8/23 15:07
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class RecyclerViewActivity extends BaseActivity<ActivityRecyclerBinding, RecyclerViewModel> {

    private String title;

    @Override
    protected int layoutId() {
        return R.layout.activity_recycler;
    }

    @Override
    protected int initVariableId() {
        return BR.recyclerViewModel;
    }

    @Override
    protected RecyclerViewModel initViewModel() {
        return ViewModelProviders.of(this).get(RecyclerViewModel.class);
    }


    @Override
    public void initView(Bundle savedInstanceState) {
        title = getIntent().getStringExtra("Title");
        viewModel.setItemTag(title);
        binding.toolbar.setCenterTitle(title);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void initObservableView() {
        viewModel.getAction().observe(this, new Observer<RecyclerViewModel.Action>() {
            @Override
            public void onChanged(RecyclerViewModel.Action action) {
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
    private void doAction(RecyclerViewModel.Action action) {
        BaseBean bean = (BaseBean) action.getParam();
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("BaseBean", bean);
        startActivity(intent);
    }
}
