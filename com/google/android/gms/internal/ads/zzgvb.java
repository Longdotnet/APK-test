package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgvb extends zzgzh implements zzhat {
    private static final zzgvb zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgve zze;

    static {
        zzgvb zzgvbVar = new zzgvb();
        zza = zzgvbVar;
        zzgzh.zzbZ(zzgvb.class, zzgvbVar);
    }

    private zzgvb() {
    }

    public static zzguz zzb() {
        return (zzguz) zza.zzaZ();
    }

    public static zzgvb zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgvb) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzg() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzh(zzgvb zzgvbVar, zzgve zzgveVar) {
        zzgveVar.getClass();
        zzgvbVar.zze = zzgveVar;
        zzgvbVar.zzc |= 1;
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
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgvb();
        }
        zzgva zzgvaVar = null;
        if (iOrdinal == 4) {
            return new zzguz(zzgvaVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgvb.class) {
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

    public final zzgve zzf() {
        zzgve zzgveVar = this.zze;
        return zzgveVar == null ? zzgve.zzd() : zzgveVar;
    }
}
