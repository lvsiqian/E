package com.example.last_1.base.v;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.last_1.base.p.IBasePrestener;
import com.example.last_1.widgets.MvpLoadingView;

public   abstract  class MvpBaseFragment<p extends IBasePrestener>  extends  BaseFragment implements IBaseView<p>,BaseView{
        protected  p mPresetener;
        protected  MvpLoadingView mvpLoadingView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresetener=createPrestener();
        mPresetener.bindView(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresetener.unBind();
    }

    @Override
    public void setLoadView(MvpLoadingView loadingView) {

        mvpLoadingView=loadingView;
    }

    @Override
    public MvpLoadingView getLoadingView() {
        return mvpLoadingView ;
    }

    @Override
    public IBasePrestener getPresenter() {
       return  mPresetener;
    }
}
