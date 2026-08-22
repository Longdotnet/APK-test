package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfie extends zzgzh implements zzhat {
    private static final zzfie zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzfib zzd;

    static {
        zzfie zzfieVar = new zzfie();
        zza = zzfieVar;
        zzgzh.zzbZ(zzfie.class, zzfieVar);
    }

    private zzfie() {
    }

    public static zzfid zza() {
        return (zzfid) zza.zzaZ();
    }

    public static /* synthetic */ void zzc(zzfie zzfieVar, zzfib zzfibVar) {
        zzfibVar.getClass();
        zzfieVar.zzd = zzfibVar;
        zzfieVar.zzc |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzfie();
        }
        zzfif zzfifVar = null;
        if (iOrdinal == 4) {
            return new zzfid(zzfifVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzfie.class) {
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
