/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;

import android.view.View;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.darly.std.BR;
import com.darly.std.R;

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
public class TestRecycleViewModel extends ViewModel implements OnItemClickListener<String> {

    MutableLiveData<Action> action = new MutableLiveData<>();

    public TestRecycleViewModel() {
        for (int i = 0; i < 10; i++) {
            items.add(new ItemTestRecycleViewModel(i + "", this));
        }
    }

    public ObservableList<ItemTestRecycleViewModel> items = new ObservableArrayList<>();
    public ItemBinding<ItemTestRecycleViewModel> itemBinding = ItemBinding.of(BR.itemTestRecycleViewModel, R.layout.item_test_recycle);

    @Override
    public void onItemClick(View view, String s) {

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
