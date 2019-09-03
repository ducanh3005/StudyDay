/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.parse;

import android.text.TextUtils;

import com.darly.chinese.db.chinese.table.SongCiAuthorBean;
import com.darly.chinese.db.chinese.table.SongCiBean;
import com.darly.chinese.db.crud.DataBaseController;
import com.darly.dlcommon.common.JsonConverter;
import com.darly.dlcommon.common.VersionController;
import com.darly.dlcommon.common.bolts.tasks.Task;
import com.darly.dlcommon.common.bolts.tasks.iface.Continuation;
import com.darly.dlcommon.common.dlog.DLog;
import com.darly.dlcommon.db.version.table.VersionBean;
import com.darly.dlcommon.framework.ContextController;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.Callable;

/**
 * Description TODO:获取文件内部JSON数据并解析为对象形式。
 * Package com.darly.dlcommon.parse
 * @author zhangyuhui
 * Date 2019/7/31 16:42
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class ParseJsonController {

    /**
     * Assets里面的目标文件名称
     */
    private String fileName = "chinese";

    private List<String> jsonFile = new ArrayList<>();

    private ParseJsonController() {
    }

    static class ParseJsonControllerHolder {
        static ParseJsonController controller = new ParseJsonController();
    }

    public static ParseJsonController getInstance() {
        return ParseJsonControllerHolder.controller;
    }


    /**
     * 加载界面。Loading数据
     *
     * @param listener 回调
     */
    public void initParseJson(OnParseJsonListener listener) {
        //首先进行数据库数据查询。数据库中已经存在数据。则不在进行数据更新。否则将文件导入数据库中。
        //同时这里需要进行版本更新操作，当APK是最新版本，需要重新导入
        VersionBean versionBean = DataBaseController.selectSingle(VersionBean.class);
        if (versionBean == null) {
            //新安裝需要同步数据
            versionBean = new VersionBean();
            versionBean.setAutoId(UUID.randomUUID());
            versionBean.setPackagename(VersionController.packageName());
            versionBean.setVersioncode(VersionController.versionCode());
            versionBean.setVersionname(VersionController.versionName());
            DataBaseController.save(versionBean);
            insertChineseMessage(listener, "");
        } else {
            if (VersionController.versionCode() != versionBean.getVersioncode()) {
                //版本信息不一致。
                //清空作者表
                DataBaseController.clear(SongCiAuthorBean.class);
                //清空词表
                DataBaseController.clear(SongCiBean.class);
                insertChineseMessage(listener, "");
            } else {
                //版本信息一致
                //当数据库中的信息都非零时，不需重新加载数据
                long authorCount = DataBaseController.selectCount(SongCiAuthorBean.class);
                long ciCount = DataBaseController.selectCount(SongCiBean.class);
                if (authorCount > 0 && ciCount > 0) {
                    //无需重新加载
                    listener.onProgress(100);

                    listener.onComplete();
                    DLog.d("数据库信息一致，无需修改");
                } else {
                    insertChineseMessage(listener, "");
                }
            }
        }


    }

    /**
     * 读取数据到数据库
     */
    private void insertChineseMessage(OnParseJsonListener listener, String name) {
        jsonFile.clear();
        insertList(name);
        insertChinese(listener);
    }

    /**
     * 将JSON文件名称读入到集合中。
     */
    private void insertList(String name) {
        try {
            String[] file = ContextController.getInstance().getApplication().getAssets().list(name);
            if (file != null && file.length > 0) {
                for (String path : file) {
                    if ("chinese-poetry-master".equals(path)) {
                        continue;
                    }
                    if (path.contains(".")) {
                        //文件
                        if (path.endsWith(".json")) {
                            if (TextUtils.isEmpty(name)) {
                                jsonFile.add(path);
                            } else {
                                jsonFile.add(name + "/" + path);
                            }

                        } else {
                            DLog.d("不需要的文件：" + path);
                        }
                    } else {
                        //文件夹
                        if (TextUtils.isEmpty(name)) {
                            insertList(path);
                        } else {
                            insertList(name + "/" + path);
                        }
                    }
                }
            } else {
                DLog.d("没有找到文件");
            }
        } catch (IOException e) {
            e.printStackTrace();
            DLog.d("insertChineseMessage", "Assets文件夹无法读取数据");
        }
    }

    /**
     * 按照名称插入数据库
     *
     * @param listener
     */
    private void insertChinese(final OnParseJsonListener listener) {
        Task.call(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                if (jsonFile != null) {
                    for (int i = 0; i < jsonFile.size(); i++) {
                        DLog.d("开始读取文件" + jsonFile.get(i));
                        String json = convertStreamToString(ContextController.getInstance().getApplication().getAssets().open(jsonFile.get(i)));
                        if (jsonFile.get(i).contains(SongCiBean.NAME)) {
                            SongCiBean[] ciBeans = JsonConverter.fromJsonString(json, SongCiBean[].class);
                            if (ciBeans != null) {
                                int lenth= ciBeans.length;
                                //解析成功，获取词的对象
                                for (int x = 0;x< lenth;x++) {
                                    SongCiBean ci = ciBeans[x];
                                    ci.setAutoId(UUID.randomUUID());
                                    DataBaseController.save(ci);
                                    listener.onSecProgress(x*100/lenth);
                                }
                            }
                        } else if (jsonFile.get(i).contains(SongCiAuthorBean.NAME)) {
                            SongCiAuthorBean[] ciAuthorBeans = JsonConverter.fromJsonString(json, SongCiAuthorBean[].class);
                            if (ciAuthorBeans != null) {
                                //解析成功，获取词作者的对象
                                int lenth= ciAuthorBeans.length;
                                //解析成功，获取词的对象
                                for (int j = 0;j< lenth;j++) {
                                    SongCiAuthorBean ci =ciAuthorBeans[j];
                                    ci.setAutoId(UUID.randomUUID());
                                    DataBaseController.save(ci);
                                    listener.onSecProgress(j*100/lenth);
                                }
                            }
                        }
                        listener.onProgress((i + 1) * 100 / jsonFile.size());
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }, Task.BACKGROUND_EXECUTOR).continueWith(new Continuation<Boolean, Void>() {
            @Override
            public Void then(Task<Boolean> task) throws Exception {
                if (task.getResult()) {
                    listener.onComplete();
                    DLog.d("数据重新初始化完成");
                } else {
                    listener.onFailed(task.getError().getMessage());
                    DLog.d("数据重新初始化失败"+task.getError().getMessage());
                }
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);

    }


    /**
     * input 流转换为字符串
     *
     * @param is
     * @return
     */
    private static String convertStreamToString(InputStream is) {
        String s = null;
        try {
            //格式转换
            Scanner scanner = new Scanner(is, "UTF-8").useDelimiter("\\A");
            if (scanner.hasNext()) {
                s = scanner.next();
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

}
