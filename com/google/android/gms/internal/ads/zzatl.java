package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzatl extends zzgzh implements zzhat {
    private static final zzatl zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd = -1;
    private int zze = 1000;

    static {
        zzatl zzatlVar = new zzatl();
        zza = zzatlVar;
        zzgzh.zzbZ(zzatl.class, zzatlVar);
    }

    private zzatl() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zzc", "zzd", "zze", zzaty.zza});
        }
        if (iOrdinal == 3) {
            return new zzatl();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzatk(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzatl.class) {
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
