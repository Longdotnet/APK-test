package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgvx extends zzgzh implements zzhat {
    private static final zzgvx zza;
    private static volatile zzhba zzb;
    private int zzc;

    static {
        zzgvx zzgvxVar = new zzgvx();
        zza = zzgvxVar;
        zzgzh.zzbZ(zzgvx.class, zzgvxVar);
    }

    private zzgvx() {
    }

    public static zzgvx zzc() {
        return zza;
    }

    public static zzgvx zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgvx) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
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
            return zzgzh.zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
        }
        if (iOrdinal == 3) {
            return new zzgvx();
        }
        zzgvw zzgvwVar = null;
        if (iOrdinal == 4) {
            return new zzgvv(zzgvwVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgvx.class) {
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
