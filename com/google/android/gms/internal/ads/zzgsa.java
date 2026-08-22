package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsa extends zzgzh implements zzhat {
    private static final zzgsa zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgsg zze;
    private zzgtr zzf;

    static {
        zzgsa zzgsaVar = new zzgsa();
        zza = zzgsaVar;
        zzgzh.zzbZ(zzgsa.class, zzgsaVar);
    }

    private zzgsa() {
    }

    public static zzgry zzb() {
        return (zzgry) zza.zzaZ();
    }

    public static zzgsa zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgsa) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzh() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzi(zzgsa zzgsaVar, zzgsg zzgsgVar) {
        zzgsgVar.getClass();
        zzgsaVar.zze = zzgsgVar;
        zzgsaVar.zzc |= 1;
    }

    public static /* synthetic */ void zzj(zzgsa zzgsaVar, zzgtr zzgtrVar) {
        zzgtrVar.getClass();
        zzgsaVar.zzf = zzgtrVar;
        zzgsaVar.zzc |= 2;
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
            return zzgzh.zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgsa();
        }
        zzgrz zzgrzVar = null;
        if (iOrdinal == 4) {
            return new zzgry(zzgrzVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgsa.class) {
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

    public final zzgsg zzf() {
        zzgsg zzgsgVar = this.zze;
        return zzgsgVar == null ? zzgsg.zzd() : zzgsgVar;
    }

    public final zzgtr zzg() {
        zzgtr zzgtrVar = this.zzf;
        return zzgtrVar == null ? zzgtr.zzd() : zzgtrVar;
    }
}
