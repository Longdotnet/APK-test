package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjl extends zzgzh implements zzhat {
    private static final zzfjl zza;
    private static volatile zzhba zzb;
    private long zzc;
    private long zzd;
    private zzgzt zze = zzgzh.zzbK();

    static {
        zzfjl zzfjlVar = new zzfjl();
        zza = zzfjlVar;
        zzgzh.zzbZ(zzfjl.class, zzfjlVar);
    }

    private zzfjl() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u0002\u0002\u0002\u0003Ț", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzfjl();
        }
        zzfjk zzfjkVar = null;
        if (iOrdinal == 4) {
            return new zzfjj(zzfjkVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzfjl.class) {
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
