package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzatj extends zzgzh implements zzhat {
    private static final zzatj zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;

    static {
        zzatj zzatjVar = new zzatj();
        zza = zzatjVar;
        zzgzh.zzbZ(zzatj.class, zzatjVar);
    }

    private zzatj() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzatj();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzati(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzatj.class) {
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
