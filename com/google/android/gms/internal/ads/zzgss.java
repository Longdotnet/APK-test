package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgss extends zzgzh implements zzhat {
    private static final zzgss zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgsv zzd;
    private int zze;

    static {
        zzgss zzgssVar = new zzgss();
        zza = zzgssVar;
        zzgzh.zzbZ(zzgss.class, zzgssVar);
    }

    private zzgss() {
    }

    public static zzgsq zzb() {
        return (zzgsq) zza.zzaZ();
    }

    public static zzgss zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgss) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzh(zzgss zzgssVar, zzgsv zzgsvVar) {
        zzgsvVar.getClass();
        zzgssVar.zzd = zzgsvVar;
        zzgssVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgss();
        }
        zzgsr zzgsrVar = null;
        if (iOrdinal == 4) {
            return new zzgsq(zzgsrVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgss.class) {
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

    public final zzgsv zzf() {
        zzgsv zzgsvVar = this.zzd;
        return zzgsvVar == null ? zzgsv.zzd() : zzgsvVar;
    }
}
