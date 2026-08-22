package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaih implements zzaig {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzaih(long[] jArr, long[] jArr2, long j, long j2, long j3, int i) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j3;
        this.zze = i;
    }

    public static zzaih zzb(long j, long j2, zzaen zzaenVar, zzen zzenVar) {
        long jMax;
        int iZzm;
        zzenVar.zzM(6);
        int iZzg = zzenVar.zzg();
        long j3 = zzaenVar.zzc;
        long j4 = iZzg;
        int iZzg2 = zzenVar.zzg();
        if (iZzg2 <= 0) {
            return null;
        }
        long jZzt = zzex.zzt((((long) iZzg2) * ((long) zzaenVar.zzg)) - 1, zzaenVar.zzd);
        int iZzq = zzenVar.zzq();
        int iZzq2 = zzenVar.zzq();
        int iZzq3 = zzenVar.zzq();
        zzenVar.zzM(2);
        long j5 = j2 + ((long) zzaenVar.zzc);
        long[] jArr = new long[iZzq];
        long[] jArr2 = new long[iZzq];
        for (int i = 0; i < iZzq; i++) {
            jArr[i] = (((long) i) * jZzt) / ((long) iZzq);
            jArr2[i] = j5;
            if (iZzq3 == 1) {
                iZzm = zzenVar.zzm();
            } else if (iZzq3 == 2) {
                iZzm = zzenVar.zzq();
            } else if (iZzq3 == 3) {
                iZzm = zzenVar.zzo();
            } else {
                if (iZzq3 != 4) {
                    return null;
                }
                iZzm = zzenVar.zzp();
            }
            j5 += ((long) iZzm) * ((long) iZzq2);
        }
        long j6 = j2 + j3;
        long j7 = j4 + j6;
        if (j != -1 && j != j7) {
            zzea.zzf("VbriSeeker", "VBRI data size mismatch: " + j + ", " + j7);
        }
        if (j7 != j5) {
            zzea.zzf("VbriSeeker", "VBRI bytes and ToC mismatch (using max): " + j7 + ", " + j5 + "\nSeeking will be inaccurate.");
            jMax = Math.max(j7, j5);
        } else {
            jMax = j7;
        }
        return new zzaih(jArr, jArr2, jZzt, j6, jMax, zzaenVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final int zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzaig
    public final long zze(long j) {
        return this.zza[zzex.zzd(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final zzaes zzg(long j) {
        long[] jArr = this.zza;
        int iZzd = zzex.zzd(jArr, j, true, true);
        long j2 = jArr[iZzd];
        long[] jArr2 = this.zzb;
        zzaev zzaevVar = new zzaev(j2, jArr2[iZzd]);
        if (zzaevVar.zzb >= j || iZzd == jArr.length - 1) {
            return new zzaes(zzaevVar, zzaevVar);
        }
        int i = iZzd + 1;
        return new zzaes(zzaevVar, new zzaev(jArr[i], jArr2[i]));
    }

    @Override // com.google.android.gms.internal.ads.zzaeu
    public final boolean zzh() {
        return true;
    }
}
