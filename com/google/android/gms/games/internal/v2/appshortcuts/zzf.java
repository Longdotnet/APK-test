package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class zzf {
    public static zzf zzd(Context context) {
        return Build.VERSION.SDK_INT < 25 ? new zza() : new zze(context);
    }

    public void zza() {
    }
}
