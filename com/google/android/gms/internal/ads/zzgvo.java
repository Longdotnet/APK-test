package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgvo extends zzgzh implements zzhat {
    private static final zzgvo zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgvr zze;

    static {
        zzgvo zzgvoVar = new zzgvo();
        zza = zzgvoVar;
        zzgzh.zzbZ(zzgvo.class, zzgvoVar);
    }

    private zzgvo() {
    }

    public static zzgvm zzb() {
        return (zzgvm) zza.zzaZ();
    }

    public static zzgvo zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgvo) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzg(zzgvo zzgvoVar, zzgvr zzgvrVar) {
        zzgvrVar.getClass();
        zzgvoVar.zze = zzgvrVar;
        zzgvoVar.zzc |= 1;
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
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgvo();
        }
        zzgvn zzgvnVar = null;
        if (iOrdinal == 4) {
            return new zzgvm(zzgvnVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgvo.class) {
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

    public final zzgvr zzf() {
        zzgvr zzgvrVar = this.zze;
        return zzgvrVar == null ? zzgvr.zzd() : zzgvrVar;
    }
}
