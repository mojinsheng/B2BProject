package com.from.molibrary.task;

import android.content.Context;

import com.from.molibrary.callback.MoCallBcak;
import com.from.molibrary.okhttp.HttpParms;
import com.from.molibrary.okhttp.HttpRequest;

/**
 * Created by Administrator on 2018/2/7.
 */
public class CommandExecute {
    private CommandExecute(){

    }

    public MoCallBcak getMoCallBcak() {
        return moCallBcak;
    }

    public void setMoCallBcak(MoCallBcak moCallBcak) {
        this.moCallBcak = moCallBcak;
    }

    private MoCallBcak moCallBcak;
    public static CommandExecute commandExecute;
    public static CommandExecute getinstance(){
        if(commandExecute==null){
            return commandExecute=new CommandExecute();
        }else {
            return commandExecute;
        }
    }
    /**
     * 执行操作
     * */
    public void asynExecute(Context context, HttpRequest httpRequest, MoCallBcak moCallBcak) {
        setMoCallBcak(moCallBcak);
        RequestExecutor.getInstance().execute(httpRequest,moCallBcak);
    }
}
