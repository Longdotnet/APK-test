package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzdmb implements zzgdj {
    final /* synthetic */ zzcak zza;

    public zzdmb(zzdmc zzdmcVar, zzcak zzcakVar) {
        this.zza = zzcakVar;
        Objects.requireNonNull(zzdmcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load media data due to video view load failure.");
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcfg zzcfgVar = (zzcfg) obj;
        if (zzcfgVar == null) {
            this.zza.zzd(new zzehf(1, "Missing webview from video view future."));
        } else {
            zzcfgVar.zzag("/video", new zzccz(new zzdma(this.zza)));
            zzcfgVar.zzaa();
        }
    }
}
