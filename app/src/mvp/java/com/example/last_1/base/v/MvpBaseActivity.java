package com.example.last_1.base.v;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.last_1.base.p.IBasePrestener;
import com.example.last_1.widgets.MvpLoadingView;

public  abstract   class MvpBaseActivity<P extends IBasePrestener> extends  BaseActtivity implements  IBaseView<P>,BaseView {

   protected  P mpresetener;
   private  MvpLoadingView mvpLoadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mpresetener=createPrestener();
        mpresetener.bindView(this);
        load();
    }

    private void load() {
    }

     @Override
    protected  abstract int getLayout() ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mpresetener.unBind();
    }

    @Override
    public void setLoadView(MvpLoadingView loadingView) {
        mvpLoadingView=loadingView;
    }

    @Override
    public MvpLoadingView getLoadingView() {
        return mvpLoadingView;
    }
}
