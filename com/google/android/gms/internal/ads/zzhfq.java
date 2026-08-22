package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhfq extends zzgzh implements zzhat {
    private static final zzhfq zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private int zzg;
    private String zze = "";
    private zzgzp zzf = zzgzh.zzbG();
    private zzgzt zzh = zzgzh.zzbK();
    private zzgxz zzi = zzgxz.zzb;

    static {
        zzhfq zzhfqVar = new zzhfq();
        zza = zzhfqVar;
        zzgzh.zzbZ(zzhfq.class, zzhfqVar);
    }

    private zzhfq() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzhfo.class, "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzhfq();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhfp(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhfq.class) {
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
