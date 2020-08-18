package com.example.last_1.data.net.request;

public class GetRequest extends MvpRequest{
    public GetRequest() {
    }

    public GetRequest(String url) {
        super(url);
    }
    public  RequestMethod getRequestMethod(){
        return  RequestMethod.GET;
    }
}
