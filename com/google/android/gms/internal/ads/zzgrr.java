package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrr extends zzgzh implements zzhat {
    private static final zzgrr zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgxz zze = zzgxz.zzb;
    private zzgrx zzf;

    static {
        zzgrr zzgrrVar = new zzgrr();
        zza = zzgrrVar;
        zzgzh.zzbZ(zzgrr.class, zzgrrVar);
    }

    private zzgrr() {
    }

    public static zzgrp zzb() {
        return (zzgrp) zza.zzaZ();
    }

    public static zzgrr zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgrr) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzh() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzj(zzgrr zzgrrVar, zzgrx zzgrxVar) {
        zzgrxVar.getClass();
        zzgrrVar.zzf = zzgrxVar;
        zzgrrVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgrr();
        }
        zzgrq zzgrqVar = null;
        if (iOrdinal == 4) {
            return new zzgrp(zzgrqVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgrr.class) {
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

    public final zzgrx zzf() {
        zzgrx zzgrxVar = this.zzf;
        return zzgrxVar == null ? zzgrx.zzd() : zzgrxVar;
    }

    public final zzgxz zzg() {
        return this.zze;
    }
}
