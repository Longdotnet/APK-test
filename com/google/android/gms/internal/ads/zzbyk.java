package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zzbyk implements zzazd {
    private final Context zza;
    private final Object zzb;
    private final String zzc;
    private boolean zzd;

    public zzbyk(Context context, String str) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = str;
        this.zzd = false;
        this.zzb = new Object();
    }

    public final String zza() {
        return this.zzc;
    }

    public final void zzb(boolean z) {
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        zzbyo zzbyoVar = zzvVar.zzB;
        Context context = this.zza;
        if (zzbyoVar.zzp(context)) {
            synchronized (this.zzb) {
                try {
                    if (this.zzd == z) {
                        return;
                    }
                    this.zzd = z;
                    String str = this.zzc;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (this.zzd) {
                        zzvVar.zzB.zzf(context, str);
                    } else {
                        zzvVar.zzB.zzg(context, str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        zzb(zzazcVar.zzj);
    }
}
