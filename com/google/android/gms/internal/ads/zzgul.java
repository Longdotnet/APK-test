package com.google.android.gms.internal.ads;

import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgul extends zzgzh implements zzhat {
    private static final zzgul zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgub zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgul zzgulVar = new zzgul();
        zza = zzgulVar;
        zzgzh.zzbZ(zzgul.class, zzgulVar);
    }

    private zzgul() {
    }

    public static zzguk zzc() {
        return (zzguk) zza.zzaZ();
    }

    public static /* synthetic */ void zzg(zzgul zzgulVar, zzgub zzgubVar) {
        zzgubVar.getClass();
        zzgulVar.zzd = zzgubVar;
        zzgulVar.zzc |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgub zzb() {
        zzgub zzgubVar = this.zzd;
        return zzgubVar == null ? zzgub.zzd() : zzgubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", ygoi.tPifqQKUDWLsCS, "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzgul();
        }
        zzgum zzgumVar = null;
        if (iOrdinal == 4) {
            return new zzguk(zzgumVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgul.class) {
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

    public final zzgvf zzf() {
        zzgvf zzgvfVarZzb = zzgvf.zzb(this.zzg);
        return zzgvfVarZzb == null ? zzgvf.UNRECOGNIZED : zzgvfVarZzb;
    }

    public final boolean zzj() {
        return (this.zzc & 1) != 0;
    }

    public final int zzk() {
        int i = this.zze;
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                i2 = 3;
            } else if (i != 2) {
                i2 = i != 3 ? 0 : 5;
            } else {
                i2 = 4;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
