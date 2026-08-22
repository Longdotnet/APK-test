package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface zzavp {
    String zzd(Context context, String str, View view);

    String zze(Context context, String str, View view, Activity activity);

    String zzf(Context context);

    String zzg(Context context);

    String zzh(Context context, View view, Activity activity);

    void zzk(MotionEvent motionEvent);

    @Deprecated
    void zzl(int i, int i2, int i3);

    void zzn(StackTraceElement[] stackTraceElementArr);

    void zzo(View view);
}
