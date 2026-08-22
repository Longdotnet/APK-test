package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhdm extends zzgzh implements zzhat {
    private static final zzhdm zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = "";

    static {
        zzhdm zzhdmVar = new zzhdm();
        zza = zzhdmVar;
        zzgzh.zzbZ(zzhdm.class, zzhdmVar);
    }

    private zzhdm() {
    }

    public static zzhdl zzc() {
        return (zzhdl) zza.zzaZ();
    }

    public static /* synthetic */ void zzf(zzhdm zzhdmVar, String str) {
        zzhdmVar.zzc |= 1;
        zzhdmVar.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhdm();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhdl(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhdm.class) {
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
