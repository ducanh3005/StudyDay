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

/**
 * Description TODO:ViewModel类
 * Package com.darly.std.vm
 *
 * @author zhangyuhui
 * @date 2019/8/12 16:04
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ItemMainViewModel extends ViewModel {
    private String title;

    private OnItemClickListener<String> onItemClickListener;

    public ItemMainViewModel(String title, OnItemClickListener<String> onItemClickListener) {
        this.title = title;
        this.onItemClickListener = onItemClickListener;
    }

    public String getTitle() {
        return title;
    }


    public void itemClick(View view) {
        onItemClickListener.onItemClick(title);
    }
}
