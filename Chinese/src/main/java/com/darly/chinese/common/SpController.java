package com.darly.chinese.common;

import com.darly.dlcommon.framework.ContextController;

/**
 * author:zhangyuhui
 * date:2020-01-0910:31
 * description:SP工具类
 */
public class SpController {

    private SpController() {
    }

    static class SpControllerHolder {
        static SpController controller = new SpController();
    }

    public static SpController getInstance() {
        return SpControllerHolder.controller;
    }


    public void setName(String spName) {
        ContextController.getInstance().getSharePerferenceController().setSpName(spName);
    }

    public void putValue(String key, int position) {
        ContextController.getInstance().getSharePerferenceController().putValue(key, position);
    }

    public int getValue(String key, int df) {
        return ContextController.getInstance().getSharePerferenceController().getValue(key, df);
    }

    public void putValue(String key, Boolean obj) {
        ContextController.getInstance().getSharePerferenceController().putValue(key, obj);
    }

    public boolean getBoolean(String key) {
        return ContextController.getInstance().getSharePerferenceController().getBoolean(key);
    }

    /**
     * desc:保存对象
     *
     * @param key
     * @param obj 要保存的对象，只能保存实现了serializable的对象
     *            modified:
     */
    public void putValue(String key, Object obj) {
        ContextController.getInstance().getSharePerferenceController().putValue(key, obj);
    }


    /**
     * desc:获取保存的Object对象
     *
     * @param key
     * @return modified:
     */
    public Object getValue(String key) {
        return ContextController.getInstance().getSharePerferenceController().getValue(key);
    }


    /**
     * @param key 下午3:19:50
     * @author zhangyh2 SharePreferInfo.java TODO移除某项
     */
    public void remove(String key) {
        ContextController.getInstance().getSharePerferenceController().remove(key);
    }


}
