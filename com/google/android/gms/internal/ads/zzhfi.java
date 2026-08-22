package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhfi extends zzgzh implements zzhat {
    private static final zzhfi zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = "";
    private zzgxz zze = zzgxz.zzb;

    static {
        zzhfi zzhfiVar = new zzhfi();
        zza = zzhfiVar;
        zzgzh.zzbZ(zzhfi.class, zzhfiVar);
    }

    private zzhfi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ည\u0001", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhfi();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhfh(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhfi.class) {
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
