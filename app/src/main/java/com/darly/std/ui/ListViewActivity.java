package com.darly.std.ui;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.darly.dlcommon.common.StringUtil;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.common.net.NetUtil;
import com.darly.dlcommon.framework.ContextController;
import com.darly.dlcommon.json2view.DynamicView;
import com.darly.dlcommon.retrofit.RxjavaRetrofitRequestUtil;
import com.darly.std.R;
import com.darly.std.retrofit.HttpInterface;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import me.samlss.broccoli.Broccoli;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
    private Broccoli broccoli = new Broccoli();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxjavaRetrofitRequestUtil.getInstance().get(HttpInterface.class).getKey((String) ContextController.getInstance().getSharePerferenceController().getValue(NetUtil.SYSTEM_IP))
                .subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<JsonObject, String>() {
                    @Override
                    public String call(JsonObject s) {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        DLog.json("Func1", s.toString());
                        return s.toString();
                    }
                })
                .subscribe(new rx.Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        JSONObject jsonObject = null; // load from network, sdcard etc
                        try {
                            InputStream in = getResources().getAssets().open("localView.md");
                            jsonObject = new JSONObject(StringUtil.convertStreamToString(in));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        View sampleView = DynamicView.createView(ListViewActivity.this, jsonObject);
                        DLog.d(sampleView);
                        if (sampleView != null) {
                            sampleView.setLayoutParams(
                                    new WindowManager.LayoutParams(
                                            WindowManager.LayoutParams.MATCH_PARENT,
                                            WindowManager.LayoutParams.MATCH_PARENT));
                            setContentView(sampleView);

                        } else {
                            setContentView(R.layout.activity_listview);
                            id_test_list = findViewById(R.id.id_test_list);
                            ArrayList<String> data = new ArrayList<>();
                            for (int i = 0; i < 6; i++) {
                                data.add(i + "");
                            }
                            adapter = new ListViewAdapter(ListViewActivity.this, data);
                            id_test_list.setAdapter(adapter);
                        }
                    }
                });


    }


}
