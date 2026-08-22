package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgte extends zzgzh implements zzhat {
    private static final zzgte zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgxz zzd = zzgxz.zzb;

    static {
        zzgte zzgteVar = new zzgte();
        zza = zzgteVar;
        zzgzh.zzbZ(zzgte.class, zzgteVar);
    }

    private zzgte() {
    }

    public static zzgtc zzb() {
        return (zzgtc) zza.zzaZ();
    }

    public static zzgte zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgte) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
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
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzgte();
        }
        zzgtd zzgtdVar = null;
        if (iOrdinal == 4) {
            return new zzgtc(zzgtdVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgte.class) {
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
