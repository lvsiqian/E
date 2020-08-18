package com.example.last_1.pwd;

import com.example.last_1.R;
import com.example.last_1.base.p.BasePrestener;
import com.example.last_1.base.v.IBackCallback;
import com.example.last_1.data.entity.User;
import com.example.last_1.data.net.request.PostRequest;
import com.example.last_1.data.net.response.MvpResponse;
import com.example.last_1.utils.AppUtils;
import com.example.last_1.utils.Constrant;
import com.example.last_1.utils.ParamsUtils;

import java.util.HashMap;

public class PasswordPresetener extends BasePrestener<PasswordLoginContract.IPasswordView> implements PasswordLoginContract.IPasswordPresetener {
   private  PasswordLoginContract.IPasseordmodel mdole;
   protected  PasswordPresetener(){
       mdole=new PasswordReposity();
   }
    @Override
    public void login(String username, String password) {
       if(!AppUtils.isValidUserCount(username)){
           mView.onInput(getMvpContent().getResources().getString(R.string.text_username_error));
           return;
       }
        if(!AppUtils.isValidUserPasssword(password)){
            mView.onInput(getMvpContent().getResources().getString(R.string.text_password_error));
            return;
        }
        PostRequest postRequest = new PostRequest(Constrant.URL.LOGIN);
        HashMap<String, Object> commonParams = ParamsUtils.getCommonParams();
        commonParams.put(Constrant.RequestKey.KEY_USER_ACCOUNT,username);
        commonParams.put(Constrant.RequestKey.KEY_USER_PASSWORD,password);
        postRequest.setParams(commonParams);
       mView.onShowLoading();
        mdole.login(postRequest, new IBackCallback<User>() {
            @Override
            public void onResult(MvpResponse<User> response) {
                mView.CloseLoading();

                mView.OnSuccess(response);
            }
        });

    }
}
