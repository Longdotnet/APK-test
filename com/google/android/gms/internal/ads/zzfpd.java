package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfpd extends zzgzh implements zzhat {
    private static final zzfpd zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgzp zzd = zzgzh.zzbG();
    private String zze = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzfpd zzfpdVar = new zzfpd();
        zza = zzfpdVar;
        zzgzh.zzbZ(zzfpd.class, zzfpdVar);
    }

    private zzfpd() {
    }

    public static zzfpb zza() {
        return (zzfpb) zza.zzaZ();
    }

    public static /* synthetic */ void zzc(zzfpd zzfpdVar, String str) {
        str.getClass();
        zzfpdVar.zzc |= 1;
        zzfpdVar.zze = str;
    }

    public static /* synthetic */ void zzd(zzfpd zzfpdVar, int i) {
        zzgzp zzgzpVar = zzfpdVar.zzd;
        if (!zzgzpVar.zzc()) {
            zzfpdVar.zzd = zzgzh.zzbH(zzgzpVar);
        }
        zzfpdVar.zzd.zzi(2);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzc", "zzd", zzfpa.zza, "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzfpd();
        }
        zzfpc zzfpcVar = null;
        if (iOrdinal == 4) {
            return new zzfpb(zzfpcVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzfpd.class) {
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
