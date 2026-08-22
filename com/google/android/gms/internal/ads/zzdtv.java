package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdtv extends com.google.android.gms.ads.internal.client.zzbj {
    final /* synthetic */ zzdtp zza;
    final /* synthetic */ zzdtw zzb;

    public zzdtv(zzdtw zzdtwVar, zzdtp zzdtpVar) {
        this.zza = zzdtpVar;
        Objects.requireNonNull(zzdtwVar);
        this.zzb = zzdtwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzc() {
        this.zza.zzb(this.zzb.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzd() {
        this.zza.zzc(this.zzb.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zze(int i) {
        this.zza.zzd(this.zzb.zza, i);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zza.zzd(this.zzb.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzg() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzh() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzi() {
        this.zza.zze(this.zzb.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzj() {
        this.zza.zzg(this.zzb.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzk() {
    }
}
