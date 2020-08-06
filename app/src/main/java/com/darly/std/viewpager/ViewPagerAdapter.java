/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * Description TODO:ViewPager适配器
 * Package com.darly.std.viewpager
 *
 * @author zhangyuhui
 * Date 2019/7/25 13:28
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ViewPagerAdapter<T> extends PagerAdapter {
    private Context context;
    private List<T> list;
    private int variableId;
    private int layoutId;
    private LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, List<T> list, int variableId, int layoutId, LayoutInflater layoutInflater) {
        this.context = context;
        this.list = list;
        this.variableId = variableId;
        this.layoutId = layoutId;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        ViewDataBinding binding = (ViewDataBinding) o;
        return view == binding.getRoot();
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, layoutId, container, true);
        binding.setVariable(variableId, list.get(position));
        return binding;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewDataBinding binding = (ViewDataBinding) object;
        container.removeView(binding.getRoot());
    }
}
