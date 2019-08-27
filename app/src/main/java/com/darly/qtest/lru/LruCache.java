/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.qtest.lru;

import java.util.HashMap;

/**
 * 题目：LRU 缓存机制 设计和实现一个 LRU（最近最少使用）缓存数据结构，使它应该支持一下操作：get 和 put。 get(key) - 如果 key 存在于缓存中，则获取 key 的 value（总是正数），否则返回 -1。 put(key,value) - 如果 key 不存在，请设置或插入 value。当缓存达到其容量时，它应该在插入新项目之前使最近最少使用的项目作废。
 * 出题人：文景／阿里云 CDN 资深技术专家
 * Description TODO:缓存机制的设计和实现
 * Package com.darly.qtest.lru
 * @author zhangyuhui
 * Date 2019/7/25 15:26
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class LruCache<K, V> {
    /**
     * 缓存池
     */
    private HashMap<K, CacheNode> cache;
    /**
     * 最大缓存
     */
    private int max;
    /**
     * 当前值
     */
    private int current;
    /**
     * 头节点/头节点不参与淘汰。作为第一个节点
     */
    private CacheNode head;
    /**
     * 尾节点/尾节点不参与淘汰。作为最后一个节点
     */
    private CacheNode end;

    public LruCache(int max) {
        this.max = max;
        cache = new HashMap<>(max);
        head = end = new CacheNode();
        //对head 的after节点赋值, 防止后续操作出现空指针异常
        head.setBak(end);
        // 对tail的before节点赋值, 防止后续操作出现空指针异常
        end.setPre(head);
    }

    public void put(K key, V value) {
        CacheNode node = cache.get(key);
        if (node == null) {
            if (current >= max) {
                cache.remove(end.getKey());
                //移除最后一个
                removeLast();
            }
            node = new CacheNode();
            node.setKey(key);
            current++;
        }
        node.setValue(value);
        //移动到第一位
        moveToFirst(node);
        cache.put(key, node);
    }

    public void moveToFirst(CacheNode cacheNode) {
        CacheNode node = cacheNode.getBak();
        head.setBak(node);
        cacheNode.setPre(head);
        node.setPre(cacheNode);
        cacheNode.setBak(node);
    }

    public void removeLast() {
        CacheNode node = end.getPre().getPre();
        node.setBak(end);
        end.setPre(node);
    }

    public Object get(K key) {
        CacheNode node = cache.get(key);
        if (node == null) {
            return null;
        }
        Object v = node.getValue();
        moveToFirst(node);
        return v;
    }

    public Object remove(K key) {
        CacheNode node = cache.get(key);
        if (node == null) {
            return null;
        }
        CacheNode pre = node.getPre();
        CacheNode next = node.getBak();
        pre.setBak(next);
        next.setPre(pre);

        cache.remove(key);

        current--;
        return node.getValue();
    }
}
