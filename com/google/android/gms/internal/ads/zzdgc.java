package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdgc implements com.google.android.gms.ads.internal.overlay.zzr {
    private final zzcye zza;
    private final zzddp zzb;

    public zzdgc(zzcye zzcyeVar, zzddp zzddpVar) {
        this.zza = zzcyeVar;
        this.zzb = zzddpVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
        this.zza.zzdk();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
        this.zza.zzds();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
        this.zza.zzdt();
        this.zzb.zzb();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
        this.zza.zzdv();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(int i) {
        this.zza.zzdw(i);
        this.zzb.zza();
    }
}
