package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzauh extends zzgzh implements zzhat {
    private static final zzauh zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgzt zzd = zzgzh.zzbK();
    private zzgxz zze = zzgxz.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzauh zzauhVar = new zzauh();
        zza = zzauhVar;
        zzgzh.zzbZ(zzauh.class, zzauhVar);
    }

    private zzauh() {
    }

    public static zzaug zza() {
        return (zzaug) zza.zzaZ();
    }

    public static /* synthetic */ void zzc(zzauh zzauhVar, zzgxz zzgxzVar) {
        zzgzt zzgztVar = zzauhVar.zzd;
        if (!zzgztVar.zzc()) {
            zzauhVar.zzd = zzgzh.zzbL(zzgztVar);
        }
        zzauhVar.zzd.add(zzgxzVar);
    }

    public static /* synthetic */ void zzd(zzauh zzauhVar, zzgxz zzgxzVar) {
        zzauhVar.zzc |= 1;
        zzauhVar.zze = zzgxzVar;
    }

    public static /* synthetic */ void zzf(zzauh zzauhVar, int i) {
        zzauhVar.zzg = i - 1;
        zzauhVar.zzc |= 4;
    }

    public static /* synthetic */ void zzg(zzauh zzauhVar, int i) {
        zzauhVar.zzf = 4;
        zzauhVar.zzc |= 2;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzaub.zza, "zzg", zzatx.zza});
        }
        if (iOrdinal == 3) {
            return new zzauh();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzaug(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzauh.class) {
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
