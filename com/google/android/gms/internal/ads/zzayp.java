package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzayp extends zzgzh implements zzhat {
    private static final zzayp zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzays zzd;
    private zzgxz zze;
    private zzgxz zzf;

    static {
        zzayp zzaypVar = new zzayp();
        zza = zzaypVar;
        zzgzh.zzbZ(zzayp.class, zzaypVar);
    }

    private zzayp() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zze = zzgxzVar;
        this.zzf = zzgxzVar;
    }

    public static zzayp zzb(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzayp) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public final zzays zzc() {
        zzays zzaysVar = this.zzd;
        return zzaysVar == null ? zzays.zzg() : zzaysVar;
    }

    public final zzgxz zzd() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzayp();
        }
        zzayo zzayoVar = null;
        if (iOrdinal == 4) {
            return new zzayn(zzayoVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzayp.class) {
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
        return this.zze;
    }
}
