/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */
package com.darly.std.link;

/**
 * 问题：如何实现一个高效的单向链表逆序输出？
 * 出题人：阿里巴巴出题专家：昀龙／阿里云弹性人工智能负责人
 * Description TODO: 链表内部对象
 * Package com.darly.std.link
 *
 * @author zhangyuhui
 * Date 2019/7/24 16:03
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class NextMessage {

    private int msgRes;

    private NextMessage nextMessage;


    public int getMsgRes() {
        return msgRes;
    }

    public void setMsgRes(int msgRes) {
        this.msgRes = msgRes;
    }

    public NextMessage getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(NextMessage nextMessage) {
        this.nextMessage = nextMessage;
    }
}
