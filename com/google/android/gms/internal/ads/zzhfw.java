package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhfw extends zzgzh implements zzhat {
    private static final zzhfw zza;
    private static volatile zzhba zzb;
    private int zzc;
    private boolean zzj;
    private double zzk;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzu;
    private String zzd = "";
    private String zze = "";
    private int zzf = 4;
    private zzgzt zzg = zzgzh.zzbK();
    private String zzh = "";
    private String zzi = "";
    private zzgzt zzl = zzgzh.zzbK();

    static {
        zzhfw zzhfwVar = new zzhfw();
        zza = zzhfwVar;
        zzgzh.zzbZ(zzhfw.class, zzhfwVar);
    }

    private zzhfw() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zzc", "zzd", "zzf", zzhfv.zza, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzhfu.class, "zze", "zzm", zzhfs.zza, "zzn", "zzo", "zzp", "zzu"});
        }
        if (iOrdinal == 3) {
            return new zzhfw();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhfr(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhfw.class) {
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
