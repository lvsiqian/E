package com.example.last_1.pwd;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.last_1.R;
import com.example.last_1.base.v.MvpBaseFragment;
import com.example.last_1.data.entity.User;
import com.example.last_1.data.net.response.MvpResponse;
import com.example.last_1.utils.Logger;
import com.example.last_1.widgets.CleanEditButton;
import com.example.last_1.widgets.EditTextButton;
import com.example.last_1.widgets.TogglePasswordButton;

public class PasswordFragment extends MvpBaseFragment<PasswordLoginContract.IPasswordPresetener> implements  PasswordLoginContract.IPasswordView {

    private EditText mEdtCount;
    private EditText mEdtPassword;
    private CleanEditButton mBtnCleanAccount;
    private CleanEditButton mBtnCleanPassword;
    private TogglePasswordButton mBtnTogglePassword;

    private TextView mTvCodeLogin;
    private TextView mTvRegister;

    private EditTextButton mBtnLogin;
    @Override
    protected int getLayoutId() {
        return R.layout.passweord_login_view;
    }





    @Override
    protected void initview() {
        mEdtCount= findViewById(R.id.auth_password_login_edt_phone_number);
        mEdtPassword= findViewById(R.id.auth_password_login_edt_password);
        mBtnLogin= findViewById(R.id.auth_password_login_btn_login);
        mBtnCleanAccount= findViewById(R.id.auth_password_login_btn_phone_number_clean);
        mBtnCleanPassword= findViewById(R.id.auth_password_login_btn_password_clean);
        mBtnTogglePassword= findViewById(R.id.auth_password_login_btn_toggle_password);
        mTvCodeLogin= findViewById(R.id.auth_password_login_tv_go_code_login);
        mTvRegister= findViewById(R.id.auth_password_login_tv_go_regiester);

        mBtnCleanPassword.bindEditText(mEdtPassword);
        mBtnTogglePassword.bindEditText(mEdtPassword);
        mBtnCleanAccount.bindEditText(mEdtCount);
        mBtnLogin.bindEditText(mEdtPassword);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresetener.login(mEdtCount.getText().toString().trim(),mEdtPassword.getText().toString().trim());

            }
        });
        mTvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mTvCodeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public void OnSuccess(MvpResponse<User> response) {
        if(response.isOk()){
            Toast.makeText(getContext(), R.string.text_login_success, Toast.LENGTH_SHORT).show();
            Logger.d("用户登录成功");
        }

    }

    @Override
    public void onShowLoading() {
        showPopLoading();

    }

    @Override
    public void CloseLoading() {
        closeLoading();

    }


    @Override
    public void onInput(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public PasswordLoginContract.IPasswordPresetener createPrestener() {
        return new PasswordPresetener();
    }

    @Override
    public Context getMvpContent() {
        return null;
    }
}
