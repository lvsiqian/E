package com.example.last_1.base.v;

import com.example.last_1.data.net.response.MvpResponse;

import io.reactivex.rxjava3.disposables.Disposable;


public interface IBackCallback<T> {
    void onResult(MvpResponse<T> response);
    default  void onStart(Disposable disposable){

    }
//    void onSuccess(T data);
//    void  OnFaiL(String msg);
}
