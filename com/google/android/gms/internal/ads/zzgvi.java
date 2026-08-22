package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzgvi extends zzgzh implements zzhat {
    public static final /* synthetic */ int zza = 0;
    private static final zzgvi zzb;
    private static volatile zzhba zzc;
    private String zzd = "";
    private zzgzt zze = zzgzh.zzbK();

    static {
        zzgvi zzgviVar = new zzgvi();
        zzb = zzgviVar;
        zzgzh.zzbZ(zzgvi.class, zzgviVar);
    }

    private zzgvi() {
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzgui.class});
        }
        if (iOrdinal == 3) {
            return new zzgvi();
        }
        zzgvh zzgvhVar = null;
        if (iOrdinal == 4) {
            return new zzgvg(zzgvhVar);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzc;
        if (zzgzcVar == null) {
            synchronized (zzgvi.class) {
                try {
                    zzgzcVar = zzc;
                    if (zzgzcVar == null) {
                        zzgzcVar = new zzgzc(zzb);
                        zzc = zzgzcVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzgzcVar;
    }
}
