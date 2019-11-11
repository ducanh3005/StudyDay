package com.darly.widget.dialog;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.darly.widget.R;


/**
 * @ClassName: SelectItemDialog.java
 */
public class SelectItemDialog extends Dialog {
    private Context mContext = null;
    private View mCustomView = null;
    private String[] clearItems;
    private String mTitle = null;
    private TextView mTvCancle = null;
    private TextView mTvPublishSelectTitle = null;
    private ListView mLvPublishTypes = null;
    private AffairsTypeAdapter adapter;
    private String result;

    public SelectItemDialog(Context context, String[] clearItems, String title) {
        super(context, R.style.PublishDialog);
        this.mContext = context;
        this.clearItems = clearItems;
        mTitle = title;
        init();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mCustomView = inflater.inflate(R.layout.dial_publish_select_dialog, null);
        setContentView(mCustomView);
        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        lp.width = dm.widthPixels - dip2px(mContext, 5.0f);
        lp.height = LayoutParams.WRAP_CONTENT;
        initView();
    }

    @Override
    public void show() {
        super.show();
    }

    private void initView() {
        mTvCancle = (TextView) mCustomView.findViewById(R.id.tv_publish_select_dialog_cancle);
        mTvPublishSelectTitle = (TextView) mCustomView.findViewById(R.id.tv_publish_select_dialog_title);
        mTvPublishSelectTitle.setText(mTitle);
        mLvPublishTypes = (ListView) mCustomView.findViewById(R.id.lv_publish_select_dialog);
        adapter = new AffairsTypeAdapter(mContext, clearItems);
        mLvPublishTypes.setAdapter(adapter);
        mLvPublishTypes.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                result = clearItems[0];
                if (selectResultItemClick != null) {
                    result = clearItems[position];
                    selectResultItemClick.resultOnClick(result, mTitle);
                }
                dismiss();
            }
        });

        mTvCancle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public class AffairsTypeAdapter extends BaseAdapter {
        private String[] clearItems = null;
        private LayoutInflater mInflater = null;

        public AffairsTypeAdapter(Context context, String[] clearItems) {
            mInflater = LayoutInflater.from(context);
            this.clearItems = clearItems;
        }

        @Override
        public int getCount() {
            return clearItems.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.dial_publish_select_dialog_item, null);
                holder = new ViewHolder();
                holder.mTvStyleName = (TextView) convertView.findViewById(R.id.tv_publish_slect_dialog_string);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mTvStyleName.setText(clearItems[position] + "");
            return convertView;
        }

        private class ViewHolder {
            private TextView mTvStyleName = null;
        }
    }

    private SelectResultItemClick selectResultItemClick;

    public void setSelectResultItemClick(SelectResultItemClick selectResultItemClick) {
        this.selectResultItemClick = selectResultItemClick;
    }

    public interface SelectResultItemClick {
        public void resultOnClick(String result, String title);
    }

}