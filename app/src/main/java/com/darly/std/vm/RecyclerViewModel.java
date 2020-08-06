/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;

import android.util.Log;
import android.view.View;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.darly.chinese.db.chinese.bean.BaseBean;
import com.darly.chinese.db.chinese.bean.SongCiAuthorModel;
import com.darly.chinese.db.chinese.bean.SongCiModel;
import com.darly.chinese.db.crud.DataReposController;
import com.darly.std.BR;
import com.darly.std.R;

import java.util.List;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Description TODO:列表展示类
 * Package com.darly.std.vm
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:04
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class RecyclerViewModel extends ViewModel implements OnItemClickListener<BaseBean> {

    MutableLiveData<Action> action = new MutableLiveData<>();

    private int PAGENUB = 20;
    private int PAGESIZE = 0;

    public RecyclerViewModel() {
    }


    public ObservableList<ItemRecyclerViewModel<BaseBean>> items = new ObservableArrayList<>();
    public ItemBinding<ItemRecyclerViewModel<BaseBean>> itemBinding;

    public void setItemTag(String key) {
        if (SongCiAuthorModel.getClassName().equals(key)) {
            itemBinding = ItemBinding.of(BR.itemRecyclerViewModel, R.layout.item_recycler);
            List<SongCiAuthorModel> models = DataReposController.findSongCiAuthors(PAGENUB, PAGESIZE);
            for (SongCiAuthorModel bean : models) {
                items.add(new ItemRecyclerViewModel(bean, this));
            }
        } else if (SongCiModel.getClassName().equals(key)) {
            itemBinding = ItemBinding.of(BR.itemRecyclerViewModel, R.layout.item_recycler_sc);
            List<SongCiModel> models = DataReposController.findSongCis(PAGENUB, PAGESIZE);
            for (SongCiModel bean : models) {
                items.add(new ItemRecyclerViewModel(bean, this));
            }
        }
    }


    @Override
    public void onItemClick(View view, BaseBean bean) {
        Log.d("onItemClick", "onItemClick() called with: BaseBean = [" + bean + "]");
        action.postValue(new Action(Action.NEXTPAGE, bean));
    }

    public MutableLiveData<Action> getAction() {
        return action;
    }

    public class Action {
        public static final int NEXTPAGE = 0;
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
