package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtn extends zzgzh implements zzhat {
    private static final zzgtn zza;
    private static volatile zzhba zzb;

    static {
        zzgtn zzgtnVar = new zzgtn();
        zza = zzgtnVar;
        zzgzh.zzbZ(zzgtn.class, zzgtnVar);
    }

    private zzgtn() {
    }

    public static zzgtn zzb() {
        return zza;
    }

    public static zzgtn zzc(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgtn) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        zzgtm zzgtmVar = null;
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0000", null);
        }
        if (iOrdinal == 3) {
            return new zzgtn();
        }
        if (iOrdinal == 4) {
            return new zzgtl(zzgtmVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgtn.class) {
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
