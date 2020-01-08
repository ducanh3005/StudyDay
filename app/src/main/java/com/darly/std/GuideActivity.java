/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std;

import android.Manifest;
import android.app.Activity;
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
import com.darly.chinese.decompression.DecompressionController;
import com.darly.chinese.fileload.ExternalStorageUtil;
import com.darly.chinese.fileload.FileController;
import com.darly.chinese.fileload.OnCopyFileListener;
import com.darly.chinese.parse.OnParseJsonListener;
import com.darly.chinese.parse.ParseJsonController;
import com.darly.chinese.soload.OnSoLoadListener;
import com.darly.chinese.soload.SoLoadController;
import com.darly.std.databinding.ActivityGuideBinding;
import com.darly.std.vm.GuideViewModel;
import com.xinlan.imageeditlibrary.editimage.fliter.PhotoProcessing;

import java.io.File;
import java.util.List;

/**
 * Description TODO: 欢迎界面，在这里进行初次打开数据校验
 * Package com.darly.std
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:00
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class GuideActivity extends BaseActivity<ActivityGuideBinding, GuideViewModel> implements OnParseJsonListener, OnCopyFileListener, OnSoLoadListener {


    private Handler handler = new Handler();

    private static int PERMATION = 0x0012;

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
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PERMATION);
                return;
            } else {
                //权限同意，不需要处理
                FileController.getInstance().copyFile("DownLoad", this);
            }
        } else {
            //低于23 不需要特殊处理
            FileController.getInstance().copyFile("DownLoad", this);
        }
    }


    @Override
    public void initObservableView() {

    }

    //文件复制
    @Override
    public void onCopyStart(String type) {
        binding.idMainType.setText(type);
        binding.idMainProgress.setProgress(0);
        binding.idMainUpProgress.setProgress(0);
    }

    @Override
    public void onCopyComplete(String type, Object ob) {
        if (ob instanceof List) {
            //复制的文件中包含压缩包
            DecompressionController.getInstance().decompressionInit((List<String>) ob, ExternalStorageUtil.getDownLoadPath(), this);
        }
    }

    @Override
    public void onCopyFailed(String type, String msg) {
        Log.d(getClass().getSimpleName(), "onCopyFailed() called with: msg = [" + msg + "]");
    }

    //解压和解析
    @Override
    public void onStart(String type) {
        binding.idMainType.setText(type);
        binding.idMainProgress.setProgress(0);
        binding.idMainUpProgress.setProgress(0);
    }

    @Override
    public void onComplete(String type, Object ob) {
        if (DecompressionController.getInstance().type.equals(type)) {
            SoLoadController.getInstance().init(this);
            SoLoadController.getInstance().copySo(false, this);
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

    //参数 requestCode是我们在申请权限的时候使用的唯一的申请码
    //String[] permission则是权限列表，一般用不到
    //int[] grantResults 是用户的操作响应，包含这权限是够请求成功
    //由于在权限申请的时候，我们就申请了一个权限，所以此处的数组的长度都是1
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMATION) {            //当然权限多了，建议使用Switch，不必纠结于此
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "权限申请成功", Toast.LENGTH_SHORT).show();
                FileController.getInstance().copyFile("DownLoad", this);
            } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, "权限申请失败，用户拒绝权限", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSoStart(String type) {
        binding.idMainType.setText(type);
        binding.idMainProgress.setProgress(0);
        binding.idMainUpProgress.setProgress(0);
    }

    @Override
    public void onSoComplete(String type, Object ob) {
        if (ob instanceof File[]){
            File[] fils = (File[]) ob;
            //这里进行SO初始化操作
            PhotoProcessing.initABIS(fils);
        }
        ParseJsonController.getInstance().initParseJson(this);
        Toast.makeText(this, "导入成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSoFailed(String type, String msg) {
        Toast.makeText(this, "导入失败", Toast.LENGTH_SHORT).show();
    }
}
