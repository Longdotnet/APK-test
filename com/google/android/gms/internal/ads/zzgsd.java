package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsd extends zzgzh implements zzhat {
    private static final zzgsd zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgsj zzd;
    private zzgtu zze;

    static {
        zzgsd zzgsdVar = new zzgsd();
        zza = zzgsdVar;
        zzgzh.zzbZ(zzgsd.class, zzgsdVar);
    }

    private zzgsd() {
    }

    public static zzgsb zza() {
        return (zzgsb) zza.zzaZ();
    }

    public static zzgsd zzc(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgsd) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzg(zzgsd zzgsdVar, zzgsj zzgsjVar) {
        zzgsjVar.getClass();
        zzgsdVar.zzd = zzgsjVar;
        zzgsdVar.zzc |= 1;
    }

    public static /* synthetic */ void zzh(zzgsd zzgsdVar, zzgtu zzgtuVar) {
        zzgtuVar.getClass();
        zzgsdVar.zze = zzgtuVar;
        zzgsdVar.zzc |= 2;
    }

    public final zzgsj zzd() {
        zzgsj zzgsjVar = this.zzd;
        return zzgsjVar == null ? zzgsj.zzd() : zzgsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgsd();
        }
        zzgsc zzgscVar = null;
        if (iOrdinal == 4) {
            return new zzgsb(zzgscVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgsd.class) {
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

    public final zzgtu zzf() {
        zzgtu zzgtuVar = this.zze;
        return zzgtuVar == null ? zzgtu.zzf() : zzgtuVar;
    }
}
