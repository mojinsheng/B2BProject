package com.from.molibrary.okhttp;

/**
 * Created by Administrator on 2018/2/7.
 */
public class HttpRequest {
//    private HttpRequest(){
//
//    }
    public static HttpRequest httpRequest;
    public static HttpRequest getInstance(){
        if(httpRequest==null){
            return httpRequest=new HttpRequest();
        }else{
            return httpRequest;
        }
    }
    private String url="http://sdk.promoadx.com/api/appauth/check?";
    public static String httpMethod=HttpReuqestMethod.GET;
    HttpParms httpParms=HttpParms.getInatance();
    public void putValues(String key,String values){
        httpParms.putValues(key,values);
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
