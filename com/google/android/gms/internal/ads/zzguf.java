package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzguf extends zzgzh implements zzhat {
    private static final zzguf zza;
    private static volatile zzhba zzb;
    private String zzc = "";
    private zzgxz zzd = zzgxz.zzb;
    private int zze;

    static {
        zzguf zzgufVar = new zzguf();
        zza = zzgufVar;
        zzgzh.zzbZ(zzguf.class, zzgufVar);
    }

    private zzguf() {
    }

    public static zzgud zza() {
        return (zzgud) zza.zzaZ();
    }

    public static zzgud zzb(zzguf zzgufVar) {
        return (zzgud) zza.zzba(zzgufVar);
    }

    public static zzguf zzd() {
        return zza;
    }

    public static zzguf zzf(byte[] bArr, zzgyr zzgyrVar) {
        return (zzguf) zzgzh.zzbx(zza, bArr, zzgyrVar);
    }

    public static /* synthetic */ void zzk(zzguf zzgufVar, String str) {
        str.getClass();
        zzgufVar.zzc = str;
    }

    public static /* synthetic */ void zzl(zzguf zzgufVar, zzgxz zzgxzVar) {
        zzgxzVar.getClass();
        zzgufVar.zzd = zzgxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzguf();
        }
        zzgue zzgueVar = null;
        if (iOrdinal == 4) {
            return new zzgud(zzgueVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzguf.class) {
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

    public final zzgvf zzg() {
        zzgvf zzgvfVarZzb = zzgvf.zzb(this.zze);
        return zzgvfVarZzb == null ? zzgvf.UNRECOGNIZED : zzgvfVarZzb;
    }

    public final zzgxz zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zzc;
    }
}
