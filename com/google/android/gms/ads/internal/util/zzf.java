package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.os.Message;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzfrw;

/* JADX INFO: loaded from: classes.dex */
public final class zzf extends zzfrw {
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdMobHandler.handleMessage");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfrw
    public final void zza(Message message) {
        try {
            super.zza(message);
        } catch (Throwable th) {
            zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            Context contextZzd = com.google.android.gms.ads.internal.zzv.zza.zzi.zzd();
            if (contextZzd != null) {
                try {
                    if (((Boolean) zzbfn.zzb.zze()).booleanValue()) {
                        Hex.addDynamiteErrorToDropBox(contextZzd, th);
                    }
                } catch (IllegalStateException unused) {
                }
            }
            throw th;
        }
    }
}
