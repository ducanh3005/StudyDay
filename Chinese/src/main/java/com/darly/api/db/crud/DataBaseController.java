/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.api.db.crud;

import com.raizlabs.android.dbflow.sql.language.OrderBy;
import com.raizlabs.android.dbflow.sql.language.SQLOperator;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

/**
 * Description TODO:数据库操作类
 * Package com.darly.dlcommon.db.chinese
 *
 * @author zhangyuhui
 * Date 2019/7/31 17:47
 * Company 山东新北洋信息技术股份有限公司西安分公司
 * EMail zhangyuhui@newbeiyang.com
 */
public class DataBaseController {
    private DataBaseController() {
    }

    ///////////////////////////////////////////////////////////////////////////
    // 数据库增操作
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Description：该方法功能为：线程安全，直接使用DBFlow进行保存操作。
     *
     * @param t 传递进来的表对象
     * @return 返回成功失败
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> boolean save(T t) {
        return t.save();
    }


    ///////////////////////////////////////////////////////////////////////////
    // 数据库删操作
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Description：该方法功能为：线程安全，直接使用DBFlow进行删除该数据操作。
     *
     * @param t 传递进来的表对象
     * @return 返回成功失败
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> boolean delete(T t) {
        return t.delete();
    }

    /**
     * Description：该方法功能为：线程安全，根据条件删除表格数据。
     * <demo>
     * DataBaseCommon.deleteByOperater(PayTypeConfigBean.class,PayTypeConfigBean_Table.five_dime.eq(true), PayTypeConfigBean_Table.one_yuan_coin.eq(true));
     * <demo/>
     *
     * @param t 传递进来的表对象
     * @return 返回成功失败
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> void deleteByOperater(Class<T> t, SQLOperator... conditions) {
        SQLite.delete(t).where(conditions).execute();
    }

    /**
     * Description：该方法功能为：线程安全，清空表。
     *
     * @param cls 传递进来的表对象
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> void clear(Class<T> cls) {
        SQLite.delete(cls).execute();
    }


    ///////////////////////////////////////////////////////////////////////////
    // 数据库查询封装模块
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Description：该方法功能为：根据输入的对象参数。获取该表的所有数据。示例：List<PayTypeConfigBean> ben = DataBaseCommon.findAll(PayTypeConfigBean.class);
     *
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> List<T> selectAll(Class<T> t) {
        return SQLite.select().from(t).queryList();
    }


    /**
     * Description：该方法功能为：线程安全，根据提供的类，根据提供的条件，获取适合该条件的数据
     * <demo>
     * OrderBy ob  =  OrderBy.fromProperty(PayTypeConfigBean_Table.auto_id).ascending();//升序
     * DataBaseCommon.selectByConditions(PayTypeConfigBean.class,ob,PayTypeConfigBean_Table.fifty_yuan_note.eq(true));
     * </demo>
     *
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> List<T> selectByConditions(Class<T> t, OrderBy orderBy, SQLOperator... conditions) {
        return SQLite.select().from(t).where(conditions).orderBy(orderBy).queryList();
    }

    /**
     * Description：该方法功能为：线程安全，根据提供的类，进行分页查询
     *
     * @param limit 每页多少条数据
     * @param page  第几页
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> List<T> selectByLimit(Class<T> t, int limit, int page) {
        return SQLite.select().from(t).limit(limit).offset(page * limit).queryList();
    }

    /**
     * Description：该方法功能为：线程安全，根据提供的类，根据提供的条件，获取适合该条件的数据
     * <demo>
     * OrderBy ob  =  OrderBy.fromProperty(PayTypeConfigBean_Table.auto_id).ascending();//升序
     * DataBaseCommon.selectByConditions(PayTypeConfigBean.class,ob,PayTypeConfigBean_Table.fifty_yuan_note.eq(true));
     * </demo>
     *
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> List<T> selectByConditionsList(Class<T> t, List<OrderBy> orderBy, SQLOperator... conditions) {
        if (orderBy != null) {
            return SQLite.select().from(t).where(conditions).orderByAll(orderBy).queryList();
        } else {
            return null;
        }
    }


    /**
     * Description：该方法功能为：线程安全，根据提供的类，查询第一条数据
     *
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> T selectSingle(Class<T> t) {
        return SQLite.select().from(t).querySingle();
    }

    /**
     * Description：该方法功能为：线程安全，根据提供的类，根据提供的条件，获取适合该条件的第一条数据(可以获取升序第一条数据，或者倒序第一条数据)
     * <demo>
     * OrderBy ob  =  OrderBy.fromProperty(PayTypeConfigBean_Table.auto_id).ascending();//升序
     * DataBaseCommon.selectByConditionsSingle(PayTypeConfigBean.class,ob,PayTypeConfigBean_Table.fifty_yuan_note.eq(true));
     * </demo>
     *
     * @author：zhangyuhui Data：2019/6/24 19:27
     */
    public static synchronized <T extends BaseModel> T selectByConditionsSingle(Class<T> t, OrderBy orderBy, SQLOperator... conditions) {
        return SQLite.select().from(t).where(conditions).orderBy(orderBy).querySingle();
    }


    /**
     * 查询数据条数
     *
     * @param t 表
     * @return 查询条数
     */
    public static synchronized <T extends BaseModel> long selectCount(Class<T> t) {
        List model = SQLite.select().from(t).queryList();
        return model != null ? model.size() : 0;
    }


}
