package com.example.last_1.base.v;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public  abstract  class BaseFragment  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(getLayoutId(),container,false);

        FrameLayout frameLayout = new FrameLayout(getContext());

        frameLayout.addView(v);

        return frameLayout;


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview();
    }
    protected abstract int getLayoutId();

    protected abstract void initview();
    public  < T extends  View> T findViewById(@IdRes int id){
        return getView().findViewById(id);
    }
}
