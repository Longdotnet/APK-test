package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzei implements Runnable {
    public final /* synthetic */ zzej zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzei(zzej zzejVar, Context context) {
        this.zza = zzejVar;
        this.zzb = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel.zzd(this.zza.zza, this.zzb);
    }
}
