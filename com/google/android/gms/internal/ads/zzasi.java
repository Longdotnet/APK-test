package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzasi extends zzgzh implements zzhat {
    private static final zzasi zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd = 2;

    static {
        zzasi zzasiVar = new zzasi();
        zza = zzasiVar;
        zzgzh.zzbZ(zzasi.class, zzasiVar);
    }

    private zzasi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b᠌\u0000", new Object[]{"zzc", "zzd", zzasj.zza});
        }
        if (iOrdinal == 3) {
            return new zzasi();
        }
        zzasm zzasmVar = null;
        if (iOrdinal == 4) {
            return new zzash(zzasmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzasi.class) {
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
