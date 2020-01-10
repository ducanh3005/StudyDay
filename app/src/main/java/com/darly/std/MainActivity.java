/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.common.LogController;
import com.darly.chinese.controller.fileload.ExternalStorageUtil;
import com.darly.chinese.event.BaseEvent;
import com.darly.chinese.event.EventController;
import com.darly.chinese.table.BlackTable;
import com.darly.imageeditor.editimage.EditImageActivity;
import com.darly.std.databinding.ActivityMainBinding;
import com.darly.std.rn.ui.RNStudyActivity;
import com.darly.std.ui.BlackTableActivity;
import com.darly.std.ui.CollectionActivity;
import com.darly.std.ui.RecyclerViewActivity;
import com.darly.std.vm.MainViewModel;
import com.facebook.react.ReactApplication;

import java.io.File;
import java.util.ArrayList;

import static com.darly.std.vm.MainViewModel.Action.IMAGEEIDT;
import static com.darly.std.vm.MainViewModel.Action.NEXTPAGE;
import static com.darly.std.vm.MainViewModel.Action.RNPAGE;
import static com.darly.std.vm.MainViewModel.Action.TABLEEDIT;
import static com.darly.std.vm.MainViewModel.Action.TIMERCOUNT;

/**
 * Description 该类功能为：首界面
 * Package com.darly.std
 *
 * @author zhangyuhui
 * @date 2019/8/21
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int initVariableId() {
        return BR.mainViewModel;
    }

    @Override
    protected MainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(MainViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        binding.toolbar.setTitleVisibly(true);
        binding.toolbar.setCenterTitle(R.string.app_name);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        OperController.init();
        binding.toolbar.post(new Runnable() {
            @Override
            public void run() {
                viewModel.firstGuideView(binding.toolbar);
            }
        });
//        binding.reactRootView.startReactApplication(((ReactApplication)this.getApplicationContext()).getReactNativeHost().getReactInstanceManager(),"StudyDay");
    }


    @Override
    public void initObservableView() {
        viewModel.getAction().observe(this, new Observer<MainViewModel.Action>() {
            @Override
            public void onChanged(MainViewModel.Action action) {
                if (action != null) {
                    doAction(action);
                }
            }
        });
    }


    /**
     * 开始调用
     *
     * @param action 传递Action
     */
    private void doAction(MainViewModel.Action action) {
        switch (action.getValue()) {
            case TIMERCOUNT:
                int count = (int) action.getParam();
                binding.idProgress.setProgress(count);
                break;
            case NEXTPAGE:
                String authorModel = (String) action.getParam();
                Intent intent = new Intent(this, RecyclerViewActivity.class);
                intent.putExtra("Title", authorModel);
                startActivity(intent);
                break;
            case IMAGEEIDT:
                EditImageActivity.start(this, ExternalStorageUtil.getDownLoadPath()+ File.separator +"pic.jpg",200);
                break;
            case TABLEEDIT:
                Intent intentTable = new Intent(this, BlackTableActivity.class);
                startActivityForResult(intentTable, 100);
                break;
            case RNPAGE:
                startActivity(new Intent(this, RNStudyActivity.class));
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        EventController.register(this);
    }


    @Override
    protected void onStop() {
        super.onStop();
        EventController.unregister(this);
    }


    @Override
    public void onUiMessage(BaseEvent event) {
        super.onUiMessage(event);
        LogController.d("MainActivity", "onUiMessage() called with: event = [" + event.position() + "]");
    }

    @Override
    public void onTrMessage(BaseEvent event) {
        super.onTrMessage(event);
        LogController.d("MainActivity", "onTrMessage() called with: event = [" + event.position() + "]");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        // Get the SearchView and set the searchable configuration
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.id_menu_search).getActionView();
//        searchView.setQueryHint("搜索内容");
//        // Assumes current activity is the searchable activity
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//        //searchview 的关闭监听
//        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
//            @Override
//            public boolean onClose() {
//                return false;
//            }
//        });
//        //根据id-search_src_text获取TextView
//        SearchView.SearchAutoComplete searchViewOfKnowledge = searchView.findViewById(R.id.search_src_text);
//        //改变输入文字的颜色
//        searchViewOfKnowledge.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.id_menu_search) {
//            return true;
//        }
        switch (id) {
            case R.id.id_menu_setting:
                //设置界面
            case R.id.id_menu_help:
                //帮助界面
                Toast.makeText(this,"功能未实现",Toast.LENGTH_LONG).show();
                break;
            case R.id.id_menu_collection:
                //统计界面
                Intent intent = new Intent(this, CollectionActivity.class);
                intent.putExtra("Title", "统计");
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data==null){
            return;
        }
        if (requestCode == 100){
            ArrayList<BlackTable> tables = data.getParcelableArrayListExtra("KEY");
        }

        if (requestCode == 200){
            viewModel.updateImage(ExternalStorageUtil.getDownLoadPath()+ File.separator +"pic.jpg");
        }
    }
}
