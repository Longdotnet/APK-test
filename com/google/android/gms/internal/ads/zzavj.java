package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzavj implements zzfpj {
    final /* synthetic */ zzfoi zza;

    public zzavj(zzfoi zzfoiVar) {
        this.zza = zzfoiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfpj
    public final void zza(int i, long j) {
        this.zza.zzd(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfpj
    public final void zzb(int i, long j, String str) {
        this.zza.zze(i, System.currentTimeMillis() - j, str);
    }
}
