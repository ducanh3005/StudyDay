package com.darly.chinese;

import android.os.Handler;
import android.os.Message;

import com.darly.chinese.db.chinese.table.TestBean;
import com.darly.chinese.db.crud.DataBaseController;
import com.darly.dlcommon.common.dlog.DLog;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

/**
 * Description TODO:
 * Package com.darly.chinese
 *
 * @author zhangyuhui
 * @date 2019/10/8 17:27
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class DbTestController {



    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            List<TestBean> beans = DataBaseController.selectAll(TestBean.class);
            for (TestBean bean:beans) {
                bean.setAuthor(10);
                DataBaseController.update(bean);
            }
        }
    };

    public void init(){
        DataBaseController.clear(TestBean.class);
        for(int i =0;i<10;i++){
            TestBean bean = new TestBean();
            bean.setAutoId(UUID.randomUUID());
            bean.setAuthor(i);
            DataBaseController.save(bean);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    handler.sendEmptyMessage(0);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    List<TestBean> beans = DataBaseController.selectAll(TestBean.class);
                    for (TestBean bean:beans) {
                        if (bean.getAuthor()!=10) {
                            DLog.d(bean.getAuthor());
                        }
                    }
                }
            }
        }).start();
    }


}
