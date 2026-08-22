package com.google.android.gms.measurement.internal;

import com.google.firebase.auth.zzz;

/* JADX INFO: loaded from: classes.dex */
public final class zzjx implements Runnable {
    public final long zza;
    public final long zzb;
    public final /* synthetic */ zzz zzc;

    public zzjx(zzz zzzVar, long j, long j2) {
        this.zzc = zzzVar;
        this.zza = j;
        this.zzb = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfo zzfoVar = ((zzfr) ((zzkc) this.zzc.zzb).mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new com.google.android.gms.tasks.zzg(this, 1));
    }
}
