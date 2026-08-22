package com.google.android.gms.internal.ads;

import com.google.android.gms.games.event.AfJ.oKjScaD;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzhej extends zzgzh implements zzhat {
    private static final zzhej zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;
    private zzhei zze;
    private zzhei zzf;

    static {
        zzhej zzhejVar = new zzhej();
        zza = zzhejVar;
        zzgzh.zzbZ(zzhej.class, zzhejVar);
    }

    private zzhej() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzheg.zza, "zze", oKjScaD.eqypVTYx});
        }
        if (iOrdinal == 3) {
            return new zzhej();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhef(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhej.class) {
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
