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
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.base.ControllerEnum;
import com.darly.chinese.common.LogController;
import com.darly.chinese.common.SpController;
import com.darly.chinese.controller.OnControllerBackListener;
import com.darly.chinese.controller.decompression.DecompressionController;
import com.darly.chinese.controller.fileload.ExternalStorageUtil;
import com.darly.chinese.controller.fileload.FileController;
import com.darly.chinese.controller.parse.ParseJsonController;
import com.darly.chinese.controller.soload.SoLoadController;
import com.darly.std.databinding.ActivityGuideBinding;
import com.darly.std.vm.GuideViewModel;
import com.darly.widget.titlebar.TitleBar;

import java.util.List;
import java.util.Random;

/**
 * Description TODO: 欢迎界面，在这里进行初次打开数据校验（使用MVVM框架进行实现）
 * Package com.darly.std
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:00
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class GuideActivity extends BaseActivity<ActivityGuideBinding, GuideViewModel> implements OnControllerBackListener {

    /**
     * 加载框更新
     */
    private Handler handler = new Handler();
    /**
     * 动态申请权限标记位
     */
    private static int PERMISSION = 0x0012;

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


        if (Build.VERSION.SDK_INT >= 23) {
            //缺少权限，进行权限申请
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION);
                return;
            } else {
                //权限同意，不需要处理
                resourceInit();
            }
        } else {
            //低于23 不需要特殊处理
            resourceInit();
        }

    }


    @Override
    public void initObservableView() {

    }


    public void resourceInit() {
        if (SpController.getInstance().getValue(SpEnum.SOVERSION.getDesc(), 0) == 0) {
            //初次加载
            LogController.d("resourceInit","初次加载");
            FileController.getInstance().copyFile("DownLoad", this);
        } else {
            //非初次加载
            if (SpController.getInstance().getValue(SpEnum.SOVERSION.getDesc(), 0) != 2){
                //有新版本需要更新
                LogController.d("resourceInit","有新版本需要更新");
                FileController.getInstance().copyFile("DownLoad", this);
            }else {
                LogController.d("resourceInit","不需要更新");
                //需要导入SO，否则崩溃
                SoLoadController.getInstance().installSoDir(this);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(GuideActivity.this, MainActivity.class));
                        finish();
                    }
                }, 1000);
            }
        }
    }


    //解压和解析
    @Override
    public void onStart(String type) {
        binding.idMainType.setText(type);
        binding.idMainProgress.setProgress(0);
        binding.idMainUpProgress.setProgress(0);
    }


    @Override
    public void onProgress(final int percent) {
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
    public void onComplete(String title, ControllerEnum type, Object ob) {
        binding.idMainType.setText(title);
        LogController.d("onComplete", "onComplete() called with: title = [" + title + "], type = [" + type + "], ob = [" + ob + "]");
        if (FileController.getInstance().getType().equals(type)) {
            if (ob instanceof List) {
                //复制的文件中包含压缩包
                DecompressionController.getInstance().decompressionInit((List<String>) ob, ExternalStorageUtil.getDownLoadPath(), this);
            }
        }
        if (DecompressionController.getInstance().getType().equals(type)) {
            SoLoadController.getInstance().copySo(this,false, this);
        }

        if (SoLoadController.getInstance().getType().equals(type)) {
            //这个是data/data路径下，直接使用System.load()方法导入SO包
//        if (ob instanceof File[]){
//            File[] fils = (File[]) ob;
//            //这里进行SO初始化操作
//            PhotoProcessing.initABIS(fils);
//        }
            ParseJsonController.getInstance().initParseJson(this);
            Toast.makeText(this, "导入成功", Toast.LENGTH_SHORT).show();
        }

        if (ParseJsonController.getInstance().getType().equals(type)) {
            SpController.getInstance().putValue(SpEnum.SOVERSION.getDesc(), new Random().nextInt(4));
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
    public void onFailed(String title, ControllerEnum type, String msg) {
        Toast.makeText(this, title + "\r\n" + msg, Toast.LENGTH_SHORT).show();
        binding.idMainType.setText(title);
        LogController.d("onFailed", "onFailed() called with: title = [" + title + "], type = [" + type + "], msg = [" + msg + "]");
        if (FileController.getInstance().getType().equals(type)) {

        }
        if (DecompressionController.getInstance().getType().equals(type)) {

        }

        if (SoLoadController.getInstance().getType().equals(type)) {

        }

        if (ParseJsonController.getInstance().getType().equals(type)) {

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
                resourceInit();
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "权限申请失败，用户拒绝权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
