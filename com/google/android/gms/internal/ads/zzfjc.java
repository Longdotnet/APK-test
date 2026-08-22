package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfjc extends zzgzh implements zzhat {
    private static final zzfjc zza;
    private static volatile zzhba zzb;
    private zzgzt zzc = zzgzh.zzbK();

    static {
        zzfjc zzfjcVar = new zzfjc();
        zza = zzfjcVar;
        zzgzh.zzbZ(zzfjc.class, zzfjcVar);
    }

    private zzfjc() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfiz.class});
        }
        if (iOrdinal == 3) {
            return new zzfjc();
        }
        zzfjb zzfjbVar = null;
        if (iOrdinal == 4) {
            return new zzfja(zzfjbVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzfjc.class) {
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
