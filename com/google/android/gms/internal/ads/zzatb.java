package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzatb extends zzgzh implements zzhat {
    private static final zzatb zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd = -1;
    private int zze = 1000;
    private int zzf = 1000;

    static {
        zzatb zzatbVar = new zzatb();
        zza = zzatbVar;
        zzgzh.zzbZ(zzatb.class, zzatbVar);
    }

    private zzatb() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zzgzn zzgznVar = zzaty.zza;
            return zzgzh.zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzc", "zzd", "zze", zzgznVar, "zzf", zzgznVar});
        }
        if (iOrdinal == 3) {
            return new zzatb();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzata(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzatb.class) {
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
