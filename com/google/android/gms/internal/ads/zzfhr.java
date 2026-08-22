package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfhr implements zzgdj {
    final /* synthetic */ zzfhu zza;
    final /* synthetic */ zzfhj zzb;
    final /* synthetic */ boolean zzc;

    public zzfhr(zzfhu zzfhuVar, zzfhj zzfhjVar, boolean z) {
        this.zza = zzfhuVar;
        this.zzb = zzfhjVar;
        this.zzc = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfhj zzfhjVar = this.zzb;
        if (zzfhjVar.zzk()) {
            zzfhu zzfhuVar = this.zza;
            zzfhjVar.zzh(th);
            zzfhjVar.zzg(false);
            zzfhuVar.zza(zzfhjVar);
            if (this.zzc) {
                zzfhuVar.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zzb(Object obj) {
        zzfhj zzfhjVar = this.zzb;
        zzfhjVar.zzg(true);
        zzfhu zzfhuVar = this.zza;
        zzfhuVar.zza(zzfhjVar);
        if (this.zzc) {
            zzfhuVar.zzh();
        }
    }
}
