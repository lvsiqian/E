package com.example.last_1.pwd;

import com.example.last_1.base.p.IBasePrestener;
import com.example.last_1.base.v.IBackCallback;
import com.example.last_1.base.v.IBaseView;
import com.example.last_1.data.entity.User;
import com.example.last_1.data.net.request.MvpRequest;
import com.example.last_1.data.net.response.MvpResponse;

public interface PasswordLoginContract {
    interface  IPasswordPresetener extends IBasePrestener<IPasswordView>{

        void login(String username,String password);

    }
    interface  IPasswordView extends IBaseView<IPasswordPresetener> {
        void  OnSuccess(MvpResponse<User> response);
        void onInput(String msg);
        void onShowLoading();
        void CloseLoading();
    }
    interface  IPasseordmodel{
        void login(MvpRequest<User> request, IBackCallback<User> backCallback);

    }
}
