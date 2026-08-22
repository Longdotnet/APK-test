package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgru extends zzgzh implements zzhat {
    private static final zzgru zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzgrx zze;

    static {
        zzgru zzgruVar = new zzgru();
        zza = zzgruVar;
        zzgzh.zzbZ(zzgru.class, zzgruVar);
    }

    private zzgru() {
    }

    public static zzgrs zzb() {
        return (zzgrs) zza.zzaZ();
    }

    public static zzgru zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgru) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static /* synthetic */ void zzh(zzgru zzgruVar, zzgrx zzgrxVar) {
        zzgrxVar.getClass();
        zzgruVar.zze = zzgrxVar;
        zzgruVar.zzc |= 1;
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
            return new zzgru();
        }
        zzgrt zzgrtVar = null;
        if (iOrdinal == 4) {
            return new zzgrs(zzgrtVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgru.class) {
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

    public final zzgrx zzf() {
        zzgrx zzgrxVar = this.zze;
        return zzgrxVar == null ? zzgrx.zzd() : zzgrxVar;
    }
}
