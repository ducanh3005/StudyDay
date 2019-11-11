package com.darly.std.ui;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.databinding.ActivityTestRecycleBinding;
import com.darly.std.vm.TestRecycleViewModel;

/**
 * Description TODO:
 * Package com.darly.std.ui
 *
 * @author zhangyuhui
 * @date 2019/11/11 18:22
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class TestRecycleViewActivity extends BaseActivity<ActivityTestRecycleBinding, TestRecycleViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.activity_test_recycle;
    }

    @Override
    protected int initVariableId() {
        return BR.testRecycleViewModel;
    }

    @Override
    protected TestRecycleViewModel initViewModel() {
        return ViewModelProviders.of(this).get(TestRecycleViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
    }

    @Override
    public void initObservableView() {

    }

}
