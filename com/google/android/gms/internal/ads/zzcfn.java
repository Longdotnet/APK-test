package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzcfn implements com.google.android.gms.ads.internal.overlay.zzr {
    private final zzcfg zza;
    private final com.google.android.gms.ads.internal.overlay.zzr zzb;

    public zzcfn(zzcfg zzcfgVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar) {
        this.zza = zzcfgVar;
        this.zzb = zzrVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzb;
        if (zzrVar != null) {
            zzrVar.zzds();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzb;
        if (zzrVar != null) {
            zzrVar.zzdt();
        }
        this.zza.zzaa();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzb;
        if (zzrVar != null) {
            zzrVar.zzdv();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(int i) {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzb;
        if (zzrVar != null) {
            zzrVar.zzdw(i);
        }
        this.zza.zzY();
    }
}
