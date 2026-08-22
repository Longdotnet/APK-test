package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbsg implements com.google.android.gms.ads.internal.overlay.zzr {
    final /* synthetic */ zzbsi zza;

    public zzbsg(zzbsi zzbsiVar) {
        Objects.requireNonNull(zzbsiVar);
        this.zza = zzbsiVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzd() {
        com.google.android.gms.ads.internal.util.client.zzo.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdk() {
        com.google.android.gms.ads.internal.util.client.zzo.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
        com.google.android.gms.ads.internal.util.client.zzo.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
        com.google.android.gms.ads.internal.util.client.zzo.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbsi zzbsiVar = this.zza;
        zzbsiVar.zzb.onAdOpened(zzbsiVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(int i) {
        com.google.android.gms.ads.internal.util.client.zzo.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbsi zzbsiVar = this.zza;
        zzbsiVar.zzb.onAdClosed(zzbsiVar);
    }
}
