package com.google.android.gms.internal.ads;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzheo extends zzgzh implements zzhat {
    private static final zzheo zza;
    private static volatile zzhba zzb;
    private int zzc;
    private String zzd = "";
    private long zze;

    static {
        zzheo zzheoVar = new zzheo();
        zza = zzheoVar;
        zzgzh.zzbZ(zzheo.class, zzheoVar);
    }

    private zzheo() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{RDFWIi.kGcg, "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzheo();
        }
        zzhfx zzhfxVar = null;
        if (iOrdinal == 4) {
            return new zzhen(zzhfxVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzheo.class) {
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
