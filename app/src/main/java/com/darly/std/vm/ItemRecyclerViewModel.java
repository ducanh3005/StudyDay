/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.vm;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.darly.chinese.db.chinese.bean.BaseBean;
import com.darly.chinese.db.chinese.bean.SongCiAuthorModel;
import com.darly.chinese.db.chinese.bean.SongCiModel;

/**
 * Description TODO:ViewModel类
 * Package com.darly.std.vm
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:04
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ItemRecyclerViewModel<B extends BaseBean> extends ViewModel {

    private B bean;
    private SongCiAuthorModel authorModel;
    private SongCiModel ciModel;
    private OnItemClickListener<B> onItemClickListener;

    public ItemRecyclerViewModel(B authorBean, OnItemClickListener<B> onItemClickListener) {
        this.bean = authorBean;
        if (bean instanceof SongCiAuthorModel) {
            authorModel = (SongCiAuthorModel) bean;
        } else if (bean instanceof SongCiModel) {
            ciModel = (SongCiModel) bean;
        }
        this.onItemClickListener = onItemClickListener;
    }

    public SongCiAuthorModel getAuthorModel() {
        return authorModel;
    }

    public SongCiModel getCiModel() {
        return ciModel;
    }

    public void itemClick(View view) {
        onItemClickListener.onItemClick(view,bean);
    }
}
