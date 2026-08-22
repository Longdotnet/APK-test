package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class zzuq implements zzxb {
    private final zzxb zza;
    private final zzfyq zzb;

    public zzuq(zzxb zzxbVar, List list) {
        this.zza = zzxbVar;
        this.zzb = zzfyq.zzl(list);
    }

    public final zzfyq zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final long zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final long zzc() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void zzm(long j) {
        this.zza.zzm(j);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean zzo(zzla zzlaVar) {
        return this.zza.zzo(zzlaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean zzp() {
        return this.zza.zzp();
    }
}
