package com.example.last_1.base.p;

import android.content.Context;

import com.example.last_1.base.v.IBaseView;

public interface IBasePrestener<V extends IBaseView> {
    void bindView(V view);
    void unBind();
    Context getMvpContent();
    boolean cancelRequest();
}
