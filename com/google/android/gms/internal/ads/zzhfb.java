package com.google.android.gms.internal.ads;

import androidx.sqlite.db.framework.VERT.YcVWhnLsj;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhfb extends zzgzh implements zzhat {
    private static final zzhfb zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zze;
    private boolean zzf;
    private int zzg;
    private boolean zzj;
    private boolean zzk;
    private String zzd = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzhfb zzhfbVar = new zzhfb();
        zza = zzhfbVar;
        zzgzh.zzbZ(zzhfb.class, zzhfbVar);
    }

    private zzhfb() {
    }

    public static zzhfa zzc() {
        return (zzhfa) zza.zzaZ();
    }

    public static /* synthetic */ void zzf(zzhfb zzhfbVar, String str) {
        zzhfbVar.zzc |= 1;
        zzhfbVar.zzd = str;
    }

    public static /* synthetic */ void zzg(zzhfb zzhfbVar, long j) {
        zzhfbVar.zzc |= 2;
        zzhfbVar.zze = j;
    }

    public static /* synthetic */ void zzh(zzhfb zzhfbVar, boolean z) {
        zzhfbVar.zzc |= 4;
        zzhfbVar.zzf = z;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzhfc.zza, "zzh", "zzi", "zzj", YcVWhnLsj.uZXHwQbx});
        }
        if (iOrdinal == 3) {
            return new zzhfb();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhfa(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhfb.class) {
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
