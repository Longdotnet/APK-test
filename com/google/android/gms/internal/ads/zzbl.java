package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbl {
    public static final zzbl zza = new zzbi();

    static {
        String str = zzex.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
    }

    public final boolean equals(Object obj) {
        int iZzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbl)) {
            return false;
        }
        zzbl zzblVar = (zzbl) obj;
        if (zzblVar.zzc() == zzc() && zzblVar.zzb() == zzb()) {
            zzbk zzbkVar = new zzbk();
            zzbj zzbjVar = new zzbj();
            zzbk zzbkVar2 = new zzbk();
            zzbj zzbjVar2 = new zzbj();
            for (int i = 0; i < zzc(); i++) {
                if (!zze(i, zzbkVar, 0L).equals(zzblVar.zze(i, zzbkVar2, 0L))) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < zzb(); i2++) {
                if (!zzd(i2, zzbjVar, true).equals(zzblVar.zzd(i2, zzbjVar2, true))) {
                    return false;
                }
            }
            int iZzg = zzg(true);
            if (iZzg == zzblVar.zzg(true) && (iZzh = zzh(true)) == zzblVar.zzh(true)) {
                while (iZzg != iZzh) {
                    int iZzj = zzj(iZzg, 0, true);
                    if (iZzj != zzblVar.zzj(iZzg, 0, true)) {
                        return false;
                    }
                    iZzg = iZzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        zzbk zzbkVar = new zzbk();
        zzbj zzbjVar = new zzbj();
        int iZzc = zzc() + 217;
        int i2 = 0;
        while (true) {
            i = iZzc * 31;
            if (i2 >= zzc()) {
                break;
            }
            iZzc = i + zze(i2, zzbkVar, 0L).hashCode();
            i2++;
        }
        int iZzb = zzb() + i;
        for (int i3 = 0; i3 < zzb(); i3++) {
            iZzb = (iZzb * 31) + zzd(i3, zzbjVar, true).hashCode();
        }
        int iZzg = zzg(true);
        while (iZzg != -1) {
            iZzb = (iZzb * 31) + iZzg;
            iZzg = zzj(iZzg, 0, true);
        }
        return iZzb;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzbj zzd(int i, zzbj zzbjVar, boolean z);

    public abstract zzbk zze(int i, zzbk zzbkVar, long j);

    public abstract Object zzf(int i);

    public int zzg(boolean z) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i, zzbj zzbjVar, zzbk zzbkVar, int i2, boolean z) {
        int i3 = zzd(i, zzbjVar, false).zzc;
        if (zze(i3, zzbkVar, 0L).zzo != i) {
            return i + 1;
        }
        int iZzj = zzj(i3, i2, z);
        if (iZzj == -1) {
            return -1;
        }
        return zze(iZzj, zzbkVar, 0L).zzn;
    }

    public int zzj(int i, int i2, boolean z) {
        if (i2 == 0) {
            if (i == zzh(z)) {
                return -1;
            }
            return i + 1;
        }
        if (i2 == 1) {
            return i;
        }
        if (i2 == 2) {
            return i == zzh(z) ? zzg(z) : i + 1;
        }
        throw new IllegalStateException();
    }

    public int zzk(int i, int i2, boolean z) {
        if (i == zzg(false)) {
            return -1;
        }
        return i - 1;
    }

    public final Pair zzl(zzbk zzbkVar, zzbj zzbjVar, int i, long j) {
        Pair pairZzm = zzm(zzbkVar, zzbjVar, i, j, 0L);
        pairZzm.getClass();
        return pairZzm;
    }

    public final Pair zzm(zzbk zzbkVar, zzbj zzbjVar, int i, long j, long j2) {
        zzdd.zza(i, 0, zzc());
        zze(i, zzbkVar, j2);
        if (j == -9223372036854775807L) {
            long j3 = zzbkVar.zzl;
            j = 0;
        }
        int i2 = zzbkVar.zzn;
        zzd(i2, zzbjVar, false);
        while (i2 < zzbkVar.zzo) {
            long j4 = zzbjVar.zze;
            if (j == 0) {
                break;
            }
            int i3 = i2 + 1;
            long j5 = zzd(i3, zzbjVar, false).zze;
            if (j < 0) {
                break;
            }
            i2 = i3;
        }
        zzd(i2, zzbjVar, true);
        long j6 = zzbjVar.zze;
        long j7 = zzbjVar.zzd;
        if (j7 != -9223372036854775807L) {
            j = Math.min(j, j7 - 1);
        }
        long jMax = Math.max(0L, j);
        Object obj = zzbjVar.zzb;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(jMax));
    }

    public zzbj zzn(Object obj, zzbj zzbjVar) {
        return zzd(zza(obj), zzbjVar, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
