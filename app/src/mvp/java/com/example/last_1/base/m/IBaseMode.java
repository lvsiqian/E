package com.example.last_1.base.m;


import com.example.last_1.base.v.IBackCallback;
import com.example.last_1.data.net.request.MvpRequest;

import io.reactivex.rxjava3.functions.Consumer;


public interface IBaseMode {

    <T> void doRequest(MvpRequest<T> request, Consumer empty, IBackCallback<T> callBack);
}
