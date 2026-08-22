package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgvl extends zzgzh implements zzhat {
    private static final zzgvl zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgvr zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzgvl zzgvlVar = new zzgvl();
        zza = zzgvlVar;
        zzgzh.zzbZ(zzgvl.class, zzgvlVar);
    }

    private zzgvl() {
    }

    public static zzgvj zzb() {
        return (zzgvj) zza.zzaZ();
    }

    public static zzgvl zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgvl) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzi(zzgvl zzgvlVar, zzgvr zzgvrVar) {
        zzgvrVar.getClass();
        zzgvlVar.zze = zzgvrVar;
        zzgvlVar.zzc |= 1;
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
            return new zzgvl();
        }
        zzgvk zzgvkVar = null;
        if (iOrdinal == 4) {
            return new zzgvj(zzgvkVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgvl.class) {
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

    public final zzgvr zzf() {
        zzgvr zzgvrVar = this.zze;
        return zzgvrVar == null ? zzgvr.zzd() : zzgvrVar;
    }

    public final zzgxz zzg() {
        return this.zzf;
    }
}
