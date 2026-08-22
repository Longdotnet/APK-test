package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsv extends zzgzh implements zzhat {
    private static final zzgsv zza;
    private static volatile zzhba zzb;
    private int zzc;

    static {
        zzgsv zzgsvVar = new zzgsv();
        zza = zzgsvVar;
        zzgzh.zzbZ(zzgsv.class, zzgsvVar);
    }

    private zzgsv() {
    }

    public static zzgst zzb() {
        return (zzgst) zza.zzaZ();
    }

    public static zzgsv zzd() {
        return zza;
    }

    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
        }
        if (iOrdinal == 3) {
            return new zzgsv();
        }
        zzgsu zzgsuVar = null;
        if (iOrdinal == 4) {
            return new zzgst(zzgsuVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgsv.class) {
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
