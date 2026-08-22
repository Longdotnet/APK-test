package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtu extends zzgzh implements zzhat {
    private static final zzgtu zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgtx zzd;
    private int zze;
    private int zzf;

    static {
        zzgtu zzgtuVar = new zzgtu();
        zza = zzgtuVar;
        zzgzh.zzbZ(zzgtu.class, zzgtuVar);
    }

    private zzgtu() {
    }

    public static zzgts zzc() {
        return (zzgts) zza.zzaZ();
    }

    public static zzgtu zzf() {
        return zza;
    }

    public static zzgtu zzg(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgtu) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzj(zzgtu zzgtuVar, zzgtx zzgtxVar) {
        zzgtxVar.getClass();
        zzgtuVar.zzd = zzgtxVar;
        zzgtuVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgtu();
        }
        zzgtt zzgttVar = null;
        if (iOrdinal == 4) {
            return new zzgts(zzgttVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgtu.class) {
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

    public final zzgtx zzh() {
        zzgtx zzgtxVar = this.zzd;
        return zzgtxVar == null ? zzgtx.zzf() : zzgtxVar;
    }
}
