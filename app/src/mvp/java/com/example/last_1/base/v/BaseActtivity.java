package com.example.last_1.base.v;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

public  abstract  class BaseActtivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initview();
    }

    protected abstract int getLayout();

    protected abstract void initview();
    protected  void showToast(String content){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();

    }
    protected  void showToast(@StringRes int id){
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }
}
