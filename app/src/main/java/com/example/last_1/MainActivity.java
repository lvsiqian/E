package com.example.last_1;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.last_1.pwd.PasswordFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFl = (FrameLayout) findViewById(R.id.fl);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        PasswordFragment passwordFragment = new PasswordFragment();
        supportFragmentManager.beginTransaction()
                .add(R.id.fl,passwordFragment)
                .commit();
    }
}