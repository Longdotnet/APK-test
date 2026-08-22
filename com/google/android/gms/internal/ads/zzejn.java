package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzejn implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzdfc zza;

    public zzejn(zzejo zzejoVar, zzdfc zzdfcVar) {
        this.zza = zzdfcVar;
        Objects.requireNonNull(zzejoVar);
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        this.zza.zzb().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        zzdfc zzdfcVar = this.zza;
        zzdfcVar.zzc().zza();
        zzdfcVar.zzf().zza();
    }
}
