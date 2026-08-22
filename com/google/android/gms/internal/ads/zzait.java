package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzait implements zzaiq {
    private final int zza;
    private final int zzb;
    private final zzen zzc;

    public zzait(zzfd zzfdVar, zzz zzzVar) {
        zzen zzenVar = zzfdVar.zza;
        this.zzc = zzenVar;
        zzenVar.zzL(12);
        int iZzp = zzenVar.zzp();
        if ("audio/raw".equals(zzzVar.zzo)) {
            int iZzk = zzex.zzk(zzzVar.zzI) * zzzVar.zzG;
            if (iZzp == 0 || iZzp % iZzk != 0) {
                zzea.zzf("BoxParsers", "Audio sample size mismatch. stsd sample size: " + iZzk + ", stsz sample size: " + iZzp);
                iZzp = iZzk;
            }
        }
        this.zza = iZzp == 0 ? -1 : iZzp;
        this.zzb = zzenVar.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzp() : i;
    }
}
