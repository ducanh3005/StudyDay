package com.darly.chinese.common;

import com.darly.dlcommon.common.dlog.DLog;

/**
 * author:zhangyuhui
 * date:2020-01-0910:37
 * description: 日志工具
 */
public class LogController {

    private LogController() {
    }

    static class LogControllerHolder {
        static LogController controller = new LogController();
    }

    public static LogController getInstance() {
        return LogControllerHolder.controller;
    }


    public static void v() {
        DLog.v();
    }

    public static void v(Object msg) {
        DLog.v(msg);
    }

    public static void v(String tag, Object... objects) {
        DLog.v(tag, objects);
    }

    public static void d() {
        DLog.d();
    }

    public static void d(Object msg) {
        DLog.d(msg);
    }

    public static void d(String tag, Object... objects) {
        DLog.d(tag, objects);
    }

    public static void i() {
        DLog.i();
    }

    public static void i(Object msg) {
        DLog.i(msg);
    }

    public static void i(String tag, Object... objects) {
        DLog.i(tag, objects);
    }

    public static void w() {
        DLog.w();
    }

    public static void w(Object msg) {
        DLog.w(msg);
    }

    public static void w(String tag, Object... objects) {
        DLog.w(tag, objects);
    }

    public static void e() {
        DLog.e();
    }

    public static void e(Object msg) {
        DLog.e(msg);
    }

    public static void e(String tag, Object... objects) {
        DLog.e(tag, objects);
    }

    public static void a() {
        DLog.a();
    }

    public static void a(Object msg) {
        DLog.a(msg);
    }

    public static void a(String tag, Object... objects) {
        DLog.a(tag, objects);
    }

    public static void json(String jsonFormat) {
        DLog.json(jsonFormat);
    }

    public static void json(String tag, String jsonFormat) {
        DLog.json(tag, jsonFormat);
    }

    public static void xml(String xml) {
        DLog.xml(xml);
    }

    public static void xml(String tag, String xml) {
        DLog.xml(tag, xml);
    }


    public static void debug() {
        DLog.debug();
    }

    public static void debug(Object msg) {
        DLog.debug(msg);
    }

    public static void debug(String tag, Object... objects) {
        DLog.debug(tag, objects);
    }

}
