package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfkh extends com.google.android.gms.ads.internal.client.zzbm {
    final /* synthetic */ zzgeh zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbx zzb;
    final /* synthetic */ zzfki zzc;

    public zzfkh(zzfki zzfkiVar, zzgeh zzgehVar, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        this.zza = zzgehVar;
        this.zzb = zzbxVar;
        Objects.requireNonNull(zzfkiVar);
        this.zzc = zzfkiVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.zzb().toString();
        zzfki zzfkiVar = this.zzc;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load interstitial ad with error: " + string + " for ad unit: " + zzfkiVar.zze.zza);
        zzfkiVar.zzL(zzeVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzc() {
        Objects.requireNonNull(this.zzc);
        zzfkb.zza(this.zzb, this.zza);
    }
}
