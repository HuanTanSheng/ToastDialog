package com.huanyiwen.toastdialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.mic.etoast2.EToastUtils;

public class ToastDialog extends BottomSheetDialog {

    private TextView tvMsg;
    private ProgressBar progressBar;

    private ToastDialog(@NonNull Context context) {
        super(context);
    }


    private ToastDialog(@NonNull Context context, String msg) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_dialog_simple, null);
        tvMsg = view.findViewById(R.id.tv_msg);
        tvMsg.setText(msg);
        this.setContentView(view);
        Window window = getWindow();
        if (null != window) {
            View v = window.findViewById(R.id.design_bottom_sheet);
            if (null != v) {
                v.setBackgroundResource(android.R.color.transparent);
            }
        }
    }

    private ToastDialog(@NonNull Context context, @StringRes int msg) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_dialog_simple, null);
        tvMsg = view.findViewById(R.id.tv_msg);
        tvMsg.setText(msg);
        this.setContentView(view);
        Window window = getWindow();
        if (null != window) {
            View v = window.findViewById(R.id.design_bottom_sheet);
            if (null != v) {
                v.setBackgroundResource(android.R.color.transparent);
            }
        }
    }

    private ToastDialog(@NonNull Context context, String msg, final OnBtnClickListener listener) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_dialog_action, null);
        tvMsg = view.findViewById(R.id.tv_msg);
        tvMsg.setText(msg);

        view.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onCancelClick();
            }
        });
        view.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onOkClick();
            }
        });

        this.setContentView(view);
        Window window = getWindow();
        if (null != window) {
            View v = window.findViewById(R.id.design_bottom_sheet);
            if (null != v) {
                v.setBackgroundResource(android.R.color.transparent);
            }
        }
    }

    private ToastDialog(@NonNull Context context, @StringRes int msg,
                        final OnBtnClickListener listener) {

        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.toast_dialog_action, null);
        tvMsg = view.findViewById(R.id.tv_msg);
        tvMsg.setText(msg);

        view.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onCancelClick();
            }
        });
        view.findViewById(R.id.tv_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onOkClick();
            }
        });

        this.setContentView(view);
        Window window = getWindow();
        if (null != window) {
            View v = window.findViewById(R.id.design_bottom_sheet);
            if (null != v) {
                v.setBackgroundResource(android.R.color.transparent);
            }
        }
    }

    public static void show(final String msg) {
        final Activity cxt = EToastUtils.getInstance().getActivity();
        if (null == cxt) {
            return;
        }
        cxt.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final ToastDialog toast = new ToastDialog(cxt, msg);
                toast.setCancelable(true);
                toast.setCanceledOnTouchOutside(true);
                try {
                    toast.show();
                    toast.tvMsg.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                toast.dismiss();
                            } catch (Exception e) {
                                EToastUtils.show(msg);
                            }
                        }
                    }, 2000);
                } catch (Exception e) {
                    EToastUtils.show(msg);
                }
            }
        });

    }

    public static void show(@StringRes final int msg) {
        final Activity cxt = EToastUtils.getInstance().getActivity();
        if (null == cxt) {
            return;
        }
        cxt.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final ToastDialog toast = new ToastDialog(cxt, msg);
                toast.setCancelable(true);
                toast.setCanceledOnTouchOutside(true);
                try {
                    toast.show();
                    toast.tvMsg.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                toast.dismiss();
                            } catch (Exception e) {
                                EToastUtils.show(msg);
                            }
                        }
                    }, 2000);
                } catch (Exception e) {
                    EToastUtils.show(msg);
                }
            }
        });

    }

    public static void show(final String msg, final OnBtnClickListener listener) {
        final Activity cxt = EToastUtils.getInstance().getActivity();
        if (null == cxt) {
            listener.onOkClick();
            return;
        }
        cxt.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastDialog toast = new ToastDialog(cxt, msg, listener);
                toast.setCancelable(true);
                toast.setCanceledOnTouchOutside(false);
                toast.setOnCancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        listener.onCancelClick();
                    }
                });
                try {
                    toast.show();
                } catch (Exception e) {
                    listener.onOkClick();
                }
            }
        });

    }

    public static void show(@StringRes final int msg, final OnBtnClickListener listener) {
        final Activity cxt = EToastUtils.getInstance().getActivity();
        if (null == cxt) {
            listener.onOkClick();
            return;
        }
        cxt.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ToastDialog toast = new ToastDialog(cxt, msg, listener);
                toast.setCancelable(true);
                toast.setCanceledOnTouchOutside(false);
                toast.setOnCancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        listener.onCancelClick();
                    }
                });
                try {
                    toast.show();
                } catch (Exception e) {
                    listener.onOkClick();
                }
            }
        });

    }

    public static ToastDialog showLoading(String msg) {
        Activity cxt = EToastUtils.getInstance().getActivity();
        ToastDialog loading = new ToastDialog(cxt);
        View view = LayoutInflater.from(cxt).inflate(R.layout.toast_dialog_loading, null);
        loading.tvMsg = view.findViewById(R.id.tv_msg);
        loading.tvMsg.setText(msg);
        loading.setContentView(view);
        Window window = loading.getWindow();
        if (null != window) {
            View v = window.findViewById(R.id.design_bottom_sheet);
            if (null != v) {
                v.setBackgroundResource(android.R.color.transparent);
            }
        }
        loading.setCancelable(false);
        loading.setCanceledOnTouchOutside(false);
        loading.show();
        return loading;
    }

    public static ToastDialog showLoading() {
        return showLoading("正在加载");
    }

    public static ToastDialog showProgress(String msg) {
        Activity cxt = EToastUtils.getInstance().getActivity();
        ToastDialog progressDialog = new ToastDialog(cxt);
        View view = LayoutInflater.from(cxt).inflate(R.layout.toast_dialog_progress, null);
        progressDialog.tvMsg = view.findViewById(R.id.tv_msg);
        progressDialog.progressBar = view.findViewById(R.id.m_progress_bar);
        progressDialog.tvMsg.setText(msg);
        progressDialog.setContentView(view);
        Window window = progressDialog.getWindow();
        if (null != window) {
            View v = window.findViewById(R.id.design_bottom_sheet);
            if (null != v) {
                v.setBackgroundResource(android.R.color.transparent);
            }
        }
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        return progressDialog;
    }

    public interface OnBtnClickListener {
        public void onOkClick();

        public void onCancelClick();
    }
}

