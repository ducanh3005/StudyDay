/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bumptech.glide.Glide;
import com.darly.chinese.common.LogController;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;
import com.darly.dlcommon.framework.ContextController;
import com.darly.dlcommon.retrofit.RxjavaRetrofitRequestUtil;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.bean.SongCiAuthorModel;
import com.darly.std.bean.SongCiModel;
import com.darly.std.guide.MainGuideComponent;
import com.darly.std.retrofit.HttpInterface;
import com.darly.widget.guideview.Guide;
import com.darly.widget.guideview.GuideBuilder;
import com.google.gson.JsonObject;

import java.util.Timer;
import java.util.TimerTask;

import me.tatarka.bindingcollectionadapter2.ItemBinding;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
    private int count = 0;

    private MutableLiveData<Action> action = new MutableLiveData<>();
    private MutableLiveData<String> image = new MutableLiveData<>();

    public MainViewModel() {
        items.add(new ItemMainViewModel(SongCiAuthorModel.getClassName(), this));
        items.add(new ItemMainViewModel(SongCiModel.getClassName(), this));
        items.add(new ItemMainViewModel(SongCiAuthorModel.getClassName(), this));
        items.add(new ItemMainViewModel(SongCiModel.getClassName(), this));
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    count++;
                    if (count >= 100) {
                        count = 0;
                    }
                    action.postValue(new Action(Action.TIMERCOUNT, count));
                }
            }, 0, 100);
        }
//        image.setValue(ExternalStorageUtil.getDownLoadPath()+ File.separator +"pic.jpg");
    }

    public ObservableList<ItemMainViewModel> items = new ObservableArrayList<>();
    public ItemBinding<ItemMainViewModel> itemBinding = ItemBinding.of(BR.itemMainViewModel, R.layout.item_main_author);


    public MutableLiveData<Action> getAction() {
        return action;
    }

    @Override
    public void onItemClick(final View view, String s) {
        LogController.d("onItemClick", "onItemClick() called with: name = [" + s + "]");
        action.postValue(new Action(Action.NEXTPAGE, s));
    }

    public void firstGuideView(View view) {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(view)
                .setAlpha(150)
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


    public void updateImage(String path) {
        image.setValue(path);
    }

    /**
     * 1. 带view的参数：@{(view)->mainViewModel.tableClick(mainViewModel.image,view)}
     * 跳转到表格界面
     *
     * @param view 参数
     */
    public void tableClick(String path, View view) {
        LogController.d("tableClick", path + view);
        action.postValue(new Action(Action.TABLEEDIT, null));
    }

    /**
     * 2. 不带参数：@{() -> viewModel.click()}
     */
    public void click() {
        LogController.d("click");
        action.postValue(new Action(Action.RNPAGE, null));
    }

    /**
     * 3. 带参数：@{() -> viewModel.click(obj.id)}
     *
     * @param id 参数
     */
    public void click(String id) {
        LogController.d("click", id);
        action.postValue(new Action(Action.RNVISIT, null));
    }

    /**
     * 4. @{viewModel::imageClick}
     * 跳转到图片编辑页面
     *
     * @param view 参数
     */
    public void imageClick(View view) {
        LogController.d("imageClick", view);
        action.postValue(new Action(Action.IMAGEEIDT, null));
    }

    /**
     * 5. @{viewModel::navigatorClick}
     * 跳转到图片编辑页面
     *
     * @param view 参数
     */
    public void navigatorClick(View view) {
        action.postValue(new Action(Action.RN_NAVIGATOR, null));
    }
    /**
     * 5. @{viewModel::collectionClick}
     * 跳转到图片编辑页面
     *
     * @param view 参数
     */
    public void collectionClick(View view) {
        action.postValue(new Action(Action.COLLECTION_CLICK, null));
    }

    /**
     * 5. @{viewModel::listViewClick}
     * 跳转到图片编辑页面
     *
     * @param view 参数
     */
    public void listViewClick(View view) {
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
                        action.postValue(new Action(Action.LISTVIEW_CLICK, null));
                    }
                });


    }


    public class Action {
        public static final int NEXTPAGE = 0;
        public static final int TIMERCOUNT = 1;
        public static final int IMAGEEIDT = 2;
        public static final int TABLEEDIT = 3;
        public static final int RNPAGE = 4;
        public static final int RNVISIT = 5;
        public static final int RN_NAVIGATOR = 6;
        public static final int LISTVIEW_CLICK = 7;
        public static final int COLLECTION_CLICK = 8;

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

    public MutableLiveData<String> getImage() {
        return image;
    }

    @BindingAdapter("image")
    public static void image(ImageView view, String img) {
        Glide.with(view.getContext()).load(img).into(view);
    }
}
