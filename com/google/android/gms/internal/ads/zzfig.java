package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzfig extends zzgzh implements zzhat {
    private static final zzfig zza;
    private static volatile zzhba zzb;
    private zzgzt zzc = zzgzh.zzbK();

    static {
        zzfig zzfigVar = new zzfig();
        zza = zzfigVar;
        zzgzh.zzbZ(zzfig.class, zzfigVar);
    }

    private zzfig() {
    }

    public static zzfic zzb() {
        return (zzfic) zza.zzaZ();
    }

    public static /* synthetic */ void zzd(zzfig zzfigVar, zzfie zzfieVar) {
        zzfieVar.getClass();
        zzgzt zzgztVar = zzfigVar.zzc;
        if (!zzgztVar.zzc()) {
            zzfigVar.zzc = zzgzh.zzbL(zzgztVar);
        }
        zzfigVar.zzc.add(zzfieVar);
    }

    public final int zza() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfie.class});
        }
        if (iOrdinal == 3) {
            return new zzfig();
        }
        zzfif zzfifVar = null;
        if (iOrdinal == 4) {
            return new zzfic(zzfifVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzfig.class) {
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
