package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzcaz implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcbf zzc;

    public zzcaz(zzcbf zzcbfVar, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        Objects.requireNonNull(zzcbfVar);
        this.zzc = zzcbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcbf zzcbfVar = this.zzc;
        if (zzcbfVar.zzr != null) {
            zzcbfVar.zzr.zzb(this.zza, this.zzb);
        }
    }
}
