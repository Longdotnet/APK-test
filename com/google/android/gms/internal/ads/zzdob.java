package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzdob extends zzdnl implements zzded {
    private zzded zza;

    @Override // com.google.android.gms.internal.ads.zzded
    public final synchronized void zzdH() {
        zzded zzdedVar = this.zza;
        if (zzdedVar != null) {
            zzdedVar.zzdH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final synchronized void zzdf() {
        zzded zzdedVar = this.zza;
        if (zzdedVar != null) {
            zzdedVar.zzdf();
        }
    }

    public final synchronized void zzi(com.google.android.gms.ads.internal.client.zza zzaVar, zzbiv zzbivVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbix zzbixVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, zzded zzdedVar) {
        zzh(zzaVar, zzbivVar, zzrVar, zzbixVar, zzadVar);
        this.zza = zzdedVar;
    }
}
