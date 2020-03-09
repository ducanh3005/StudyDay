package com.darly.std.crm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.common.InfoString;
import com.darly.chinese.db.chinese.bean.SongCiModel;
import com.darly.chinese.entitycontroller.ActivityConst;
import com.darly.chinese.entitycontroller.CreateEntityActivity;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.databinding.ActivityCreateSongciBinding;
import com.darly.std.vm.SongciCreateViewModel;
import com.darly.widget.titlebar.TitleBar;

/**
 * author:zhangyuhui
 * date:2020-03-0913:58
 * description: 尝试宋词对象建立实体对象。
 */
public class SongCiCreateActivity extends CreateEntityActivity<ActivityCreateSongciBinding, SongciCreateViewModel> {

    /**
     * 新建实体对象
     * @param context 上下文
     */
    public static void goCreate(Context context){
        Intent intent = new Intent(context,SongCiCreateActivity.class);
        context.startActivity(intent);
    }

    /**
     * 编辑实体对象
     * @param context 上下文
     */
    public static void goEdit(Context context, String title, SongCiModel data){
        Intent intent = new Intent(context,SongCiCreateActivity.class);
        intent.putExtra(ActivityConst.TITLE,title);
        intent.putExtra(ActivityConst.ENTITY,data);
        context.startActivity(intent);
    }

    @Override
    protected TitleBar getTitleBar() {
        return binding.songciToolbar;
    }


    @Override
    protected int layoutId() {
        return R.layout.activity_create_songci;
    }

    @Override
    protected int initVariableId() {
        return BR.songciCreateViewModel;
    }

    @Override
    protected SongciCreateViewModel initViewModel() {
        return ViewModelProviders.of(this).get(SongciCreateViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public void initObservableView() {

    }
}
