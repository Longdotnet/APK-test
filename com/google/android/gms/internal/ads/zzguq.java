package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzguq extends zzgzh implements zzhat {
    private static final zzguq zza;
    private static volatile zzhba zzb;
    private String zzc = "";
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzguq zzguqVar = new zzguq();
        zza = zzguqVar;
        zzgzh.zzbZ(zzguq.class, zzguqVar);
    }

    private zzguq() {
    }

    public static zzgup zza() {
        return (zzgup) zza.zzaZ();
    }

    public static /* synthetic */ void zzf(zzguq zzguqVar, String str) {
        str.getClass();
        zzguqVar.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzguq();
        }
        zzgur zzgurVar = null;
        if (iOrdinal == 4) {
            return new zzgup(zzgurVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzguq.class) {
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
