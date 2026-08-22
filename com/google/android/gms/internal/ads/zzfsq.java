package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfsq extends zzftc {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzftc
    public final zzftc zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzftc
    public final zzftc zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzftc
    public final zzftd zzc() {
        return new zzfss(this.zza, this.zzb, null);
    }
}
