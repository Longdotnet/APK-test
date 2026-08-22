package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgth extends zzgzh implements zzhat {
    private static final zzgth zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;

    static {
        zzgth zzgthVar = new zzgth();
        zza = zzgthVar;
        zzgzh.zzbZ(zzgth.class, zzgthVar);
    }

    private zzgth() {
    }

    public static zzgtf zzc() {
        return (zzgtf) zza.zzaZ();
    }

    public static zzgth zzf(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgth) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzd", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzgth();
        }
        zzgtg zzgtgVar = null;
        if (iOrdinal == 4) {
            return new zzgtf(zzgtgVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgth.class) {
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
}
