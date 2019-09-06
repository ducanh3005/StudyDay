package com.darly.chinese.sp;

import com.darly.dlcommon.framework.ContextController;

public class SPController {
    public static final String SPNAME = "study_01";
    public static final String FRIST_OPEN = "frist_open";


    private SPController() {
    }

    public static void put(String key, Object value) {
        if (value instanceof Integer) {
            ContextController.getInstance().getSharePrefrenceController().putValue(key, (int) value);
        } else if (value instanceof Boolean) {
            ContextController.getInstance().getSharePrefrenceController().putValue(key, (boolean) value);
        } else {
            ContextController.getInstance().getSharePrefrenceController().putValue(key, value);
        }
    }

    public static <T> T get(String key) {
        return (T) ContextController.getInstance().getSharePrefrenceController().getValue(key);
    }

    public static int get(String key, int def) {
        return ContextController.getInstance().getSharePrefrenceController().getValue(key, def);
    }

    public static boolean get(String key, boolean def) {
        return ContextController.getInstance().getSharePrefrenceController().getValue(key, def);
    }
}
