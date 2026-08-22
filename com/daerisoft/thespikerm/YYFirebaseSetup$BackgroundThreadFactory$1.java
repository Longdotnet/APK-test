package com.daerisoft.thespikerm;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class YYFirebaseSetup$BackgroundThreadFactory$1 implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        Log.e(GooglePlayBillingService.TAG, thread.getName() + " encountered an error: " + th.getMessage());
    }
}
