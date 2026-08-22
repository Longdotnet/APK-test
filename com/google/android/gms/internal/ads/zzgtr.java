package com.google.android.gms.internal.ads;

import androidx.loader.app.gv.DYYbQc;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgtr extends zzgzh implements zzhat {
    private static final zzgtr zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgtx zze;
    private zzgxz zzf = zzgxz.zzb;

    static {
        zzgtr zzgtrVar = new zzgtr();
        zza = zzgtrVar;
        zzgzh.zzbZ(zzgtr.class, zzgtrVar);
    }

    private zzgtr() {
    }

    public static zzgtp zzb() {
        return (zzgtp) zza.zzaZ();
    }

    public static zzgtr zzd() {
        return zza;
    }

    public static zzgtr zzf(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgtr) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzi() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzk(zzgtr zzgtrVar, zzgtx zzgtxVar) {
        zzgtxVar.getClass();
        zzgtrVar.zze = zzgtxVar;
        zzgtrVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", DYYbQc.TsZbMAtaIf});
        }
        if (iOrdinal == 3) {
            return new zzgtr();
        }
        zzgtq zzgtqVar = null;
        if (iOrdinal == 4) {
            return new zzgtp(zzgtqVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgtr.class) {
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

    public final zzgtx zzg() {
        zzgtx zzgtxVar = this.zze;
        return zzgtxVar == null ? zzgtx.zzf() : zzgtxVar;
    }

    public final zzgxz zzh() {
        return this.zzf;
    }
}
