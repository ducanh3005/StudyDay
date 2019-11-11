/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.viewpager;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.darly.std.BR;
import com.darly.std.MainActivity;
import com.darly.std.R;
import com.darly.std.databinding.ActivityViewpageBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Description TODO:MVVM进行ViewPager测试
 * Package com.darly.std.viewpager
 * @author zhangyuhui
 * Date 2019/7/25 11:39
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ViewPagerActivity extends AppCompatActivity {

    private ActivityViewpageBinding binding;

    private ViewPager viewPager;

    private Button id_viewpage_btn;

    private ViewPagerAdapter<ItemViewPagerViewModel> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_viewpage);
        viewPager = binding.idViewpageVp;
        id_viewpage_btn = binding.idViewpageBtn;
        List<ItemViewPagerViewModel> list = new ArrayList<>();
        list.add(new ItemViewPagerViewModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564637849&di=dd0207bc4afb6d94b271f878c437dd92&imgtype=jpg&er=1&src=http%3A%2F%2Fs13.sinaimg.cn%2Fmw690%2F001M7ctNgy6MqM8QGzWbc%26amp%3B690"));
        list.add(new ItemViewPagerViewModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564043130343&di=876b872c13609a443c42d1642983c38d&imgtype=0&src=http%3A%2F%2Fwww.people.com.cn%2Fmediafile%2Fpic%2F20161125%2F33%2F4445887895393160273.jpg"));
        list.add(new ItemViewPagerViewModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564043130343&di=6b902b30c51c934e480f98b1fb15149d&imgtype=0&src=http%3A%2F%2Fs9.rr.itc.cn%2Fr%2FwapChange%2F20174_11_13%2Fa57d3n7620168419619.jpg"));
        list.add(new ItemViewPagerViewModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1564043130342&di=e1eef8dda2ea9057509e84e701506fa8&imgtype=0&src=http%3A%2F%2Fbbs-fd.zol-img.com.cn%2Ft_s1200x5000%2Fg1%2FM03%2F0A%2F0A%2FCg-4jVNWGk-IaMIlAAc67uSza7UAAMqEQMd4y8ABzsG455.jpg"));

        adapter = new ViewPagerAdapter<>(this, list, BR.itemViewPagerViewModel, R.layout.item_viewpage, getLayoutInflater());
        viewPager.setAdapter(adapter);

        id_viewpage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewPagerActivity.this, MainActivity.class));
            }
        });

    }
}
