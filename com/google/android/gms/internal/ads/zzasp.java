package com.google.android.gms.internal.ads;

import androidx.loader.app.gv.DYYbQc;

/* JADX INFO: loaded from: classes2.dex */
public final class zzasp extends zzgzh implements zzhat {
    private static final zzasp zza;
    private static volatile zzhba zzb;
    private int zzc;
    private boolean zzd;
    private int zze = 5000;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        zzasp zzaspVar = new zzasp();
        zza = zzaspVar;
        zzgzh.zzbZ(zzasp.class, zzaspVar);
    }

    private zzasp() {
    }

    public static zzasp zzc() {
        return zza;
    }

    public final int zza() {
        return this.zze;
    }

    public final boolean zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0003င\u0001\u0004ဇ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"zzc", "zzd", DYYbQc.bGmLZUkSfjQhWrB, "zzf", "zzg", "zzh"});
        }
        if (iOrdinal == 3) {
            return new zzasp();
        }
        zzaso zzasoVar = null;
        if (iOrdinal == 4) {
            return new zzasn(zzasoVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzasp.class) {
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

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return this.zzf;
    }

    public final boolean zzh() {
        return this.zzh;
    }
}
