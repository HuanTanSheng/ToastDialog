package com.huanyiwen.toastdialogdemo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.huanyiwen.toastdialog.ToastDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        ToastDialog.show("测试成功");
    }

    public void showLoading(View view) {
        ToastDialog.showLoading();
    }
}
