package com.google.android.gms.internal.ads;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhfu extends zzgzh implements zzhat {
    private static final zzhfu zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = RDFWIi.rGDoQd;

    static {
        zzhfu zzhfuVar = new zzhfu();
        zza = zzhfuVar;
        zzgzh.zzbZ(zzhfu.class, zzhfuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhfu();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhft(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhfu.class) {
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

    private zzhfu() {
    }
}
