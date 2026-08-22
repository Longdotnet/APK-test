package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhde extends zzgzh implements zzhat {
    private static final zzhde zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private long zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzhde zzhdeVar = new zzhde();
        zza = zzhdeVar;
        zzgzh.zzbZ(zzhde.class, zzhdeVar);
    }

    private zzhde() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", zzhdd.zza, "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzhde();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhdc(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhde.class) {
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
