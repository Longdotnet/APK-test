package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzhcz extends zzgzh implements zzhat {
    private static final zzhcz zza;
    private static volatile zzhba zzb;
    private zzgzt zzc = zzgzh.zzbK();

    static {
        zzhcz zzhczVar = new zzhcz();
        zza = zzhczVar;
        zzgzh.zzbZ(zzhcz.class, zzhczVar);
    }

    private zzhcz() {
    }

    public static zzhcy zzc() {
        return (zzhcy) zza.zzaZ();
    }

    public static /* synthetic */ void zzf(zzhcz zzhczVar, zzhcx zzhcxVar) {
        zzhcxVar.getClass();
        zzgzt zzgztVar = zzhczVar.zzc;
        if (!zzgztVar.zzc()) {
            zzhczVar.zzc = zzgzh.zzbL(zzgztVar);
        }
        zzhczVar.zzc.add(zzhcxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzhcx.class});
        }
        if (iOrdinal == 3) {
            return new zzhcz();
        }
        zzhda zzhdaVar = null;
        if (iOrdinal == 4) {
            return new zzhcy(zzhdaVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzhcz.class) {
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
