package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhdq extends zzgzh implements zzhat {
    private static final zzhdq zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzhdp zze;
    private long zzf;
    private String zzd = "";
    private String zzg = "";

    static {
        zzhdq zzhdqVar = new zzhdq();
        zza = zzhdqVar;
        zzgzh.zzbZ(zzhdq.class, zzhdqVar);
    }

    private zzhdq() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003ဂ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzhdq();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhdn(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhdq.class) {
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
