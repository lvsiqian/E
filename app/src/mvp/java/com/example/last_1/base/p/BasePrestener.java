package com.example.last_1.base.p;

import android.content.Context;

import com.example.last_1.base.v.IBaseView;

public class BasePrestener <V extends IBaseView> implements IBasePrestener<V>{
   protected  V mView;

    @Override
    public void bindView(V view) {
        mView=view;

    }

    @Override
    public void unBind() {
        mView=null;

    }

    @Override
    public Context getMvpContent() {
        if(mView!=null){
            return  mView.getMvpContent();
        }
        return null;
    }

    @Override
    public boolean cancelRequest() {
        return false;
    }
}
