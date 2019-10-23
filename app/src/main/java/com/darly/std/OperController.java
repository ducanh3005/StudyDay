/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std;

import android.annotation.TargetApi;
import android.util.Log;

import com.darly.std.link.LinkList;
import com.darly.std.lru.LruCache;
import com.darly.std.queue.ProducterRunnable;
import com.darly.std.queue.UserRunnable;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description TODO: 工具实现类。所有的动作在这里执行
 * Package com.darly.std
 *
 * @author zhangyuhui
 * @date 2019/8/21 15:32
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class OperController {
    private OperController() {
    }

    public static void init(){
        link();
        initQueue();
        threader();
    }

    private static void link(){
        LinkList linkList = new LinkList();
        int[] x = new int[new Random().nextInt(20)];
        for (int i = 0; i < x.length; i++) {
            x[i] = i;
        }
        linkList.creatLinkList(x);
        linkList.displayLinkList();
        linkList.reverseLinkList();
        linkList.displayLinkList();
    }


    private static void initQueue() {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>(10);
        ProducterRunnable producterRunnable = new ProducterRunnable(queue);
        ProducterRunnable producterRunnable1 = new ProducterRunnable(queue);
        ProducterRunnable producterRunnable2 = new ProducterRunnable(queue);

        UserRunnable userRunnable = new UserRunnable(queue);

        ExecutorService service = new ScheduledThreadPoolExecutor(4);
        service.execute(producterRunnable);
        service.execute(producterRunnable1);
        service.execute(producterRunnable2);
        service.execute(userRunnable);
    }

    private static void threader() {
       final LruCache lruCache = new LruCache(5);
        final String[] value = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};

        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                String kk = value[new Random().nextInt(value.length)];
                lruCache.put(kk, kk);
                for (String key : value) {
                    Log.d(getClass().getSimpleName(), "run() called" + lruCache.get(key));
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

}
