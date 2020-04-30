package com.darly.std.ui;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.darly.std.R;

import java.util.ArrayList;

/**
 * Description TODO:表格界面信息框
 * Package com.darly.std.ui
 *
 * @author zhangyuhui
 * @date 2019/11/11 9:20
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ListViewActivity extends AppCompatActivity {

    private ListView id_test_list;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        id_test_list = findViewById(R.id.id_test_list);
        ArrayList<String > data = new ArrayList<>();
        for (int i= 0;i<6;i++){
            data.add(i+"");
        }
        adapter = new ListViewAdapter(this,data);
        id_test_list.setAdapter(adapter);
    }


}
