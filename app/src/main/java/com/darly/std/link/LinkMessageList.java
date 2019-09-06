/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.link;
import android.util.Log;

/**
 * 问题：如何实现一个高效的单向链表逆序输出？
 * 出题人：阿里巴巴出题专家：昀龙／阿里云弹性人工智能负责人
 * Description TODO:创建一个链表
 * Package com.darly.std.link
 * @author zhangyuhui
 * Date 2019/7/24 16:05
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class LinkMessageList {

    private LinkMessageList() {
    }

    public static NextMessage head;

    /**
     * 根据传递的长度，生成链表
     *
     * @param x 内容长度
     */
    public static void creatLinkList(int[] x) {
        NextMessage prewNew;
        NextMessage node = new NextMessage();
        head = node;
        for (int i = 0; i < x.length; i++) {
            prewNew = new NextMessage();
            prewNew.setMsgRes(x[i]);
            node.setNextMessage(prewNew);
            node = prewNew;
        }
    }


    /**
     * 正序输出链表内容
     */
    public static void displayLinkList() {
        NextMessage node = head.getNextMessage();
        while (node != null) {
            Log.d("displayLinkList", "node.getMsg()----->" + node.getMsgRes());
            node = node.getNextMessage();
        }
        Log.d("displayLinkList","null");
    }

}
