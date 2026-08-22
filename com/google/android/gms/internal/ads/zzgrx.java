package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgrx extends zzgzh implements zzhat {
    private static final zzgrx zza;
    private static volatile zzhba zzb;
    private int zzc;

    static {
        zzgrx zzgrxVar = new zzgrx();
        zza = zzgrxVar;
        zzgzh.zzbZ(zzgrx.class, zzgrxVar);
    }

    private zzgrx() {
    }

    public static zzgrv zzb() {
        return (zzgrv) zza.zzaZ();
    }

    public static zzgrx zzd() {
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
            return new zzgrx();
        }
        zzgrw zzgrwVar = null;
        if (iOrdinal == 4) {
            return new zzgrv(zzgrwVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgrx.class) {
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
