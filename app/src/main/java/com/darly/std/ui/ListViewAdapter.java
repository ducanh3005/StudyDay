package com.darly.std.ui;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.darly.std.R;

import java.util.List;

/**
 * author:zhangyuhui
 * date:2020-04-2917:36
 * description:
 */
public class ListViewAdapter extends BaseAdapter{

    private Context context;
    private List<String> data;

    public ListViewAdapter(Context context,List<String> data){
        this.context = context;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv.setText(data.get(position));
        holder.des.setText(data.get(position));

        final ViewHolder finalHolder = holder;
        holder.des.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (finalHolder.id_test_item_action.getChildCount()>0){
                    finalHolder.id_test_item_action.setVisibility(View.GONE);
                    finalHolder.id_test_item_action.removeAllViews();
                }else {
                    //点击展开。
                    if ("2".equals(data.get(position))) {
                        for (int k = 100; k < 102; k++) {
                            finalHolder.id_test_item_action.addView(getSubList(k+""));
                        }
                    } else {
                        TextView tv = new TextView(context);
                        tv.setText(v.getId() + "");
                        finalHolder.id_test_item_action.addView(tv);
                    }
                    finalHolder.id_test_item_action.setVisibility(View.VISIBLE);
                }
            }
        });
        return convertView;
    }




    public class ViewHolder{

        TextView tv;
        TextView des;
        LinearLayout id_test_item_action;
        public ViewHolder(View view){
            tv = view.findViewById(R.id.id_test_item_tv);
            des = view.findViewById(R.id.id_test_item_des);
            id_test_item_action = view.findViewById(R.id.id_test_item_action);
        }

    }


    /**
     * ListView中嵌套列表。现有ListView进行嵌套。无法实现子列表动态高度变化。只能以动态增加控件形式进行变更。
     * @param data
     * @return
     */
    public View getSubList(String data){
       final View view = View.inflate(context, R.layout.item_list_sub, null);
        ((TextView)view.findViewById(R.id.id_test_item_tv)).setText(data);
        ((TextView)view.findViewById(R.id.id_test_item_des)).setText(data);
        final LinearLayout id_test_item_action = ((LinearLayout)view.findViewById(R.id.id_test_item_action));
        ((TextView)view.findViewById(R.id.id_test_item_des)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id_test_item_action.getChildCount()>0){
                    id_test_item_action.setVisibility(View.GONE);
                    id_test_item_action.removeAllViews();

                }else {
                    //点击展开。
                    TextView tv = new TextView(context);
                    tv.setText(v.getId() + "");
                    id_test_item_action.addView(tv);
                    id_test_item_action.setVisibility(View.VISIBLE);
                }

            }
        });
        return view;
    }
}
