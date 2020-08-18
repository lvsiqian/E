package com.example.last_1.data.net.request;

public class PostRequest  extends  MvpRequest {
    public PostRequest(String url) {
        super(url);
    }

    public PostRequest() {
    }

    public  RequestMethod getRequestMethod(){
        return  RequestMethod.POST;
    }
}
