package com.example.last_1.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class CleanEditButton  extends AppCompatImageView {
    private  OnClickListener mListener;
    private EditText mEditText;

    public CleanEditButton(Context context) {
        super(context);
    }

    public CleanEditButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CleanEditButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        super.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onClick(view);
                }

                if(mEditText != null){
                    mEditText.setText(null);
                }
            }
        });
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
       mListener=l;
    }
    public  void bindEditText(EditText editText){
        mEditText=editText;
        hideOrShow(editText);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                hideOrShow(editText);
            }
        });

    }

    private void hideOrShow(EditText editText) {
        if(editText.getText().toString().length() > 0){
            setVisibility(VISIBLE);
        }else{
            setVisibility(GONE);
        }
    }
}
