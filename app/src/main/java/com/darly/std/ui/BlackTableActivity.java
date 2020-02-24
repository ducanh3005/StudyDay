package com.darly.std.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.lifecycle.ViewModelProviders;

import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.table.TableData;
import com.bin.david.form.listener.OnColumnItemClickListener;
import com.darly.chinese.base.BaseActivity;
import com.darly.chinese.table.BlackTable;
import com.darly.std.BR;
import com.darly.std.R;
import com.darly.std.databinding.ActivityBlackTableBinding;
import com.darly.std.vm.BlackTableViewModel;
import com.darly.widget.dialog.SelectItemDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description TODO:表格界面信息框
 * Package com.darly.std.ui
 *
 * @author zhangyuhui
 * @date 2019/11/11 9:20
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class BlackTableActivity extends BaseActivity<ActivityBlackTableBinding, BlackTableViewModel> implements OnColumnItemClickListener<String>{

    @Override
    protected int layoutId() {
        return R.layout.activity_black_table;
    }

    @Override
    protected int initVariableId() {
        return BR.blackTableViewModel;
    }

    @Override
    protected BlackTableViewModel initViewModel() {
        return ViewModelProviders.of(this).get(BlackTableViewModel.class);
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        binding.toolbar.setTitleVisibly(true);
        binding.toolbar.setCenterTitle(R.string.app_name);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        initTable();
    }

    @Override
    public void initObservableView() {

    }

    ArrayList<BlackTable> list = new ArrayList<>();
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
        
        binding.idBtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAdd){
                    List<BlackTable> key = new ArrayList<>();
                    BlackTable table =new BlackTable(list.size());
                    key.add(table);
                    binding.idBtTable.addData(key,true);
                    isAdd = false;
                }else {
                    Log.i("onClick", "不满足新增行条件");
                }
            }
        });

        binding.idBtCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent();
                intent.putParcelableArrayListExtra("KEY",list);
                setResult(100,intent);
                finish();
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
        key0.setOnColumnItemClickListener(this);
        Column<String> key30 = new Column<>("30", "key30");
        key30.setOnColumnItemClickListener(this);
        isn =new Random().nextBoolean();
        if (isn){
            //稳定
            tableData = new TableData<BlackTable>("", list, id,key0,key30);
        }else {
            //不稳定
            Column<String> key15 = new Column<>("15", "key15");
            key15.setOnColumnItemClickListener(this);
            Column<String> key45 = new Column<>("45", "key45");
            key45.setOnColumnItemClickListener(this);
            tableData = new TableData<BlackTable>("", list, id,key0,key15,key30,key45);
        }
        binding.idBtTable.setTableData(tableData);
        binding.idBtTable.getConfig().setContentStyle(new FontStyle(50, Color.BLACK));
        binding.idBtTable.getConfig().setColumnTitleStyle(new FontStyle(60,Color.BLACK));
        binding.idBtTable.getConfig().setColumnTitleBackground(new BaseBackgroundFormat(Color.GRAY));
        binding.idBtTable.getConfig().setShowXSequence(false);
        binding.idBtTable.getConfig().setShowYSequence(false);
        binding.idBtTable.getConfig().setShowTableTitle(false);
        binding.idBtTable.getConfig().setMinTableWidth(width);
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
                        list.get(positon).setKey0(result);
                        binding.idBtTable.notifyDataChanged();
                    } else if ("key15".equals(column)) {
                        list.get(positon).setKey15(result);
                        binding.idBtTable.notifyDataChanged();
                    } else if ("key30".equals(column)) {
                        list.get(positon).setKey30(result);
                        binding.idBtTable.notifyDataChanged();
                        if (isn&&positon == list.size()-1){
                            isAdd = true;
                        }
                    } else if ("key45".equals(column)) {
                        list.get(positon).setKey45(result);
                        binding.idBtTable.notifyDataChanged();
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
    public void onClick(Column<String> column, String value, String s, int position) {
        if (!checkData(value,position)){
            selectColumn(column.getFieldName(),position);
        }
    }





}
