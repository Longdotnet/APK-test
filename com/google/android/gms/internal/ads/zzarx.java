package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzarx extends zzgzh implements zzhat {
    private static final zzarx zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private boolean zzg;
    private zzasp zzi;
    private zzass zzj;
    private boolean zzk;
    private boolean zze = true;
    private String zzf = "unknown_host";
    private boolean zzh = true;

    static {
        zzarx zzarxVar = new zzarx();
        zza = zzarxVar;
        zzgzh.zzbZ(zzarx.class, zzarxVar);
    }

    private zzarx() {
    }

    public static zzarv zza() {
        return (zzarv) zza.zzaZ();
    }

    public static /* synthetic */ void zzg(zzarx zzarxVar, boolean z) {
        zzarxVar.zzc |= 8;
        zzarxVar.zzg = z;
    }

    public static /* synthetic */ void zzh(zzarx zzarxVar, String str) {
        str.getClass();
        zzarxVar.zzc |= 4;
        zzarxVar.zzf = str;
    }

    public final zzasp zzc() {
        zzasp zzaspVar = this.zzi;
        return zzaspVar == null ? zzasp.zzc() : zzaspVar;
    }

    public final zzass zzd() {
        zzass zzassVar = this.zzj;
        return zzassVar == null ? zzass.zzb() : zzassVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", zzary.zza, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzarx();
        }
        zzarw zzarwVar = null;
        if (iOrdinal == 4) {
            return new zzarv(zzarwVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzarx.class) {
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

    public final String zzf() {
        return this.zzf;
    }

    @Deprecated
    public final boolean zzi() {
        return this.zzg;
    }
}
