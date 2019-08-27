/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.qtest.viewpager;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Description TODO: 单个页面的ViewModel
 * Package com.darly.qtest.viewpager
 * @author zhangyuhui
 * Date 2019/7/25 11:47
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ItemViewPagerViewModel extends BaseObservable {

    String img;

    public ItemViewPagerViewModel(String img) {
        this.img = img;
    }

    @Bindable
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @BindingAdapter("img")
    public static void setImg(ImageView view,String img){
        Glide.with(view.getContext()).load(img).into(view);
    }
}
