package com.example.last_1.base.v;

import android.content.Context;

import com.example.last_1.base.p.IBasePrestener;

public interface IBaseView<P extends IBasePrestener> {
    P createPrestener();
    Context getMvpContent();
}
