/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.db.crud;

import android.util.Log;

import com.darly.chinese.db.chinese.bean.SongCiAuthorModel;
import com.darly.chinese.db.chinese.bean.SongCiModel;
import com.darly.chinese.db.chinese.table.SongCiAuthorBean;
import com.darly.chinese.db.chinese.table.SongCiAuthorBean_Table;
import com.darly.chinese.db.chinese.table.SongCiBean;
import com.darly.dlcommon.common.dlog.DLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Description TODO: 所有数据库对象转对象工具类
 * Package com.darly.chinese.db.crud
 *
 * @author zhangyuhui
 * @date 2019/8/19 17:54
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class DataReposController {

    private DataReposController() {
    }

    /**
     * 获取宋词作者对象类
     *
     * @return 数据
     */
    public static List<SongCiAuthorModel> findSongCiAuthors() {
        List<SongCiAuthorBean> songCiAuthorBeans = DataBaseController.selectAll(SongCiAuthorBean.class);
        List<SongCiAuthorModel> models = new ArrayList<>();
        if (songCiAuthorBeans != null && songCiAuthorBeans.size() > 0) {
            for (SongCiAuthorBean bean : songCiAuthorBeans) {
                models.add(new SongCiAuthorModel(bean.getAutoId(), bean.getName(), bean.getDescription(), bean.getShort_description()));
            }
        }
        DLog.d("findSongCiAuthors 获取对象长度" + models.size());
        return models;
    }

    /**
     * 获取宋词作者对象类
     *
     * @return 数据
     */
    public static List<SongCiAuthorModel> findSongCiAuthors(int limit, int page) {
        List<SongCiAuthorBean> songCiAuthorBeans = DataBaseController.selectByLimit(SongCiAuthorBean.class, limit, page);
        List<SongCiAuthorModel> models = new ArrayList<>();
        if (songCiAuthorBeans != null && songCiAuthorBeans.size() > 0) {
            for (SongCiAuthorBean bean : songCiAuthorBeans) {
                models.add(new SongCiAuthorModel(bean.getAutoId(), bean.getName(), bean.getDescription(), bean.getShort_description()));
            }
        }
        DLog.d("findSongCiAuthors 获取对象长度" + models.size());
        return models;
    }

    /**
     * 获取宋词对象类
     *
     * @return 数据
     */
    public static List<SongCiModel> findSongCis() {
        List<SongCiBean> songCiBeans = DataBaseController.selectAll(SongCiBean.class);
        List<SongCiModel> models = new ArrayList<>();
        if (songCiBeans != null && songCiBeans.size() > 0) {
            for (SongCiBean bean : songCiBeans) {
                models.add(new SongCiModel(bean.getAutoId(), bean.getAuthor(), bean.getParagraphs(), bean.getRhythmic()));
            }
        }
        DLog.d("findSongCis 获取对象长度" + models.size());
        return models;
    }

    /**
     * 获取宋词对象类
     *
     * @return 数据
     */
    public static List<SongCiModel> findSongCis(int limit, int page) {
        List<SongCiBean> songCiBeans = DataBaseController.selectByLimit(SongCiBean.class, limit, page);
        List<SongCiModel> models = new ArrayList<>();
        if (songCiBeans != null && songCiBeans.size() > 0) {
            for (SongCiBean bean : songCiBeans) {
                models.add(new SongCiModel(bean.getAutoId(), bean.getAuthor(), bean.getParagraphs(), bean.getRhythmic()));
            }
        }
        DLog.d("findSongCis 获取对象长度" + models.size());
        return models;
    }


    public static void test() {
        Log.d("DataReposController", "测试开始执行");
        List<SongCiAuthorBean> beans = DataBaseController.selectAll(SongCiAuthorBean.class);
        Log.d("DataReposController", "测试缓存数据" + beans.size());

        Log.d("DataReposController", "数据库开始查询");
        List<SongCiAuthorBean> aut = DataBaseController.selectByConditions(SongCiAuthorBean.class, null, SongCiAuthorBean_Table.name.like("李%"));
        Log.d("DataReposController", "数据库完成查询" + aut.size());

        List<SongCiAuthorBean> keys = new ArrayList<>();
        Log.d("DataReposController", "内存开始查询");
        for (SongCiAuthorBean bean : beans) {
            if (bean.getName() != null && bean.getName().contains("李")) {
                keys.add(bean);
            }
        }
        Log.d("DataReposController", "内存完成查询" + keys.size());
    }

}
