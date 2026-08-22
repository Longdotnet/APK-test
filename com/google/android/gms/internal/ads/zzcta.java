package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcta implements com.google.android.gms.ads.internal.client.zza {
    private final zzcte zza;
    private final zzfcw zzb;

    public zzcta(zzcte zzcteVar, zzfcw zzfcwVar) {
        this.zza = zzcteVar;
        this.zzb = zzfcwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
