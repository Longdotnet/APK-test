package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzatu extends zzgzh implements zzhat {
    private static final zzatu zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgxz zzd;
    private zzgxz zze;
    private zzgxz zzf;
    private zzgxz zzg;

    static {
        zzatu zzatuVar = new zzatu();
        zza = zzatuVar;
        zzgzh.zzbZ(zzatu.class, zzatuVar);
    }

    private zzatu() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zzd = zzgxzVar;
        this.zze = zzgxzVar;
        this.zzf = zzgxzVar;
        this.zzg = zzgxzVar;
    }

    public static zzatt zza() {
        return (zzatt) zza.zzaZ();
    }

    public static zzatu zzc(byte[] bArr, zzgyr zzgyrVar) {
        return (zzatu) zzgzh.zzbx(zza, bArr, zzgyrVar);
    }

    public static /* synthetic */ void zzi(zzatu zzatuVar, zzgxz zzgxzVar) {
        zzatuVar.zzc |= 1;
        zzatuVar.zzd = zzgxzVar;
    }

    public static /* synthetic */ void zzj(zzatu zzatuVar, zzgxz zzgxzVar) {
        zzatuVar.zzc |= 2;
        zzatuVar.zze = zzgxzVar;
    }

    public static /* synthetic */ void zzk(zzatu zzatuVar, zzgxz zzgxzVar) {
        zzatuVar.zzc |= 8;
        zzatuVar.zzg = zzgxzVar;
    }

    public static /* synthetic */ void zzl(zzatu zzatuVar, zzgxz zzgxzVar) {
        zzatuVar.zzc |= 4;
        zzatuVar.zzf = zzgxzVar;
    }

    public final zzgxz zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzatu();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzatt(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzatu.class) {
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

    public final zzgxz zzf() {
        return this.zze;
    }

    public final zzgxz zzg() {
        return this.zzg;
    }

    public final zzgxz zzh() {
        return this.zzf;
    }
}
