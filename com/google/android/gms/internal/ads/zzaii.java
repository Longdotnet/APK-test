package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzaii {
    public final zzaen zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;
    public final long[] zzf;

    private zzaii(zzaen zzaenVar, long j, long j2, long[] jArr, int i, int i2) {
        this.zza = new zzaen(zzaenVar);
        this.zzb = j;
        this.zzc = j2;
        this.zzf = jArr;
        this.zzd = i;
        this.zze = i2;
    }

    public static zzaii zzb(zzaen zzaenVar, zzen zzenVar) {
        long[] jArr;
        int i;
        int i2;
        int iZzg = zzenVar.zzg();
        int iZzp = (iZzg & 1) != 0 ? zzenVar.zzp() : -1;
        long jZzu = (iZzg & 2) != 0 ? zzenVar.zzu() : -1L;
        if ((iZzg & 4) == 4) {
            long[] jArr2 = new long[100];
            for (int i3 = 0; i3 < 100; i3++) {
                jArr2[i3] = zzenVar.zzm();
            }
            jArr = jArr2;
        } else {
            jArr = null;
        }
        if ((iZzg & 8) != 0) {
            zzenVar.zzM(4);
        }
        if (zzenVar.zza() >= 24) {
            zzenVar.zzM(21);
            int iZzo = zzenVar.zzo();
            i2 = iZzo & 4095;
            i = iZzo >> 12;
        } else {
            i = -1;
            i2 = -1;
        }
        return new zzaii(zzaenVar, iZzp, jZzu, jArr, i, i2);
    }

    public final long zza() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        zzaen zzaenVar = this.zza;
        return zzex.zzt((j * ((long) zzaenVar.zzg)) - 1, zzaenVar.zzd);
    }
}
