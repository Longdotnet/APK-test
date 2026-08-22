package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgub extends zzgzh implements zzhat {
    private static final zzgub zza;
    private static volatile zzhba zzb;
    private String zzc = "";
    private zzgxz zzd = zzgxz.zzb;
    private int zze;

    static {
        zzgub zzgubVar = new zzgub();
        zza = zzgubVar;
        zzgzh.zzbZ(zzgub.class, zzgubVar);
    }

    private zzgub() {
    }

    public static zzgty zza() {
        return (zzgty) zza.zzaZ();
    }

    public static zzgub zzd() {
        return zza;
    }

    public static /* synthetic */ void zzi(zzgub zzgubVar, String str) {
        str.getClass();
        zzgubVar.zzc = str;
    }

    public static /* synthetic */ void zzj(zzgub zzgubVar, zzgxz zzgxzVar) {
        zzgxzVar.getClass();
        zzgubVar.zzd = zzgxzVar;
    }

    public final zzgtz zzb() {
        zzgtz zzgtzVar;
        int i = this.zze;
        if (i == 0) {
            zzgtzVar = zzgtz.UNKNOWN_KEYMATERIAL;
        } else if (i == 1) {
            zzgtzVar = zzgtz.SYMMETRIC;
        } else if (i == 2) {
            zzgtzVar = zzgtz.ASYMMETRIC_PRIVATE;
        } else if (i != 3) {
            zzgtzVar = i != 4 ? null : zzgtz.REMOTE;
        } else {
            zzgtzVar = zzgtz.ASYMMETRIC_PUBLIC;
        }
        return zzgtzVar == null ? zzgtz.UNRECOGNIZED : zzgtzVar;
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
            return new zzgub();
        }
        zzgua zzguaVar = null;
        if (iOrdinal == 4) {
            return new zzgty(zzguaVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgub.class) {
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

    public final zzgxz zzf() {
        return this.zzd;
    }

    public final String zzg() {
        return this.zzc;
    }
}
