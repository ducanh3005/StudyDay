package com.darly.std.widget.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.darly.std.R;

import java.util.ArrayList;
import java.util.List;

public class DoMainView extends RelativeLayout {

    private Context context;
    ViewPager viewPager;
    DoAdapter adapter;
    List<String> accats = new ArrayList<>();

    public DoMainView(Context context) {
        super(context);
       this.context = context;
    }

    public DoMainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public DoMainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public void connect(){
        init();
    }

    private void init(){
        addView(View.inflate(context, R.layout.domain_view,null));
        viewPager = findViewById(R.id.id_viewpage_vp);
        adapter = new DoAdapter();
        viewPager.setAdapter(adapter);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i =0;i<30;i++){
                            accats.add(i+"");
                        }

                        if (adapter!=null){
                            adapter.notifyDataSetChanged();
                        }
                    }
                });


            }
        }).start();
    }


    class DoAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return accats.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            TextView view = new TextView(getContext());
            view.setText("FFFFFFFFFFFFFFFFFFFFFFFF");
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
