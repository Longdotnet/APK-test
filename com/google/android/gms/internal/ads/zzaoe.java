package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaoe implements zzadf {
    private final zzeu zza;
    private final zzen zzb = new zzen();
    private final int zzc;

    public zzaoe(int i, zzeu zzeuVar, int i2) {
        this.zzc = i;
        this.zza = zzeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final zzade zza(zzadw zzadwVar, long j) {
        int iZza;
        int iZza2;
        long jZzf = zzadwVar.zzf();
        int iMin = (int) Math.min(112800L, zzadwVar.zzd() - jZzf);
        zzen zzenVar = this.zzb;
        zzenVar.zzI(iMin);
        zzadwVar.zzh(zzenVar.zzN(), 0, iMin);
        int iZzd = zzenVar.zzd();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzenVar.zza() >= 188 && (iZza2 = (iZza = zzaop.zza(zzenVar.zzN(), zzenVar.zzc(), iZzd)) + 188) <= iZzd) {
            long jZzb = zzaop.zzb(zzenVar, iZza, this.zzc);
            if (jZzb != -9223372036854775807L) {
                long jZzb2 = this.zza.zzb(jZzb);
                if (jZzb2 <= j) {
                    j4 = iZza;
                    if (100000 + jZzb2 <= j) {
                        j3 = jZzb2;
                    }
                } else if (j3 == -9223372036854775807L) {
                    return zzade.zzd(jZzb2, jZzf);
                }
                return zzade.zze(jZzf + j4);
            }
            zzenVar.zzL(iZza2);
            j2 = iZza2;
        }
        return j3 != -9223372036854775807L ? zzade.zzf(j3, jZzf + j2) : zzade.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzb() {
        byte[] bArr = zzex.zzb;
        int length = bArr.length;
        this.zzb.zzJ(bArr, 0);
    }
}
