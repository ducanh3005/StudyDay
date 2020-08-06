/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;


import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.darly.chinese.base.ControllerEnum;
import com.darly.chinese.common.LogController;
import com.darly.chinese.common.SpController;
import com.darly.chinese.controller.OnControllerBackListener;
import com.darly.chinese.controller.decompression.DecompressionController;
import com.darly.chinese.controller.fileload.ExternalStorageUtil;
import com.darly.chinese.controller.fileload.FileController;
import com.darly.chinese.controller.parse.ParseJsonController;
import com.darly.chinese.controller.soload.SoLoadController;
import com.darly.std.SpEnum;

import java.util.List;
import java.util.Random;

/**
 * Description TODO:ViewModel类
 * Package com.darly.std.vm
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:04
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class GuideViewModel extends ViewModel implements OnControllerBackListener {

    private MutableLiveData<Action> action = new MutableLiveData<>();

    private MutableLiveData<Boolean> isOpenReactNative = new MutableLiveData<>();

    public GuideViewModel() {
        isOpenReactNative.setValue(false);
    }


    public void resourceInit() {
        if (SpController.getInstance().getValue(SpEnum.SO_VERSION.getDesc(), 0) == 0) {
            //初次加载
            LogController.d("resourceInit", "初次加载");
            FileController.getInstance().copyFile("DownLoad", this);
        } else {
            //非初次加载
            if (SpController.getInstance().getValue(SpEnum.SO_VERSION.getDesc(), 0) != 2) {
                //有新版本需要更新
                LogController.d("resourceInit", "有新版本需要更新");
                FileController.getInstance().copyFile("DownLoad", this);
            } else {
                LogController.d("resourceInit", "不需要更新");
                //需要导入SO，否则崩溃
                SoLoadController.getInstance().installSoDir();
                action.postValue(new Action(Action.NEXTPAGE, null));
            }
        }
    }

    @Override
    public void onStart(String title) {
        action.postValue(new Action(Action.PROGRESSINIT, null));
        action.postValue(new Action(Action.TITLE, title));
    }

    @Override
    public void onProgress(int percent) {
        action.postValue(new Action(Action.MAINPRO, percent));
    }

    @Override
    public void onSecProgress(int percent) {
        action.postValue(new Action(Action.SECPRO, percent));
    }

    @Override
    public void onComplete(String title, ControllerEnum type, Object ob) {
        action.postValue(new Action(Action.TITLE, title));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogController.d("onComplete", "onComplete() called with: title = [" + title + "], type = [" + type + "], ob = [" + ob + "]");
        if (FileController.getInstance().getType().equals(type)) {
            if (ob instanceof List) {
                //复制的文件中包含压缩包
                DecompressionController.getInstance().decompressionInit((List<String>) ob, ExternalStorageUtil.getDownLoadPath(), this);
            }
        }
        if (DecompressionController.getInstance().getType().equals(type)) {
            SoLoadController.getInstance().copySo(false, this);
        }

        if (SoLoadController.getInstance().getType().equals(type)) {
            //这个是data/data路径下，直接使用System.load()方法导入SO包
//        if (ob instanceof File[]){
//            File[] fils = (File[]) ob;
//            //这里进行SO初始化操作
//            PhotoProcessing.initABIS(fils);
//        }
            ParseJsonController.getInstance().initParseJson(this);
        }

        if (ParseJsonController.getInstance().getType().equals(type)) {
            SpController.getInstance().putValue(SpEnum.SO_VERSION.getDesc(), new Random().nextInt(4));
            action.postValue(new Action(Action.NEXTPAGE, null));
        }


    }

    @Override
    public void onFailed(String title, ControllerEnum type, String msg) {
        action.postValue(new Action(Action.TITLE, title));
        LogController.d("onFailed", "onFailed() called with: title = [" + title + "], type = [" + type + "], msg = [" + msg + "]");
    }


    /**
     * 4. @{viewModel::openRN}
     * 跳转到图片编辑页面
     *
     * @param view 参数
     */
    public void openRN(View view) {
        isOpenReactNative.postValue(true);
        LogController.d("openRN", view);
    }


    public class Action {
        public static final int NEXTPAGE = 0;
        public static final int PROGRESSINIT = 1;
        public static final int MAINPRO = 2;
        public static final int SECPRO = 3;
        public static final int TITLE = 4;
        private final int mAction;

        private Object param;

        public Action(int action, Object param) {
            mAction = action;
            this.param = param;
        }

        public Object getParam() {
            return param;
        }

        public int getValue() {
            return mAction;
        }
    }

    public MutableLiveData<Action> getAction() {
        return action;
    }

    public MutableLiveData<Boolean> getIsOpenReactNative() {
        return isOpenReactNative;
    }
}
