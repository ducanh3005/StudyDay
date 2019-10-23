/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.darly.chinese.db.chinese.bean.SongCiAuthorModel;
import com.darly.chinese.db.chinese.bean.SongCiModel;
import com.darly.chinese.parse.DetailUtilImpl;
import com.darly.chinese.parse.ExternalStorageUtil;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.guide.MainGuideComponent;
import com.darly.widget.guideview.Guide;
import com.darly.widget.guideview.GuideBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Timer;
import java.util.TimerTask;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Description TODO:ViewModel类
 * Package com.darly.std.vm
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:04
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class MainViewModel extends ViewModel implements OnItemClickListener<String> {

    private Timer timer;
    private int cout = 0;

    private final MutableLiveData<String> detailWebViewUrl = new MutableLiveData<>();

    MutableLiveData<Action> action = new MutableLiveData<>();

    public MainViewModel() {
//        items.add(new ItemMainViewModel(SongCiAuthorModel.getClassName(), this));
//        items.add(new ItemMainViewModel(SongCiModel.getClassName(), this));
//        items.add(new ItemMainViewModel(SongCiAuthorModel.getClassName(), this));
//        items.add(new ItemMainViewModel(SongCiModel.getClassName(), this));
//        if (timer == null) {
//            timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    cout++;
//                    if (cout >= 100) {
//                        cout = 0;
//                    }
//                    action.postValue(new Action(Action.TIMERCOUNT, cout));
//                }
//            }, 0, 100);
//        }


    }

    public ObservableList<ItemMainViewModel> items = new ObservableArrayList<>();
    public ItemBinding<ItemMainViewModel> itemBinding = ItemBinding.of(BR.itemModel, R.layout.item_main_author);


    public MutableLiveData<Action> getAction() {
        return action;
    }

    @Override
    public void onItemClick(final View view, String s) {
        Log.d("onItemClick", "onItemClick() called with: name = [" + s + "]");
        action.postValue(new Action(Action.NEXTPAGE, s));
    }

    public void firstGuideView(View view) {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(view)
                .setAlpha(255)
                .setHighTargetCorner(20)
                .setHighTargetPadding(10)
                .setOverlayTarget(false)
                .setOutsideTouchable(false);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
            }

            @Override
            public void onDismiss() {
            }
        });

        builder.addComponent(new MainGuideComponent());
        Guide guide = builder.createGuide();
        guide.setShouldCheckLocInWindow(true);
        guide.show((Activity) view.getContext());
    }


    public class Action {
        public static final int NEXTPAGE = 0;
        public static final int TIMERCOUNT = 1;
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


    public void setUrl(final WebView webView) {

        String catcher = ExternalStorageUtil.read(ExternalStorageUtil.GOODS_DETAIL_PATH, "432f8b8c-0381-4c3e-b49f-a76e386e05b4");
        try {
            //这里使用原始JSON解析、速度明显快了5s
            JSONObject jsonObject = new JSONObject(catcher);
            JSONObject header = jsonObject.optJSONObject("header");
            if ("0000".equals(header.optString("code"))) {
                //请求成功
                JSONObject body = jsonObject.optJSONObject("body");
                String details = body.optString("detail");

                if (!TextUtils.isEmpty(details)) {
                    String html = DetailUtilImpl.get().getHtmlData(details);


                    WebSettings settings = webView.getSettings();
                    //调整到适合webview的大小，不过尽量不要用，有些手机有问题
                    //settings.setUseWideViewPort(true);
                    //设置WebView是否使用预览模式加载界面。
                    settings.setLoadWithOverviewMode(false);
                    //不能垂直滑动
                    webView.setVerticalScrollBarEnabled(true);
                    //不能水平滑动
                    webView.setHorizontalScrollBarEnabled(false);
                    //通过设置WebSettings，改变HTML中文字的大小
//        settings.setTextSize(WebSettings.TextSize.LARGEST);
                    //支持通过JS打开新窗口
                    settings.setJavaScriptCanOpenWindowsAutomatically(true);
                    //设置WebView属性，能够执行Javascript脚本
                    //设置js可用
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient() {
                        @Override
                        public void onPageStarted(WebView view, String url, Bitmap favicon) {
                            super.onPageStarted(view, url, favicon);
                            Log.d("Tasker", "[WebView onPageStarted]");
                        }

                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            Log.d("Tasker", "[WebView onPageFinished]");
                        }
                    });
//        webView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                super.onReceivedSslError(view, handler, error);
//                handler.proceed(); //接受证书
//                webView.getSettings().setJavaScriptEnabled(true);
//            }
//        });
//        webView.addJavascriptInterface(new AndroidJavaScript(getApplication()), "android");//设置js接口
                    //支持内容重新布局
                    settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                    webView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
                    Log.d("Tasker", "[WebView开始加载]" + html);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }




    }
}
