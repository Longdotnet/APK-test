package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class zzdnl implements com.google.android.gms.ads.internal.client.zza, zzbiv, com.google.android.gms.ads.internal.overlay.zzr, zzbix, com.google.android.gms.ads.internal.overlay.zzad {
    private com.google.android.gms.ads.internal.client.zza zza;
    private zzbiv zzb;
    private com.google.android.gms.ads.internal.overlay.zzr zzc;
    private zzbix zzd;
    private com.google.android.gms.ads.internal.overlay.zzad zze;

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zza;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbiv
    public final synchronized void zza(String str, Bundle bundle) {
        zzbiv zzbivVar = this.zzb;
        if (zzbivVar != null) {
            zzbivVar.zza(str, bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final synchronized void zzb(String str, String str2) {
        zzbix zzbixVar = this.zzd;
        if (zzbixVar != null) {
            zzbixVar.zzb(str, str2);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzd() {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzc;
        if (zzrVar != null) {
            zzrVar.zzd();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdk() {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzc;
        if (zzrVar != null) {
            zzrVar.zzdk();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzds() {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzc;
        if (zzrVar != null) {
            zzrVar.zzds();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdt() {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzc;
        if (zzrVar != null) {
            zzrVar.zzdt();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdv() {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzc;
        if (zzrVar != null) {
            zzrVar.zzdv();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdw(int i) {
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzc;
        if (zzrVar != null) {
            zzrVar.zzdw(i);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzad
    public final synchronized void zzg() {
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zze;
        if (zzadVar != null) {
            zzadVar.zzg();
        }
    }

    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zza zzaVar, zzbiv zzbivVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbix zzbixVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar) {
        this.zza = zzaVar;
        this.zzb = zzbivVar;
        this.zzc = zzrVar;
        this.zzd = zzbixVar;
        this.zze = zzadVar;
    }
}
