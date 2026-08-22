package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzbjt implements zzgdj {
    final /* synthetic */ zzcfg zza;

    public zzbjt(zzcfg zzcfgVar) {
        this.zza = zzcfgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        zzcfg zzcfgVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzbw(zzcfgVar.getContext(), zzcfgVar.zzm().afmaVersion, str, zzcfgVar.zzD() != null ? zzcfgVar.zzD().zzax : null).zzb();
    }
}
