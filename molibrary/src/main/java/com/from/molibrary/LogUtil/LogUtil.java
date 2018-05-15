package com.from.molibrary.logUtil;

import android.util.Log;

/**
 * Created by Administrator on 2018/2/9.
 */
public class LogUtil {
    private LogUtil(){

    }
    private static final String TAG = "MoLog";
    public boolean isFlag=false;
    public static LogUtil logUtil;
    public static LogUtil getInstance(){
        if(logUtil==null){
            return  logUtil=new LogUtil();
        }else {
            return logUtil;
        }
    }
    public void logI(String message){
       if(isFlag){
           Log.i(TAG,message);
       }
    }
    public void logI(String tag, String message){
        if(isFlag){
            Log.i(tag,message);
        }
    }

    public void logE(String message){
        if(isFlag){
            Log.e(TAG,message);
        }
    }
    public void loge(String tag, String message){
        if(isFlag){
            Log.e(tag,message);
        }
    }
}
