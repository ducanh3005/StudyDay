package com.darly.std.guide;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.darly.std.R;
import com.darly.widget.guideview.Component;
import com.darly.widget.guideview.Guide;

public class MainGuideComponent implements Component {
    private Button btn;

    @Override
    public View getView(LayoutInflater inflater) {
        LinearLayout ll = new LinearLayout(inflater.getContext());
        LinearLayout.LayoutParams param =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setLayoutParams(param);
        TextView textView = new TextView(inflater.getContext());
        textView.setText(R.string.main_guide);
        textView.setTextColor(inflater.getContext().getResources().getColor(R.color.text));
        textView.setTextSize(20);
        btn = new Button(inflater.getContext());
        btn.setText(R.string.i_ok);
        ll.removeAllViews();
        ll.addView(textView);
        ll.addView(btn);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "引导层被点击了", Toast.LENGTH_SHORT).show();
            }
        });
        return ll;
    }

    @Override
    public int getAnchor() {
        return Component.ANCHOR_BOTTOM;
    }

    @Override
    public int getFitPosition() {
        return Component.FIT_CENTER;
    }

    @Override
    public int getXOffset() {
        return 0;
    }

    @Override
    public int getYOffset() {
        return 20;
    }

    @Override
    public void setDismiss(final Guide guide) {
        if (btn!=null){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    guide.dismiss();
                }
            });
        }
    }
}
