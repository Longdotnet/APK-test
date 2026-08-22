package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzats extends zzgzh implements zzhat {
    private static final zzats zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd;
    private int zze;
    private boolean zzf;
    private long zzh;
    private boolean zzi;
    private int zzk;
    private int zzl;
    private int zzm;
    private zzgzp zzg = zzgzh.zzbG();
    private zzgzt zzj = zzgzh.zzbK();

    static {
        zzats zzatsVar = new zzats();
        zza = zzatsVar;
        zzgzh.zzbZ(zzats.class, zzatsVar);
    }

    private zzats() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0002\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003\u0006ဇ\u0004\u0007\u001b\b᠌\u0005\t᠌\u0006\n᠌\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzatw.class, "zzk", zzfus.zza(), "zzl", zzhcq.zza(), "zzm", zzhco.zza()});
        }
        if (iOrdinal == 3) {
            return new zzats();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzatr(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzats.class) {
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
