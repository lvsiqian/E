package com.example.last_1.data.repository;



import com.example.last_1.base.m.IBaseMode;
import com.example.last_1.base.v.IBackCallback;
import com.example.last_1.data.entity.HttpResult;
import com.example.last_1.data.entity.User;
import com.example.last_1.data.net.ok.DatasService;
import com.example.last_1.data.net.request.MvpRequest;
import com.example.last_1.data.net.response.MvpResponse;
import com.example.last_1.utils.ParameterizedTypeImpl;
import com.google.gson.Gson;

import java.lang.reflect.Type;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public  class BaseRepository implements IBaseMode {

    @SuppressWarnings("ALL")
    public Consumer empty = o -> { };
    @SuppressWarnings("ALL")

       public <T> void doRequest(MvpRequest<T> request, IBackCallback<T> callBack) {
        doRequest(request,empty,callBack);
    }

    public <T> void doRequest(MvpRequest<T> request, Consumer doBackground, IBackCallback<T> callBack) {

        switch (request.getRequestMethod()) {
            case GET: {
                doObserver(request, DatasService.getService().doGet(request.getUrl(), request.getHeaders(), request.getParams()), doBackground, callBack);
                break;
            }
            case POST: {
                doObserver(request, DatasService.getService().doPost(request.getUrl(), request.getHeaders(), request.getParams()), doBackground, callBack);
                break;
            }
        }
    }

    protected  <T> void doObserver(MvpRequest<T> request, Observable<String> observable, Consumer<MvpResponse<T>> consumer, IBackCallback<T> callBack) {
        observable.map(json2Data(request))
                .doOnNext(consumer)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MvpResponse<T>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        if(request.isEnableCancel()){
                            callBack.onStart(d);
                        }
                    }

                    @Override
                    public void onNext(@NonNull MvpResponse<T> data) {

                        callBack.onResult(data);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        callBack.onResult(new MvpResponse<T>().message(e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public <T> Function<String, MvpResponse<T>> json2Data(MvpRequest<T> request) {
        return new Function<String, MvpResponse<T>>() {
            @Override
            public MvpResponse<T> apply(String s) throws Throwable {

               // Thread.sleep(20 * 1000);
                // IBaseCallBack<ColumnData>

                /*Type[] types = callBack.getClass().getGenericInterfaces();
                ParameterizedType parameterizedType = (ParameterizedType) types[0];
                Type realType = parameterizedType.getActualTypeArguments()[0];
                */

                //HttpResult<ColumnData>
                Gson gson = new Gson();
                ParameterizedTypeImpl type = new ParameterizedTypeImpl(HttpResult.class, new Type[]{request.getType()});
                HttpResult<T> data = gson.fromJson(s, type);
                if (data.getCode() == 1) {
                    if (data.getData() != null) {
                        return new MvpResponse<T>().setData(data.getData()).setCode(data.getCode());
                    } else {
                        return new MvpResponse<T>().setCode(data.getCode()).message("服务器异常");
                    }
                } else {
                    return new MvpResponse<T>().setCode(data.getCode()).message(data.getMessage());
                }
            }
        };
    }

}
