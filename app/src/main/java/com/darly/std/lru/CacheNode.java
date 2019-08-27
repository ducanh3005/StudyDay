/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.std.lru;

/**
 * Description TODO:缓存对象类，使用链表形式
 * Package com.darly.qtest.lru
 * @author zhangyuhui
 * Date 2019/7/25 15:28
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class CacheNode {
    /**
     * 前面的缓存
     */
    private CacheNode pre;
    /**
     * 缓存键
     */
    private Object key;
    /**
     * 缓存值
     */
    private Object value;
    /**
     * 后面的缓存
     */
    private CacheNode bak;

    public CacheNode() {
    }

    public CacheNode getPre() {
        return pre;
    }

    public void setPre(CacheNode pre) {
        this.pre = pre;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public CacheNode getBak() {
        return bak;
    }

    public void setBak(CacheNode bak) {
        this.bak = bak;
    }
}
