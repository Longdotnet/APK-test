package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzguv extends zzgzh implements zzhat {
    private static final zzguv zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzguy zze;

    static {
        zzguv zzguvVar = new zzguv();
        zza = zzguvVar;
        zzgzh.zzbZ(zzguv.class, zzguvVar);
    }

    private zzguv() {
    }

    public static zzgut zzb() {
        return (zzgut) zza.zzaZ();
    }

    public static zzguv zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzguv) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzg() {
        return zza.zzbN();
    }

    public static /* synthetic */ void zzh(zzguv zzguvVar, zzguy zzguyVar) {
        zzguyVar.getClass();
        zzguvVar.zze = zzguyVar;
        zzguvVar.zzc |= 1;
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
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzguv();
        }
        zzguu zzguuVar = null;
        if (iOrdinal == 4) {
            return new zzgut(zzguuVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzguv.class) {
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

    public final zzguy zzf() {
        zzguy zzguyVar = this.zze;
        return zzguyVar == null ? zzguy.zzc() : zzguyVar;
    }
}
