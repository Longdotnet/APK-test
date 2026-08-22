package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsp extends zzgzh implements zzhat {
    private static final zzgsp zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgsv zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzgsp zzgspVar = new zzgsp();
        zza = zzgspVar;
        zzgzh.zzbZ(zzgsp.class, zzgspVar);
    }

    private zzgsp() {
    }

    public static zzgsn zzb() {
        return (zzgsn) zza.zzaZ();
    }

    public static zzgsp zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgsp) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzh() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzj(zzgsp zzgspVar, zzgsv zzgsvVar) {
        zzgsvVar.getClass();
        zzgspVar.zze = zzgsvVar;
        zzgspVar.zzc |= 1;
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
            return zzgzh.zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgsp();
        }
        zzgso zzgsoVar = null;
        if (iOrdinal == 4) {
            return new zzgsn(zzgsoVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgsp.class) {
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

    public final zzgsv zzf() {
        zzgsv zzgsvVar = this.zze;
        return zzgsvVar == null ? zzgsv.zzd() : zzgsvVar;
    }

    public final zzgxz zzg() {
        return this.zzf;
    }
}
