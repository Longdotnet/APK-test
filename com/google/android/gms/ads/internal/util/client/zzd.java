package com.google.android.gms.ads.internal.util.client;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends Thread {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;

    public zzd(zzf zzfVar, Context context, String str) {
        this.zza = context;
        this.zzb = str;
        Objects.requireNonNull(zzfVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzu(this.zza, null).zza(this.zzb);
    }
}
