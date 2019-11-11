/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.column.ColumnInfo;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.bin.david.form.listener.OnColumnClickListener;
import com.bin.david.form.listener.OnColumnItemClickListener;
import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.event.BaseEvent;
import com.darly.chinese.event.EventController;
import com.darly.chinese.table.BlackTable;
import com.darly.std.databinding.ActivityMainBinding;
import com.darly.std.ui.CollectionActivity;
import com.darly.std.ui.RecyclerViewActivity;
import com.darly.std.vm.MainViewModel;
import com.darly.widget.dialog.SelectItemDialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.darly.std.vm.MainViewModel.Action.NEXTPAGE;
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

        initTable();
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
                int cout = (int) action.getParam();
                binding.idProgress.setProgress(cout);
                break;
            case NEXTPAGE:
                String authorModel = (String) action.getParam();
                Intent intent = new Intent(this, RecyclerViewActivity.class);
                intent.putExtra("Title", authorModel);
                startActivity(intent);
                break;
        }
    }

    List<BlackTable> list = new ArrayList<>();
    boolean isn = false;
    boolean isAdd = false;

    String [] keys = new String[]{
            "0","0.2","0.4","0.6","0.8",
            "1","1.2","1.4","1.6","1.8",
            "2","2.2","2.4","2.6","2.8",
            "3","3.2","3.4","3.6","3.8",
            "4","4.2","4.4","4.6","4.8",
            "5"
    };
    SelectItemDialog dialog = null;
    private void initTable(){
        binding.idMainAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAdd){
                    List<BlackTable> key = new ArrayList<>();
                    BlackTable table =new BlackTable(list.size());
                    key.add(table);
                    binding.table.addData(key,true);
                    isAdd = false;
                }else {
                    Log.i("onClick", "onClick() called with: view = [" + view + "]");
                }

            }
        });

        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        BlackTable table =new BlackTable(0);
        list.add(table);
        //表格数据 datas 是需要填充的数据
        TableData<BlackTable> tableData = null;
        //普通列
        Column<String> id = new Column<>("分秒", "id");
        Column<String> key0 = new Column<>("0", "key0");

        key0.setOnColumnItemClickListener(new OnColumnItemClickListener<String>() {
            @Override
            public void onClick(Column<String> column, String value, String s, int position) {
                if (!checkData(value,position)){
                    selectColumn(column.getFieldName(),position);
                }
            }
        });
        Column<String> key30 = new Column<>("30", "key30");

        key30.setOnColumnItemClickListener(new OnColumnItemClickListener<String>() {
            @Override
            public void onClick(Column<String> column, String value, String s, int position) {
                if (!checkData(value,position)){
                    selectColumn(column.getFieldName(),position);
                }
            }
        });
        isn =new Random().nextBoolean();
        if (isn){
            //稳定
            tableData = new TableData<BlackTable>("", list, id,key0,key30);
        }else {
            //不稳定
            Column<String> key15 = new Column<>("15", "key15");
            key15.setOnColumnItemClickListener(new OnColumnItemClickListener<String>() {
                @Override
                public void onClick(Column<String> column, String value, String s, int position) {
                    if (!checkData(value,position)){
                        selectColumn(column.getFieldName(),position);
                    }
                }
            });
            Column<String> key45 = new Column<>("45", "key45");
            key45.setOnColumnItemClickListener(new OnColumnItemClickListener<String>() {
                @Override
                public void onClick(Column<String> column, String value, String s, int position) {
                    if (!checkData(value,position)){
                        selectColumn(column.getFieldName(),position);
                    }
                }
            });
            tableData = new TableData<BlackTable>("", list, id,key0,key15,key30,key45);
        }
        binding.table.setTableData(tableData);
        binding.table.getConfig().setContentStyle(new FontStyle(50, Color.BLACK));
        binding.table.getConfig().setColumnTitleStyle(new FontStyle(60,Color.BLACK));
        binding.table.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(Color.GRAY));
        binding.table.getConfig().setShowXSequence(false);
        binding.table.getConfig().setShowYSequence(false);
        binding.table.getConfig().setShowTableTitle(false);
        binding.table.getConfig().setMinTableWidth(width);
    }

    private boolean checkData(String value,int position) {
        for (int i = 0;i<list.size();i++){
            try {
                if (Double.parseDouble(list.get(i).getKey0()) == 5) {
                    return fiveLevel(value,i==position);
                }
            }catch (Exception e) {
            }
            try {
                if (Double.parseDouble(list.get(i).getKey15()) == 5) {
                    return fiveLevel(value,i==position);
                }
            }catch (Exception e) {
            }
            try {
                if (Double.parseDouble(list.get(i).getKey30()) == 5) {
                    return fiveLevel(value,i==position);
                }
            }catch (Exception e) {
            }
            try {
                if (Double.parseDouble(list.get(i).getKey45()) == 5) {
                    return fiveLevel(value,i==position);
                }
            }catch (Exception e) {
            }
        }
        return false;
    }

    private boolean fiveLevel(String value,boolean isPos){
        try {
            if (Double.parseDouble(value) == 5 && isPos){
                return false;
            }else {
                Log.d("checkData", "浓度为5，不用继续测");
                return true;
            }
        } catch (Exception e){
            Log.d("checkData", "浓度为5，不用继续测");
            return true;
        }

    }


    private void selectColumn(final String column, final int positon){
        if (dialog == null) {
            SelectItemDialog dialog = new SelectItemDialog(this,keys , "选择值");
            dialog.setSelectResultItemClick(new SelectItemDialog.SelectResultItemClick() {
                @Override
                public void resultOnClick(String result, String title) {
                    if ("key0".equals(column)) {
                        list.get(positon).setKey0(result);binding.table.notifyDataChanged();
                    } else if ("key15".equals(column)) {
                        list.get(positon).setKey15(result);binding.table.notifyDataChanged();
                    } else if ("key30".equals(column)) {
                        list.get(positon).setKey30(result);
                        binding.table.notifyDataChanged();
                        if (isn&&positon == list.size()-1){
                            isAdd = true;
                        }
                    } else if ("key45".equals(column)) {
                        list.get(positon).setKey45(result);
                        binding.table.notifyDataChanged();
                        if (!isn&&positon == list.size()-1){
                            isAdd = true;
                        }
                    }

                }
            });
            dialog.show();
        }else {
            dialog.show();
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
        Log.d("MainActivity", "onUiMessage() called with: event = [" + event.position() + "]");
    }

    @Override
    public void onTrMessage(BaseEvent event) {
        super.onTrMessage(event);
        Log.d("MainActivity", "onTrMessage() called with: event = [" + event.position() + "]");
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
}
