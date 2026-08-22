package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhdi extends zzgzh implements zzhat {
    private static final zzhdi zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private boolean zzv;
    private long zzw;
    private boolean zzy;
    private String zzf = "";
    private zzgzt zzg = zzgzh.zzbK();
    private String zzl = "";
    private zzgzt zzu = zzgzh.zzbK();
    private zzgzp zzx = zzgzh.zzbG();
    private zzgzp zzz = zzgzh.zzbG();

    static {
        zzhdi zzhdiVar = new zzhdi();
        zza = zzhdiVar;
        zzgzh.zzbZ(zzhdi.class, zzhdiVar);
    }

    private zzhdi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0004\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005᠌\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006\tဈ\u0007\nင\b\u000bင\t\fင\n\rဇ\u000b\u000e\u001b\u000fဇ\f\u0010ဂ\r\u0011ࠬ\u0012ဇ\u000e\u0013ࠬ", new Object[]{"zzc", "zzd", zzhdh.zza, "zze", "zzf", "zzg", "zzh", zzhdf.zza, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", zzhde.class, "zzv", "zzw", "zzx", zzhcv.zza(), "zzy", "zzz", zzhdg.zza});
        }
        if (iOrdinal == 3) {
            return new zzhdi();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhdb(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhdi.class) {
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
