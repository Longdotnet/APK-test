package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzflg extends zzbxb {
    final /* synthetic */ zzgeh zza;
    final /* synthetic */ zzbwv zzb;
    final /* synthetic */ zzflh zzc;

    public zzflg(zzflh zzflhVar, zzgeh zzgehVar, zzbwv zzbwvVar) {
        this.zza = zzgehVar;
        this.zzb = zzbwvVar;
        Objects.requireNonNull(zzflhVar);
        this.zzc = zzflhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zze(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.zzb().toString();
        zzflh zzflhVar = this.zzc;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load rewarded ad with error: " + string + ", adUnitId: " + zzflhVar.zze.zza);
        zzflhVar.zzL(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzg() {
        Objects.requireNonNull(this.zzc);
        zzfkb.zza(this.zzb, this.zza);
    }
}
