/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Description TODO: 消费数据。
 * Package com.darly.qtest.queue
 * @author zhangyuhui
 * Date 2019/7/30 11:48
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class UserRunnable implements Runnable {
    private BlockingQueue<String> queue;

    public UserRunnable(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        boolean isRunning = true;
        try {
            while (isRunning) {
                //有数据时直接从队列的队首取走，无数据时阻塞，在2s内有数据，取走，超过2s还没数据，返回失败
                String data = queue.poll(2, TimeUnit.SECONDS);
                if (null != data) {
                    System.out.println("正在消费数据：" + data);
                } else {
                    // 超过2s还没数据，认为所有生产线程都已经退出，自动退出消费线程。
                    isRunning = false;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        } finally {
            System.out.println("退出消费者线程！");
        }
    }
}
