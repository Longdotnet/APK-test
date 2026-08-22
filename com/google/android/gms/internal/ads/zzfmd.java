package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfmd implements Runnable {
    final /* synthetic */ zzfme zza;

    public zzfmd(zzfme zzfmeVar) {
        Objects.requireNonNull(zzfmeVar);
        this.zza = zzfmeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfme zzfmeVar = this.zza;
        float fZza = zzfme.zza(zzfmeVar);
        zzfmeVar.zze.set(false);
        if (((Float) zzfmeVar.zzd.getAndSet(Float.valueOf(fZza))).floatValue() != fZza) {
            zzfmeVar.zza.post(new zzfmc(this, fZza));
        }
    }
}
