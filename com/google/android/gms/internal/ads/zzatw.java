package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzatw extends zzgzh implements zzhat {
    private static final zzatw zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd;
    private long zze;
    private long zzf;

    static {
        zzatw zzatwVar = new zzatw();
        zza = zzatwVar;
        zzgzh.zzbZ(zzatw.class, zzatwVar);
    }

    private zzatw() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzc", "zzd", JuorMn.uDkSlp, "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzatw();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzatv(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzatw.class) {
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
