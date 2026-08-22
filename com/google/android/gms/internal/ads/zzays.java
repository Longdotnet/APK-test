package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzays extends zzgzh implements zzhat {
    private static final zzays zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzays zzaysVar = new zzays();
        zza = zzaysVar;
        zzgzh.zzbZ(zzays.class, zzaysVar);
    }

    private zzays() {
    }

    public static zzayq zzd() {
        return (zzayq) zza.zzaZ();
    }

    public static zzays zzg() {
        return zza;
    }

    public static zzays zzh(zzgxz zzgxzVar) {
        return (zzays) zzgzh.zzbm(zza, zzgxzVar);
    }

    public static zzays zzi(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzays) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzl(zzays zzaysVar, String str) {
        str.getClass();
        zzaysVar.zzc |= 2;
        zzaysVar.zze = str;
    }

    public static /* synthetic */ void zzm(zzays zzaysVar, long j) {
        zzaysVar.zzc |= 8;
        zzaysVar.zzg = j;
    }

    public static /* synthetic */ void zzn(zzays zzaysVar, long j) {
        zzaysVar.zzc |= 4;
        zzaysVar.zzf = j;
    }

    public static /* synthetic */ void zzo(zzays zzaysVar, long j) {
        zzaysVar.zzc |= 16;
        zzaysVar.zzh = j;
    }

    public static /* synthetic */ void zzp(zzays zzaysVar, String str) {
        str.getClass();
        zzaysVar.zzc |= 1;
        zzaysVar.zzd = str;
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final long zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzays();
        }
        zzayr zzayrVar = null;
        if (iOrdinal == 4) {
            return new zzayq(zzayrVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzays.class) {
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

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
