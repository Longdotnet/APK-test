package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfph extends zzgzh implements zzhat {
    private static final zzfph zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfpd zzg;

    static {
        zzfph zzfphVar = new zzfph();
        zza = zzfphVar;
        zzgzh.zzbZ(zzfph.class, zzfphVar);
    }

    private zzfph() {
    }

    public static zzfpe zza() {
        return (zzfpe) zza.zzaZ();
    }

    public static /* synthetic */ void zzc(zzfph zzfphVar, String str) {
        str.getClass();
        zzfphVar.zzc |= 2;
        zzfphVar.zze = str;
    }

    public static /* synthetic */ void zzd(zzfph zzfphVar, zzfpd zzfpdVar) {
        zzfpdVar.getClass();
        zzfphVar.zzg = zzfpdVar;
        zzfphVar.zzc |= 8;
    }

    public static /* synthetic */ void zzf(zzfph zzfphVar, int i) {
        zzfphVar.zzd = 1;
        zzfphVar.zzc = 1 | zzfphVar.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzfpf.zza, "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzfph();
        }
        zzfpg zzfpgVar = null;
        if (iOrdinal == 4) {
            return new zzfpe(zzfpgVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzfph.class) {
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
