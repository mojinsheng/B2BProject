package com.from.molibrary.okhttp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Administrator on 2018/2/7.
 */
public class HttpParms {
    private HttpParms(){

    }
    public static HttpParms httpParms;
    public static Map<String,String> httpValueMap=new HashMap<>();
    public static HttpParms getInatance(){
        if(httpParms==null){
           return httpParms=new HttpParms();
        }else {
            return httpParms;
        }
    }
    public void putValues(String key,String values){
        httpValueMap.put(key,values);
    }
    public void getValues(String key){
        httpValueMap.get(key);
    }
    public Map<String,String> getMapParam(){
         return httpValueMap;
    }
}
