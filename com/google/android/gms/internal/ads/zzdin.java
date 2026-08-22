package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdin implements zzgdj {
    final /* synthetic */ View zza;
    final /* synthetic */ zzdio zzb;

    public zzdin(zzdio zzdioVar, View view) {
        this.zza = view;
        Objects.requireNonNull(zzdioVar);
        this.zzb = zzdioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfH)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, "omid native display exp");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzag(this.zza, (zzedh) obj);
    }
}
