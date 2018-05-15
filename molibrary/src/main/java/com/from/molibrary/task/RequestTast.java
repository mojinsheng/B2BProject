package com.from.molibrary.task;

import android.os.AsyncTask;

import com.from.molibrary.callback.MoCallBcak;
import com.from.molibrary.logUtil.LogUtil;
import com.from.molibrary.okhttp.HttpRequest;

/**
 * Created by Administrator on 2018/2/7.
 */
public class RequestTast extends AsyncTask<Void, Integer, Void> {
    private HttpRequest httpRequest;
    private MoCallBcak moCallBcak;
    public RequestTast(HttpRequest _httpRequest,MoCallBcak _moCallBcak){
        this.httpRequest=_httpRequest;
        this.moCallBcak=_moCallBcak;
    }




    /**
     * onPreExecute是可以选择性覆写的方法
     * 在主线程中执行,在异步任务执行之前,该方法将会被调用
     * 一般用来在执行后台任务前对UI做一些标记和准备工作，
     * 如在界面上显示一个进度条。
     */
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }

    /**
     * 抽象方法必须覆写,执行异步任务的方法
     * @param params
     * @return
     */
    @Override
    protected Void doInBackground(Void... params) {
        MoCommand.getInatance().execute();
        return null;
    }

    /**
     * onProgressUpdate是可以选择性覆写的方法
     * 在主线程中执行,当后台任务的执行进度发生改变时,
     * 当然我们必须在doInBackground方法中调用publishProgress()
     * 来设置进度变化的值
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
    /**
     * onPostExecute是可以选择性覆写的方法
     * 在主线程中执行,在异步任务执行完成后,此方法会被调用
     * 一般用于更新UI或其他必须在主线程执行的操作,传递参数bitmap为
     * doInBackground方法中的返回值
     *
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        LogUtil.getInstance().logI("异步线程执行完成");
    }
    /**
     * onCancelled是可以选择性覆写的方法
     * 在主线程中,当异步任务被取消时,该方法将被调用,
     * 要注意的是这个时onPostExecute将不会被执行
     */
    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
