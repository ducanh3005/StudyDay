/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.chinese.db.chinese.database;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Description TODO:数据库
 * Package com.darly.dlcommon.db.chinese.database
 *
 * @author zhangyuhui
 * Date 2019/7/31 17:28
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
@Database(name = ChineseDataBase.NAME, version = ChineseDataBase.VERSION)
public class ChineseDataBase {
    public static final int VERSION = 1;
    public static final String NAME = "ChineseDB";
}
