package com.from.molibrary.task;

import com.from.molibrary.callback.MoCallBcak;
import com.from.molibrary.okhttp.HttpRequest;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/2/7.
 */
public class RequestExecutor {
    public static RequestExecutor requestExecutor;
    private RequestExecutor(){

    }
    public static RequestExecutor getInstance(){
        if(requestExecutor==null){
            return requestExecutor=new RequestExecutor();
        }else {
            return requestExecutor;
        }
    }
    private ExecutorService executorService= Executors.newSingleThreadExecutor();
    public void execute(HttpRequest httpRequest, MoCallBcak moCallBcak){
        new RequestTast(httpRequest,moCallBcak).execute();
        //executorService.execute(new RequestTast(httpRequest,moCallBcak).execute(""));
    }
}
