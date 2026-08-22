package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzasw extends zzgzh implements zzhat {
    private static final zzasw zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;

    static {
        zzasw zzaswVar = new zzasw();
        zza = zzaswVar;
        zzgzh.zzbZ(zzasw.class, zzaswVar);
    }

    private zzasw() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzc", "zzd", zzasz.zza});
        }
        if (iOrdinal == 3) {
            return new zzasw();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzasv(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzasw.class) {
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
