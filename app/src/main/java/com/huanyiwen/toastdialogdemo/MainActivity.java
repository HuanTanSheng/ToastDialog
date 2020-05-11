package com.huanyiwen.toastdialogdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.huanyiwen.toastdialog.ToastDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        ToastDialog.show("请选择支持投屏的播放器\n投屏", new ToastDialog.OnBtnClickListener() {
            @Override
            public void onOkClick() {

            }

            @Override
            public void onCancelClick() {

            }
        });
    }

    public void showToastSimple(View view) {
        ToastDialog.show("sdf");
    }

    public void showLoading(View view) {

        final ToastDialog dialog = ToastDialog.showLoading();
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 2000);

    }

    public void showProgress(View view) {

        final ToastDialog dialog = ToastDialog.showProgress("sss");
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.progressBar.setProgress(50);
            }
        }, 1500);
        view.postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 3000);

    }

}
