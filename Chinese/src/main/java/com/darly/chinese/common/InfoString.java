package com.darly.chinese.common;

import android.content.Context;

import com.darly.dlcommon.framework.ContextController;

/**
 * author:zhangyuhui
 * date:2020-03-0911:28
 * description: 从本地获取资源文件，转换成字符串
 */
public class InfoString {

    public static String getString(int id) {
        Context context = ContextController.getInstance().getApplication();
        //通过id获取资源name
        String resourceName = context.getResources().getString(id);
        //下面是RN过来的资源，判断是否需要进行替换。
//        String src = LocaleController.getString(resourceName, id, "");
//        if (!canReplace(src)) {
//            return src;
//        }
//        HashMap<String, String> customerStrings = mCustomerStrings;
//        Iterator<Map.Entry<String, String>> iterator = customerStrings.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, String> entry = iterator.next();
//            String key = "{" + entry.getKey() + "}";
//            src = src.replace(key, entry.getValue());
//        }
        return resourceName;
    }
}
