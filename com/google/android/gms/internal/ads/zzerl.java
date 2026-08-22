package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzerl implements zzeub {
    private final boolean zza;

    public zzerl(boolean z) {
        this.zza = z;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ((zzcva) obj).zzb.putBoolean("is_gbid", this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcva) obj).zza.putBoolean("is_gbid", this.zza);
    }
}
