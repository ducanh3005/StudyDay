package com.darly.chinese.entitycontroller;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import com.darly.chinese.R;
import com.darly.chinese.common.InfoString;
import com.darly.widget.titlebar.TitleBar;
import com.darly.widget.toast.ToastController;


/**
 * author:zhangyuhui
 * date:2020-03-0910:31
 * description: 更新对象实体类，每一个新对象，都有增删改查操作。
 */
public abstract class UpdateEntityActivity<B extends ViewDataBinding, V extends ViewModel> extends AppCompatActivity implements TitleBar.OnLeftButtonClickListener, TitleBar.OnRightButtonClickListener {

    protected B binding;
    protected V viewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, layoutId());
        viewModel = initViewModel();
        binding.setVariable(initVariableId(), viewModel);

        initView(savedInstanceState);

        initHeader();
        initObservableView();
    }

    /**
     * 初始化标题栏
     */
    protected void initHeader() {
        TitleBar toolbar = getTitleBar();
        if (toolbar != null) {
            toolbar.setCenterTitle(getTitleName());
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            toolbar.setOnLeftButtonClickListener(this);
            toolbar.setRightButtonText(InfoString.getString(R.string.entity_save));
            toolbar.setOnRightButtonClickListener(this);
        }
    }

    /**
     * 从子界面中获取标题栏
     *
     * @return 标题栏
     */
    protected abstract TitleBar getTitleBar();

    /**
     * 获取标题栏名称
     *
     * @return 返回名称
     */
    protected String getTitleName() {
        if (getIntent() != null && getIntent().hasExtra(ActivityConst.TITLE)) {
            return getIntent().getStringExtra(ActivityConst.TITLE);
        }
        return InfoString.getString(R.string.entity_create);
    }

    /**
     * 获取界面Layout
     *
     * @return 返回layout
     */
    protected abstract int layoutId();

    /**
     * 获取ViewModel的ID
     *
     * @return 返回id
     */
    protected abstract int initVariableId();

    /**
     * 获取ViewModel对象
     *
     * @return 返回对象
     */
    protected abstract V initViewModel();


    /**
     * 初始化UI
     *
     * @param savedInstanceState
     */
    public abstract void initView(Bundle savedInstanceState);

    /**
     * 初始化监听
     */
    public abstract void initObservableView();


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.toolbar_leftButton) {
            finish();
        } else if (view.getId() == R.id.toolbar_rightButton) {
            save();
        } else if (view.getId() == R.id.toolbar_rightButton_img) {

        }

    }

    /**
     * 保存操作
     */
    public void save() {
        ToastController.showShort(this, "save");

    }

}
