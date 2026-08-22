package com.google.android.gms.internal.ads;

import androidx.sqlite.db.framework.VERT.YcVWhnLsj;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaua extends zzgzh implements zzhat {
    private static final zzaua zza;
    private static volatile zzhba zzb;
    private int zzc;
    private long zzf;
    private long zzh;
    private long zzi;
    private String zzd = "";
    private String zze = "";
    private String zzg = "D";

    static {
        zzaua zzauaVar = new zzaua();
        zza = zzauaVar;
        zzgzh.zzbZ(zzaua.class, zzauaVar);
    }

    private zzaua() {
    }

    public static zzatz zza() {
        return (zzatz) zza.zzaZ();
    }

    public static /* synthetic */ void zzc(zzaua zzauaVar, String str) {
        zzauaVar.zzc |= 1;
        zzauaVar.zzd = "0.460000000";
    }

    public static /* synthetic */ void zzd(zzaua zzauaVar, String str) {
        str.getClass();
        zzauaVar.zzc |= 2;
        zzauaVar.zze = str;
    }

    public static /* synthetic */ void zzf(zzaua zzauaVar, String str) {
        str.getClass();
        zzauaVar.zzc |= 8;
        zzauaVar.zzg = str;
    }

    public static /* synthetic */ void zzg(zzaua zzauaVar, long j) {
        zzauaVar.zzc |= 4;
        zzauaVar.zzf = j;
    }

    public static /* synthetic */ void zzh(zzaua zzauaVar, long j) {
        zzauaVar.zzc |= 32;
        zzauaVar.zzi = j;
    }

    public static /* synthetic */ void zzi(zzaua zzauaVar, long j) {
        zzauaVar.zzc |= 16;
        zzauaVar.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဈ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{YcVWhnLsj.ZleeU, "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzaua();
        }
        zzaui zzauiVar = null;
        if (iOrdinal == 4) {
            return new zzatz(zzauiVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzaua.class) {
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
