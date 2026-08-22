package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhcx extends zzgzh implements zzhat {
    private static final zzhcx zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd;
    private long zze;

    static {
        zzhcx zzhcxVar = new zzhcx();
        zza = zzhcxVar;
        zzgzh.zzbZ(zzhcx.class, zzhcxVar);
    }

    private zzhcx() {
    }

    public static zzhcw zzc() {
        return (zzhcw) zza.zzaZ();
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0002\u0003\u0002", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhcx();
        }
        zzhda zzhdaVar = null;
        if (iOrdinal == 4) {
            return new zzhcw(zzhdaVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhcx.class) {
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
