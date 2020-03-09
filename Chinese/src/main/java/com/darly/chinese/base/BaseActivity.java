/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import com.darly.chinese.event.BaseEvent;
import com.darly.dlcommon.common.StringUtil;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.widget.titlebar.TitleBar;
import com.darly.widget.titlebar.TitleBar.OnLeftButtonClickListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Description TODO:
 * Package com.darly.chinese.base
 *
 * @author zhangyuhui
 * @date 2019/8/22 17:29
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public abstract class BaseActivity<B extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity implements OnLeftButtonClickListener {

    protected B binding;
    protected V viewModel;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, layoutId());
        viewModel = initViewModel();
        binding.setVariable(initVariableId(), viewModel);

        initView(savedInstanceState);
        initObservableView();
        
        initHeader();
    }

    /**
     * 设置顶部标题栏.只对左边按钮进行设置
     */
    protected void initHeader() {
        TitleBar bar = getTitleBar();
        if (bar!=null) {
            bar.setOnLeftButtonClickListener(this);
        }
    }

    protected abstract TitleBar getTitleBar();


    /**
     * 获取界面Layout
     *
     * @return 返回layout
     */
    protected abstract int layoutId();

    /**
     * 获取ViewModel的ID
     *
     * @return 返回id
     */
    protected abstract int initVariableId();

    /**
     * 获取ViewModel对象
     *
     * @return 返回对象
     */
    protected abstract V initViewModel();


    /**
     * 初始化UI
     *
     * @param savedInstanceState
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化监听
     */
    public abstract void initObservableView();


    /**
     * 返回主线程的事件
     *
     * @param event 事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUiMessage(BaseEvent event) {
        DLog.d("onUiMessage() called with: event = [" + event.position() + "]");
    }

    /**
     * 返回子线程的事件
     *
     * @param event 事件
     */
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onTrMessage(BaseEvent event) {
        DLog.d("onTrMessage() called with: event = [" + event.position() + "]");
    }


    public boolean isEmpty(String arg){
        return StringUtil.isEmpty(arg);
    }


    @Override
    public void onClick(View view) {
        finish();
    }
}
