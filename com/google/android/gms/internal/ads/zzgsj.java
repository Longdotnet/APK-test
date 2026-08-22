package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgsj extends zzgzh implements zzhat {
    private static final zzgsj zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgsm zzd;
    private int zze;

    static {
        zzgsj zzgsjVar = new zzgsj();
        zza = zzgsjVar;
        zzgzh.zzbZ(zzgsj.class, zzgsjVar);
    }

    private zzgsj() {
    }

    public static zzgsh zzb() {
        return (zzgsh) zza.zzaZ();
    }

    public static zzgsj zzd() {
        return zza;
    }

    public static /* synthetic */ void zzh(zzgsj zzgsjVar, zzgsm zzgsmVar) {
        zzgsmVar.getClass();
        zzgsjVar.zzd = zzgsmVar;
        zzgsjVar.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzgsj();
        }
        zzgsi zzgsiVar = null;
        if (iOrdinal == 4) {
            return new zzgsh(zzgsiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgsj.class) {
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

    public final zzgsm zzf() {
        zzgsm zzgsmVar = this.zzd;
        return zzgsmVar == null ? zzgsm.zzd() : zzgsmVar;
    }
}
