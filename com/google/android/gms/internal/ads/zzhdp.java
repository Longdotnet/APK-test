package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhdp extends zzgzh implements zzhat {
    private static final zzhdp zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgxz zzd = zzgxz.zzb;

    static {
        zzhdp zzhdpVar = new zzhdp();
        zza = zzhdpVar;
        zzgzh.zzbZ(zzhdp.class, zzhdpVar);
    }

    private zzhdp() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ည\u0000", new Object[]{MnHfHMYQDPUO.QPcwpzDJwVNn, "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhdp();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhdo(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhdp.class) {
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
