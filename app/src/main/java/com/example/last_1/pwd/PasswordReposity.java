package com.example.last_1.pwd;

import com.example.last_1.base.v.IBackCallback;
import com.example.last_1.data.entity.User;

import com.example.last_1.data.net.request.MvpRequest;
import com.example.last_1.data.net.response.MvpResponse;
import com.example.last_1.data.repository.BaseRepository;
import com.lvsiqian.mvplibs.manger.MvpUserManager;

import io.reactivex.rxjava3.functions.Consumer;


public class PasswordReposity extends BaseRepository implements  PasswordLoginContract.IPasseordmodel {

    @Override
    public void login(MvpRequest<User> request, IBackCallback<User> backCallback) {
        doRequest(request, new Consumer<MvpResponse<User>>() {
            @Override
            public void accept(MvpResponse<User> userMvpResponse) throws Throwable {

                if(userMvpResponse.isOk()){
                    User user = userMvpResponse.getData();
                    MvpUserManager.login(user);

                }
            }
        },backCallback);
    }
}
