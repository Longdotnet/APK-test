package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzath extends zzgzh implements zzhat {
    private static final zzath zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private long zze = -1;

    static {
        zzath zzathVar = new zzath();
        zza = zzathVar;
        zzgzh.zzbZ(zzath.class, zzathVar);
    }

    private zzath() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", zzasx.zza, "zze"});
        }
        if (iOrdinal == 3) {
            return new zzath();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzatg(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzath.class) {
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
