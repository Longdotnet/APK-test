package com.google.android.gms.internal.ads;

import kotlin.coroutines.jvm.internal.DEXi.JuorMn;

/* JADX INFO: loaded from: classes2.dex */
public final class zzasd extends zzgzh implements zzhat {
    private static final zzasd zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zze;
    private long zzi;
    private long zzj;
    private long zzl;
    private int zzp;
    private String zzd = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzk = "";
    private String zzm = "";
    private String zzn = "";
    private zzgzt zzo = zzgzh.zzbK();

    static {
        zzasd zzasdVar = new zzasd();
        zza = zzasdVar;
        zzgzh.zzbZ(zzasd.class, zzasdVar);
    }

    private zzasd() {
    }

    public static zzarz zza() {
        return (zzarz) zza.zzaZ();
    }

    public static /* synthetic */ void zzc(zzasd zzasdVar, String str) {
        str.getClass();
        zzasdVar.zzc |= 1;
        zzasdVar.zzd = str;
    }

    public static /* synthetic */ void zzd(zzasd zzasdVar, String str) {
        zzasdVar.zzc |= 16;
        zzasdVar.zzh = str;
    }

    public static /* synthetic */ void zzf(zzasd zzasdVar, String str) {
        zzasdVar.zzc |= 1024;
        zzasdVar.zzn = str;
    }

    public static /* synthetic */ void zzg(zzasd zzasdVar, String str) {
        str.getClass();
        zzasdVar.zzc |= 8;
        zzasdVar.zzg = str;
    }

    public static /* synthetic */ void zzh(zzasd zzasdVar, long j) {
        zzasdVar.zzc |= 2;
        zzasdVar.zze = j;
    }

    public static /* synthetic */ void zzi(zzasd zzasdVar, String str) {
        str.getClass();
        zzasdVar.zzc |= 4;
        zzasdVar.zzf = str;
    }

    public static /* synthetic */ void zzj(zzasd zzasdVar, int i) {
        zzasdVar.zzp = i - 1;
        zzasdVar.zzc |= 2048;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", JuorMn.LRyiyOg, "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzasb.class, "zzp", zzasc.zza});
        }
        if (iOrdinal == 3) {
            return new zzasd();
        }
        if (iOrdinal == 4) {
            return new zzarz(null);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzasd.class) {
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
