package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfim extends zzgzh implements zzhat {
    private static final zzfim zza;
    private static volatile zzhba zzb;
    private String zzc = "";
    private int zzd;

    static {
        zzfim zzfimVar = new zzfim();
        zza = zzfimVar;
        zzgzh.zzbZ(zzfim.class, zzfimVar);
    }

    private zzfim() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\u0004", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzfim();
        }
        zzfil zzfilVar = null;
        if (iOrdinal == 4) {
            return new zzfik(zzfilVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzfim.class) {
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
