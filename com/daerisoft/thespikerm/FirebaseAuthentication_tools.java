package com.daerisoft.thespikerm;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.work.Worker;
import com.yoyogames.runner.RunnerJNILib;

/* JADX INFO: loaded from: classes2.dex */
public class FirebaseAuthentication_tools {
    public static final int EVENT_OTHER_SOCIAL = 70;
    public static Activity activity;
    public static ImageView imageView;
    public static WebView webView;

    public FirebaseAuthentication_tools() {
        activity = RunnerActivity.CurrentActivity;
    }

    public void FirebaseAuthentication_Tools_WebView_Create(String str) {
        activity.runOnUiThread(new Worker.AnonymousClass1(str, 17));
        WebView_closeButton_add();
    }

    public void FirebaseAuthentication_Tools_WebView_Delete() {
        if (webView == null) {
            return;
        }
        WebView_closeButton_destroy();
        activity.runOnUiThread(new RunnerJNILib.AnonymousClass1(4));
    }

    public void WebView_closeButton_add() {
        activity.runOnUiThread(new RunnerJNILib.AnonymousClass1(5));
    }

    public void WebView_closeButton_destroy() {
        if (imageView == null) {
            return;
        }
        activity.runOnUiThread(new RunnerJNILib.AnonymousClass1(6));
    }

    public void WebView_closeButton_setAlpha(double d) {
        ImageView imageView2 = imageView;
        if (imageView2 == null) {
            return;
        }
        imageView2.setImageAlpha((int) (d * 255.0d));
    }
}
