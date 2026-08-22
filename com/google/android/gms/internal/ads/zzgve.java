package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgve extends zzgzh implements zzhat {
    private static final zzgve zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = "";
    private zzguf zze;

    static {
        zzgve zzgveVar = new zzgve();
        zza = zzgveVar;
        zzgzh.zzbZ(zzgve.class, zzgveVar);
    }

    private zzgve() {
    }

    public static zzgvc zzb() {
        return (zzgvc) zza.zzaZ();
    }

    public static zzgve zzd() {
        return zza;
    }

    public static zzgve zzf(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgve) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzh(zzgve zzgveVar, zzguf zzgufVar) {
        zzgufVar.getClass();
        zzgveVar.zze = zzgufVar;
        zzgveVar.zzc |= 1;
    }

    public static /* synthetic */ void zzi(zzgve zzgveVar, String str) {
        str.getClass();
        zzgveVar.zzd = str;
    }

    public final zzguf zza() {
        zzguf zzgufVar = this.zze;
        return zzgufVar == null ? zzguf.zzd() : zzgufVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgve();
        }
        zzgvd zzgvdVar = null;
        if (iOrdinal == 4) {
            return new zzgvc(zzgvdVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgve.class) {
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

    public final String zzg() {
        return this.zzd;
    }
}
