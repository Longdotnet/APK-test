package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfky implements Runnable {
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzea zza;
    final /* synthetic */ zzfld zzb;

    public zzfky(zzfld zzfldVar, com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.zza = zzeaVar;
        Objects.requireNonNull(zzfldVar);
        this.zzb = zzfldVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzH(this.zza);
    }
}
