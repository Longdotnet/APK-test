package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhff extends zzgzh implements zzhat {
    private static final zzhff zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzhff zzhffVar = new zzhff();
        zza = zzhffVar;
        zzgzh.zzbZ(zzhff.class, zzhffVar);
    }

    private zzhff() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zzgzn zzgznVar = zzhfe.zza;
            return zzgzh.zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzc", "zzd", zzgznVar, "zze", zzgznVar});
        }
        if (iOrdinal == 3) {
            return new zzhff();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhfd(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhff.class) {
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
