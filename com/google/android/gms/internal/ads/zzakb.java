package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzakb {
    public int zza;
    public long zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public final int[] zzf = new int[255];
    private final zzen zzg = new zzen(255);

    public final void zza() {
        this.zza = 0;
        this.zzb = 0L;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = 0;
    }

    public final boolean zzb(zzadw zzadwVar, boolean z) throws zzaz {
        zza();
        zzen zzenVar = this.zzg;
        zzenVar.zzI(27);
        if (zzadz.zzd(zzadwVar, zzenVar.zzN(), 0, 27, z) && zzenVar.zzu() == 1332176723) {
            if (zzenVar.zzm() != 0) {
                if (z) {
                    return false;
                }
                throw zzaz.zzc("unsupported bit stream revision");
            }
            this.zza = zzenVar.zzm();
            this.zzb = zzenVar.zzr();
            zzenVar.zzs();
            zzenVar.zzs();
            zzenVar.zzs();
            int iZzm = zzenVar.zzm();
            this.zzc = iZzm;
            this.zzd = iZzm + 27;
            zzenVar.zzI(iZzm);
            if (zzadz.zzd(zzadwVar, zzenVar.zzN(), 0, this.zzc, z)) {
                for (int i = 0; i < this.zzc; i++) {
                    int[] iArr = this.zzf;
                    int iZzm2 = zzenVar.zzm();
                    iArr[i] = iZzm2;
                    this.zze += iZzm2;
                }
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzadw zzadwVar, long j) {
        zzdd.zzd(zzadwVar.zzf() == zzadwVar.zze());
        zzen zzenVar = this.zzg;
        zzenVar.zzI(4);
        while (true) {
            if ((j != -1 && zzadwVar.zzf() + 4 >= j) || !zzadz.zzd(zzadwVar, zzenVar.zzN(), 0, 4, true)) {
                break;
            }
            zzenVar.zzL(0);
            if (zzenVar.zzu() == 1332176723) {
                zzadwVar.zzj();
                return true;
            }
            zzadwVar.zzk(1);
        }
        do {
            if (j != -1 && zzadwVar.zzf() >= j) {
                break;
            }
        } while (zzadwVar.zzc(1) != -1);
        return false;
    }
}
