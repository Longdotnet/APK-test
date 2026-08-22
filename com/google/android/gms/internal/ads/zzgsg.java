package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsg extends zzgzh implements zzhat {
    private static final zzgsg zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgsm zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzgsg zzgsgVar = new zzgsg();
        zza = zzgsgVar;
        zzgzh.zzbZ(zzgsg.class, zzgsgVar);
    }

    private zzgsg() {
    }

    public static zzgse zzb() {
        return (zzgse) zza.zzaZ();
    }

    public static zzgsg zzd() {
        return zza;
    }

    public static /* synthetic */ void zzi(zzgsg zzgsgVar, zzgsm zzgsmVar) {
        zzgsmVar.getClass();
        zzgsgVar.zze = zzgsmVar;
        zzgsgVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzgsg();
        }
        zzgsf zzgsfVar = null;
        if (iOrdinal == 4) {
            return new zzgse(zzgsfVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgsg.class) {
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

    public final zzgsm zzf() {
        zzgsm zzgsmVar = this.zze;
        return zzgsmVar == null ? zzgsm.zzd() : zzgsmVar;
    }

    public final zzgxz zzg() {
        return this.zzf;
    }
}
