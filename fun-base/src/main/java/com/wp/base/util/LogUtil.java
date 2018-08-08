package com.wp.base.util;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.wp.base.Constants;

public class LogUtil {
    static {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    public static void d(Object... args){
        if(Constants.DEBUG){
            Logger.d(Constants.LOG_TAG,args);
        }

    }

    public static void d(String tag, Object... args){
        if(Constants.DEBUG){
            Logger.d(tag,args);
        }

    }
}
