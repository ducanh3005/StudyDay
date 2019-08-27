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
public class LinkList {
    public NextNode head;

    /**
     * 根据传递的长度，生成链表
     *
     * @param x 内容长度
     */
    public void creatLinkList(int[] x) {
        NextNode prewNew;
        NextNode node = new NextNode();
        head = node;
        for (int i = 0; i < x.length; i++) {
            prewNew = new NextNode();
            prewNew.setMsg(String.valueOf(x[i]));
            node.setPoint(prewNew);
            node = prewNew;
        }
    }


    /**
     * 正序输出链表内容
     */
    public void displayLinkList() {
        NextNode node = head.getPoint();
        while (node != null) {
            Log.d("displayLinkList", "node.getMsg()----->" + node.getMsg());
            node = node.getPoint();
        }
        Log.d("displayLinkList","null");
    }

    /**
     * 逆序输出链表内容
     */
    public void reverseLinkList(){
        if (head == null||head.getPoint() == null){
            Log.d("reverseLinkList","链表只有一个头节点或者只有一个节点");
            return;
        }else {
            NextNode prewNode = head.getPoint();
            NextNode nextNode = head.getPoint().getPoint();
            //将第一个结点的next置为空，否则会出现一个环
            prewNode.setPoint(null);
            NextNode temp = null;
            while (nextNode!=null){
                temp = nextNode.getPoint();
                nextNode.setPoint(prewNode);
                prewNode = nextNode;
                nextNode = temp;
            }
            if (nextNode == null){
                head.setPoint(prewNode);
                nextNode = null;
            }
        }
    }


}
