package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfhs implements zzgdj {
    final /* synthetic */ zzfhu zza;
    final /* synthetic */ zzfhj zzb;

    public zzfhs(zzfhu zzfhuVar, zzfhj zzfhjVar) {
        this.zza = zzfhuVar;
        this.zzb = zzfhjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhj zzfhjVar = this.zzb;
        zzfhjVar.zzh(th);
        zzfhjVar.zzg(false);
        this.zza.zza(zzfhjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
    }
}
