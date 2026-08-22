package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfke extends zzbay {
    final /* synthetic */ zzgeh zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzfv zzb;
    final /* synthetic */ zzfkf zzc;

    public zzfke(zzfkf zzfkfVar, zzgeh zzgehVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar) {
        this.zza = zzgehVar;
        this.zzb = zzfvVar;
        Objects.requireNonNull(zzfkfVar);
        this.zzc = zzfkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzb(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load app open ad with error parcel: " + zzeVar.zzb().toString() + " for ad unit: " + this.zzb.zza);
        zzfkf zzfkfVar = this.zzc;
        Objects.requireNonNull(zzfkfVar);
        zzfkfVar.zzL(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbaz
    public final void zzd(zzbaw zzbawVar) {
        Objects.requireNonNull(this.zzc);
        zzfkb.zza(zzbawVar, this.zza);
    }
}
