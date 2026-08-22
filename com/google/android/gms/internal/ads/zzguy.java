package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzguy extends zzgzh implements zzhat {
    private static final zzguy zza;
    private static volatile zzhba zzb;
    private String zzc = "";

    static {
        zzguy zzguyVar = new zzguy();
        zza = zzguyVar;
        zzgzh.zzbZ(zzguy.class, zzguyVar);
    }

    private zzguy() {
    }

    public static zzguw zza() {
        return (zzguw) zza.zzaZ();
    }

    public static zzguy zzc() {
        return zza;
    }

    public static zzguy zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzguy) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzg(zzguy zzguyVar, String str) {
        str.getClass();
        zzguyVar.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
        }
        if (iOrdinal == 3) {
            return new zzguy();
        }
        zzgux zzguxVar = null;
        if (iOrdinal == 4) {
            return new zzguw(zzguxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzguy.class) {
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

    public final String zzf() {
        return this.zzc;
    }
}
