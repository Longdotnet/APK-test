package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzzx implements Runnable {
    private final zzzw zza;

    public zzzx(zzzw zzzwVar) {
        this.zza = zzzwVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzM();
    }
}
