package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzass extends zzgzh implements zzhat {
    public static final /* synthetic */ int zza = 0;
    private static final zzass zzb;
    private static volatile zzhba zzc;
    private int zzd;
    private boolean zzf;
    private boolean zzg;
    private long zze = 100;
    private long zzh = 300;
    private long zzi = 1000;

    static {
        zzass zzassVar = new zzass();
        zzb = zzassVar;
        zzgzh.zzbZ(zzass.class, zzassVar);
    }

    private zzass() {
    }

    public static zzass zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005ဂ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzass();
        }
        zzasr zzasrVar = null;
        if (iOrdinal == 4) {
            return new zzasq(zzasrVar);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzc;
        if (zzgzcVar == null) {
            synchronized (zzass.class) {
                try {
                    zzgzcVar = zzc;
                    if (zzgzcVar == null) {
                        zzgzcVar = new zzgzc(zzb);
                        zzc = zzgzcVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzgzcVar;
    }
}
