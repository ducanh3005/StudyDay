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
import android.os.Handler;
import android.util.Log;

import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.decompression.DecompressionController;
import com.darly.chinese.parse.OnParseJsonListener;
import com.darly.chinese.parse.ParseJsonController;
import com.darly.std.databinding.ActivityGuideBinding;
import com.darly.std.vm.GuideViewModel;

/**
 * Description TODO: 欢迎界面，在这里进行初次打开数据校验
 * Package com.darly.std
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:00
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class GuideActivity extends BaseActivity<ActivityGuideBinding, GuideViewModel> implements OnParseJsonListener {


    private Handler handler = new Handler();


    @Override
    protected int layoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected int initVariableId() {
        return BR.guideVM;
    }

    @Override
    protected GuideViewModel initViewModel() {
        return ViewModelProviders.of(this).get(GuideViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        binding.idMainProgress.setProgress(0);
    }


    @Override
    public void initObservableView() {
        DecompressionController.getInstance().decompressionInit("","",this);
    }

    @Override
    public void onStart(String type) {
        binding.idMainProgress.setProgress(0);
        binding.idMainUpProgress.setProgress(0);
    }

    @Override
    public void onComplete(String type, Object ob) {
        if (DecompressionController.getInstance().type.equals(type)){
            ParseJsonController.getInstance().initParseJson(this);
        }

        Log.d(getClass().getSimpleName(), "onComplete() called");
        if (ParseJsonController.getInstance().type.equals(type)) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(GuideActivity.this, MainActivity.class));
                    finish();
                }
            }, 1000);
        }
    }

    @Override
    public void onProgress(final int percent) {
        Log.d("onProgress", "onProgress() called with: percent = [" + percent + "]");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                binding.idMainProgress.setProgress(percent);
            }
        });
    }

    @Override
    public void onSecProgress(final int percent) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                binding.idMainUpProgress.setProgress(percent);
            }
        });

    }

    @Override
    public void onFailed(String type, String msg) {
        Log.d(getClass().getSimpleName(), "onFailed() called with: msg = [" + msg + "]");
    }

}
