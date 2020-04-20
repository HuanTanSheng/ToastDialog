package com.huanyiwen.toastdialogdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.huanyiwen.toastdialog.ToastDialog;

public class MainActivity extends AppCompatActivity {

    ToastDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        ToastDialog.show("测试成功", new ToastDialog.OnBtnClickListener() {
            @Override
            public void onOkClick() {

            }

            @Override
            public void onCancelClick() {

            }
        });
    }

    public void showLoading(View view) {
        if (null == dialog) {
            dialog = ToastDialog.showLoading();
            new TextView(this).postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            }, 2000);
            return;
        }

        dialog.show();
        new TextView(this).postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 2000);
    }
}
