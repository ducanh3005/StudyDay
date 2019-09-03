/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;

import android.util.Log;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.darly.chinese.db.chinese.bean.SongCiAuthorModel;
import com.darly.chinese.db.chinese.bean.SongCiModel;
import com.darly.std.BR;
import com.darly.std.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    MutableLiveData<Action> action = new MutableLiveData<>();

    public MainViewModel() {
        items.add(new ItemMainViewModel(SongCiAuthorModel.getClassName(), this));
        items.add(new ItemMainViewModel(SongCiModel.getClassName(), this));
        items.add(new ItemMainViewModel(SongCiAuthorModel.getClassName(), this));
        items.add(new ItemMainViewModel(SongCiModel.getClassName(), this));
        if (timer == null){
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    cout++;
                    if (cout >= 100) {
                        cout = 0;
                    }
                    action.postValue(new Action(Action.TIMERCOUNT, cout));
                }
            },0,100);
        }
    }

    public ObservableList<ItemMainViewModel> items = new ObservableArrayList<>();
    public ItemBinding<ItemMainViewModel> itemBinding = ItemBinding.of(BR.itemModel, R.layout.item_main_author);

    @Override
    public void onItemClick(String name) {
        Log.d("onItemClick", "onItemClick() called with: name = [" + name + "]");
        action.postValue(new Action(Action.NEXTPAGE, name));
    }

    public MutableLiveData<Action> getAction() {
        return action;
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

}
