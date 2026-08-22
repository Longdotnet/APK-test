package com.google.android.gms.internal.ads;

import com.facebook.login.vu.dLDI;

/* JADX INFO: loaded from: classes2.dex */
public final class zzhcs extends zzgzh implements zzhat {
    private static final zzhcs zza;
    private static volatile zzhba zzb;
    private zzgzp zzc = zzgzh.zzbG();
    private zzgzp zzd = zzgzh.zzbG();

    static {
        zzhcs zzhcsVar = new zzhcs();
        zza = zzhcsVar;
        zzgzh.zzbZ(zzhcs.class, zzhcsVar);
    }

    private zzhcs() {
    }

    public static zzhcs zzd(byte[] bArr, zzgyr zzgyrVar) {
        return (zzhcs) zzgzh.zzbx(zza, bArr, zzgyrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0002\u0000\u0001\u0016\u0003\u0016", new Object[]{dLDI.JxqnTv, "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhcs();
        }
        zzhct zzhctVar = null;
        if (iOrdinal == 4) {
            return new zzhcr(zzhctVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhcs.class) {
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
