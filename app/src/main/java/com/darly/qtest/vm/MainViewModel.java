/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.qtest.vm;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.darly.chinese.db.chinese.bean.SongCiAuthorModel;
import com.darly.chinese.db.crud.DataReposController;
import com.darly.qtest.BR;
import com.darly.qtest.R;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Description TODO:ViewModel类
 * Package com.darly.qtest.vm
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:04
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class MainViewModel extends ViewModel implements OnItemClickListener<String> {

    MutableLiveData<Action> action = new MutableLiveData<>();

    public MainViewModel() {

        items.add(new ItemMainViewModel("宋词作者", this));
    }

    public ObservableList<ItemMainViewModel> items = new ObservableArrayList<>();
    public ItemBinding<ItemMainViewModel> itemBinding = ItemBinding.of(BR.itemModel, R.layout.item_main_author);

    @Override
    public void onItemClick(String songCiAuthorModel) {
        Log.d("onItemClick", "onItemClick() called with: songCiAuthorModel = [" + songCiAuthorModel + "]");
        action.postValue(new Action(Action.NEXTPAGE,songCiAuthorModel));
    }

    public MutableLiveData<Action> getAction() {
        return action;
    }

    public class Action {
        public static final int NEXTPAGE = 0;
        private final int mAction;

        private Object param;

        public Action(int action,Object param) {
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
