/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.qtest.queue;

import android.util.Log;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description TODO: 线程生产者，在这里进行数据产出。
 * Package com.darly.qtest.queue
 * @author zhangyuhui
 * Date 2019/7/30 11:38
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ProducterRunnable implements Runnable {

    private volatile boolean isRunning = true;
    private BlockingQueue queue;
    private static AtomicInteger counter = new AtomicInteger();

    public ProducterRunnable(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String data = null;
        Log.d("ProducterRunnable", "run() called");
        try {
            while (isRunning) {
                //以原子方式将count当前值加1
                data = "data:" + counter.incrementAndGet();
                Thread.sleep(1000);
                Log.d("ProducterRunnable", "将数据：" + data + "放入队列...");
                //设定的等待时间为2s，如果超过2s还没加进去返回true
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {
                    Log.d("ProducterRunnable", "放入数据失败：" + data);
                }
                if (counter.incrementAndGet()>10){
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            Log.d("ProducterRunnable", "线程停止");
        }
    }


    public void stop() {
        isRunning = false;
    }
}
