package com.from.molibrary.task;

import android.util.Log;

import com.from.molibrary.logUtil.LogUtil;
import com.from.molibrary.okhttp.HttpParms;
import com.from.molibrary.okhttp.HttpRequest;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/2/8.
 */
public class MoCommand {
    HttpRequest httpRequest=HttpRequest.getInstance();
    private static String HTTPGET="GET";
    private static String HTTPPOST="POST";
    public static MoCommand moCommand;
    public static MoCommand getInatance(){
        if(moCommand==null){
           return moCommand=new MoCommand();
        }else {
            return moCommand;
        }
    }
    private  MoCommand(){

    }
    public void execute(){
        if(HttpRequest.httpMethod.equals(HTTPGET)){
            okHttp3Get();
        }else {
            okHttp3Post();
        }
    }

    /**
     * post请求
     */
    private void okHttp3Post(){
        String url=httpRequest.getUrl();
        LogUtil.getInstance().logI("mo"+url);
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        /**
         * post添加请求参数
         */
        RequestBody formBody = new FormBody.Builder()
                .add("size", "10")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                 String str = response.networkResponse().toString();
                LogUtil.getInstance().logI("str"+str);


            }

        });
    }
    /**
     * get请求
     */
    private void okHttp3Get(){

        String params=getRequestData(HttpParms.getInatance().getMapParam(),null).toString();
        String url=httpRequest.getUrl()+params;
        LogUtil.getInstance().logI(url);
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(url)
                .get().build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("Fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String str = response.body().string();
                LogUtil.getInstance().logI("str:"+str);
                CommandExecute.getinstance().getMoCallBcak().success();
            }
        });
    }
    public static StringBuffer getRequestData(Map<String, String> params, String encode) {
        StringBuffer stringBuffer = new StringBuffer();        //存储封装好的请求体信息
        try {
            for(Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue())
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);    //删除最后的一个"&"
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

}
