package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzatp extends zzgzh implements zzhat {
    private static final zzatp zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzatp zzatpVar = new zzatp();
        zza = zzatpVar;
        zzgzh.zzbZ(zzatp.class, zzatpVar);
    }

    private zzatp() {
    }

    public static zzato zza() {
        return (zzato) zza.zzaZ();
    }

    public static /* synthetic */ void zzc(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 32;
        zzatpVar.zzi = j;
    }

    public static /* synthetic */ void zzd(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 4;
        zzatpVar.zzf = j;
    }

    public static /* synthetic */ void zzf(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 1;
        zzatpVar.zzd = j;
    }

    public static /* synthetic */ void zzg(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 8;
        zzatpVar.zzg = j;
    }

    public static /* synthetic */ void zzh(zzatp zzatpVar, long j) {
        zzatpVar.zzc |= 16;
        zzatpVar.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzatp();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzato(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzatp.class) {
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
