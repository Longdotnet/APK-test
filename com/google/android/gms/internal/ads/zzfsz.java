package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfsz extends zzfuc {
    private String zza;
    private String zzb;

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final zzfuc zza(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final zzfuc zzb(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfuc
    public final zzfud zzc() {
        return new zzftb(this.zza, this.zzb, null);
    }
}
