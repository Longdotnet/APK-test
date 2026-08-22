package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
final class zzmm {
    private boolean zza;

    public zzmm(Context context, Looper looper, zzdj zzdjVar) {
        context.getApplicationContext();
        zzdjVar.zzd(looper, null);
    }

    public final void zza(boolean z) {
        if (this.zza == z) {
            return;
        }
        this.zza = z;
    }
}
