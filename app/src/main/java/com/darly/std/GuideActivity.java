/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;
import com.darly.dlcommon.framework.ContextController;
import com.darly.dlcommon.retrofit.RxjavaRetrofitRequestUtil;
import com.darly.rnmodule.ui.RNNavigatorActivity;
import com.darly.std.databinding.ActivityGuideBinding;
import com.darly.std.retrofit.HttpInterface;
import com.darly.std.ui.ListViewActivity;
import com.darly.std.vm.GuideViewModel;
import com.darly.widget.titlebar.TitleBar;
import com.google.gson.JsonObject;


import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.darly.std.vm.GuideViewModel.Action.MAINPRO;
import static com.darly.std.vm.GuideViewModel.Action.NEXTPAGE;
import static com.darly.std.vm.GuideViewModel.Action.PROGRESSINIT;
import static com.darly.std.vm.GuideViewModel.Action.SECPRO;
import static com.darly.std.vm.GuideViewModel.Action.TITLE;

/**
 * Description TODO: 欢迎界面，在这里进行初次打开数据校验（使用MVVM框架进行实现）
 * Package com.darly.std
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:00
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class GuideActivity extends BaseActivity<ActivityGuideBinding, GuideViewModel> {

    /**
     * 加载框更新
     */
    private Handler handler = new Handler();
    /**
     * 动态申请权限标记位
     */
    private static int PERMISSION = 0x0012;

    @Override
    protected TitleBar getTitleBar() {
        return null;
    }

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
        if (BuildConfig.DEBUG){
            //DEBUG模式下，直接跳转界面

            Toast.makeText(this, "DEBUG模式", Toast.LENGTH_SHORT).show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //尝试网络请求

                    RxjavaRetrofitRequestUtil.getInstance().get(HttpInterface.class).getKey((String) ContextController.getInstance().getSharePerferenceController().getValue(NetUtil.SYSTEM_IP))
                            .subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .map(new Func1<JsonObject, String >() {
                                @Override
                                public String call(JsonObject s) {
                                    DLog.json("Func1", s.toString());
                                    return s.toString();
                                }
                            })
                            .subscribe(new rx.Observer<String>() {
                                @Override
                                public void onCompleted() {

                                }

                                @Override
                                public void onError(Throwable e) {

                                }

                                @Override
                                public void onNext(String s) {
                                    DLog.json("onNext", s);
                                  startActivity(new Intent(GuideActivity.this, ListViewActivity.class));
//                                    startActivity(new Intent(GuideActivity.this, RNNavigatorActivity.class));
                                    finish();
                                }
                            });
                }
            }, 1000);
        }else {
            if (Build.VERSION.SDK_INT >= 23) {
                //缺少权限，进行权限申请
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION);
                    return;
                } else {
                    //权限同意，不需要处理
                    viewModel.resourceInit();
                }
            } else {
                //低于23 不需要特殊处理
                viewModel.resourceInit();
            }
        }

    }


    @Override
    public void initObservableView() {
        viewModel.getAction().observe(this, new Observer<GuideViewModel.Action>() {
            @Override
            public void onChanged(GuideViewModel.Action action) {
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
    private void doAction(GuideViewModel.Action action) {
        switch (action.getValue()) {
            case TITLE:
                binding.idMainType.setText((String) action.getParam());
                break;
            case PROGRESSINIT:
                binding.idMainProgress.setProgress(0);
                binding.idMainUpProgress.setProgress(0);
                break;
            case MAINPRO:
                binding.idMainProgress.setProgress((int) action.getParam());
                break;
            case SECPRO:
                binding.idMainUpProgress.setProgress((int) action.getParam());
                break;
            case NEXTPAGE:
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        if (viewModel.getIsOpenReactNative().getValue()){
                            startActivity(new Intent(GuideActivity.this, RNNavigatorActivity.class));
//                        }else {
//                            String json = "{\"action\":\"loginCallBack\"}";
//                            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
//                            ParsableBean bean = new ParsableBean();
//                                bean.skills.add(json);
//                            intent.putExtra("ParsableBean",bean);
//                            startActivity(intent);
//                        }
                        finish();
                    }
                }, 1000);
                break;
        }
    }


    //参数 requestCode是我们在申请权限的时候使用的唯一的申请码
    //String[] permission则是权限列表，一般用不到
    //int[] grantResults 是用户的操作响应，包含这权限是够请求成功
    //由于在权限申请的时候，我们就申请了一个权限，所以此处的数组的长度都是1
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION) {            //当然权限多了，建议使用Switch，不必纠结于此
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "权限申请成功", Toast.LENGTH_SHORT).show();
                viewModel.resourceInit();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "权限申请失败，用户拒绝权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
