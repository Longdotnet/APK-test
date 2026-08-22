package com.google.android.gms.internal.ads;

import androidx.loader.app.gv.DYYbQc;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgvu extends zzgzh implements zzhat {
    private static final zzgvu zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgxz zzd = zzgxz.zzb;

    static {
        zzgvu zzgvuVar = new zzgvu();
        zza = zzgvuVar;
        zzgzh.zzbZ(zzgvu.class, zzgvuVar);
    }

    private zzgvu() {
    }

    public static zzgvs zzb() {
        return (zzgvs) zza.zzaZ();
    }

    public static zzgvu zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgvu) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzg() {
        return zza.zzbN();
    }

    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzc", DYYbQc.RIvHHPVFxIKdt});
        }
        if (iOrdinal == 3) {
            return new zzgvu();
        }
        zzgvt zzgvtVar = null;
        if (iOrdinal == 4) {
            return new zzgvs(zzgvtVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgvu.class) {
                try {
                    zzgzcVar = zzb;
                    if (zzgzcVar == null) {
                        zzgzcVar = new zzgzc(zza);
                        zzb = zzgzcVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzgzcVar;
    }

    public final zzgxz zzf() {
        return this.zzd;
    }
}
