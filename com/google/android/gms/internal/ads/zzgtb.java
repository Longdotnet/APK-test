package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtb extends zzgzh implements zzhat {
    private static final zzgtb zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;

    static {
        zzgtb zzgtbVar = new zzgtb();
        zza = zzgtbVar;
        zzgzh.zzbZ(zzgtb.class, zzgtbVar);
    }

    private zzgtb() {
    }

    public static zzgsz zzc() {
        return (zzgsz) zza.zzaZ();
    }

    public static zzgtb zzf(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgtb) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzgtb();
        }
        zzgta zzgtaVar = null;
        if (iOrdinal == 4) {
            return new zzgsz(zzgtaVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgtb.class) {
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
