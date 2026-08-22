package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzafx implements zzadf {
    private final zzaeg zza;
    private final int zzb;
    private final zzaeb zzc = new zzaeb();

    public /* synthetic */ zzafx(zzaeg zzaegVar, int i, zzafy zzafyVar) {
        this.zza = zzaegVar;
        this.zzb = i;
    }

    private final long zzc(zzadw zzadwVar) {
        while (zzadwVar.zze() < zzadwVar.zzd() - 6) {
            zzaeg zzaegVar = this.zza;
            int i = this.zzb;
            zzaeb zzaebVar = this.zzc;
            long jZze = zzadwVar.zze();
            byte[] bArr = new byte[2];
            zzadwVar.zzh(bArr, 0, 2);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                zzadwVar.zzj();
                zzadwVar.zzg((int) (jZze - zzadwVar.zzf()));
            } else {
                zzen zzenVar = new zzen(16);
                System.arraycopy(bArr, 0, zzenVar.zzN(), 0, 2);
                zzenVar.zzK(zzadz.zzb(zzadwVar, zzenVar.zzN(), 2, 14));
                zzadwVar.zzj();
                zzadwVar.zzg((int) (jZze - zzadwVar.zzf()));
                if (zzaec.zzc(zzenVar, zzaegVar, i, zzaebVar)) {
                    break;
                }
            }
            zzadwVar.zzg(1);
        }
        if (zzadwVar.zze() < zzadwVar.zzd() - 6) {
            return this.zzc.zza;
        }
        zzadwVar.zzg((int) (zzadwVar.zzd() - zzadwVar.zze()));
        return this.zza.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final zzade zza(zzadw zzadwVar, long j) {
        long jZzf = zzadwVar.zzf();
        long jZzc = zzc(zzadwVar);
        long jZze = zzadwVar.zze();
        zzadwVar.zzg(Math.max(6, this.zza.zzc));
        long jZzc2 = zzc(zzadwVar);
        long jZze2 = zzadwVar.zze();
        if (jZzc > j || jZzc2 <= j) {
            return jZzc2 <= j ? zzade.zzf(jZzc2, jZze2) : zzade.zzd(jZzc, jZzf);
        }
        return zzade.zze(jZze);
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final /* synthetic */ void zzb() {
    }
}
