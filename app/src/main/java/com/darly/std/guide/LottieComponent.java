package com.darly.std.guide;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.darly.std.R;
import com.darly.widget.guideview.Component;
import com.darly.widget.guideview.Guide;

/**
 * Created by binIoter on 16/6/17.
 */
public class LottieComponent implements Component {

  @Override public View getView(LayoutInflater inflater) {

    LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.layer_lottie, null);
    ll.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Toast.makeText(view.getContext(), "引导层被点击了", Toast.LENGTH_SHORT).show();
      }
    });
    return ll;
  }

  @Override public int getAnchor() {
    return Component.ANCHOR_TOP;
  }

  @Override public int getFitPosition() {
    return Component.FIT_CENTER;
  }

  @Override public int getXOffset() {
    return 0;
  }

  @Override public int getYOffset() {
    return -30;
  }

  @Override
  public void setDismiss(Guide guide) {

  }
}
