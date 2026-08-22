package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzcfu implements Runnable {
    public final /* synthetic */ zzcfg zza;

    public /* synthetic */ zzcfu(zzcfg zzcfgVar) {
        this.zza = zzcfgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.destroy();
    }
}
