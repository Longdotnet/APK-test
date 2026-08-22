package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzheu extends zzgzh implements zzhat {
    private static final zzheu zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgxz zzf;
    private zzgxz zzg;

    static {
        zzheu zzheuVar = new zzheu();
        zza = zzheuVar;
        zzgzh.zzbZ(zzheu.class, zzheuVar);
    }

    private zzheu() {
        zzgxz zzgxzVar = zzgxz.zzb;
        this.zzf = zzgxzVar;
        this.zzg = zzgxzVar;
    }

    public static zzhes zzc() {
        return (zzhes) zza.zzaZ();
    }

    public static /* synthetic */ void zzf(zzheu zzheuVar, zzgxz zzgxzVar) {
        zzgxzVar.getClass();
        zzheuVar.zzc |= 4;
        zzheuVar.zzf = zzgxzVar;
    }

    public static /* synthetic */ void zzg(zzheu zzheuVar, String str) {
        zzheuVar.zzc |= 2;
        zzheuVar.zze = "image/png";
    }

    public static /* synthetic */ void zzh(zzheu zzheuVar, int i) {
        zzheuVar.zzd = 1;
        zzheuVar.zzc = 1 | zzheuVar.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", zzhet.zza, "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzheu();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhes(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzheu.class) {
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
