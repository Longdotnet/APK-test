package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.List;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzgun extends zzgzh implements zzhat {
    private static final zzgun zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgzt zzd = zzgzh.zzbK();

    static {
        zzgun zzgunVar = new zzgun();
        zza = zzgunVar;
        zzgzh.zzbZ(zzgun.class, zzgunVar);
    }

    private zzgun() {
    }

    public static zzguj zzc() {
        return (zzguj) zza.zzaZ();
    }

    public static zzgun zzg(InputStream inputStream, zzgyr zzgyrVar) {
        return (zzgun) zzgzh.zzbu(zza, inputStream, zzgyrVar);
    }

    public static /* synthetic */ void zzi(zzgun zzgunVar, zzgul zzgulVar) {
        zzgulVar.getClass();
        zzgzt zzgztVar = zzgunVar.zzd;
        if (!zzgztVar.zzc()) {
            zzgunVar.zzd = zzgzh.zzbL(zzgztVar);
        }
        zzgunVar.zzd.add(zzgulVar);
    }

    public final int zza() {
        return this.zzd.size();
    }

    public final int zzb() {
        return this.zzc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzgul zzd(int i) {
        return (zzgul) this.zzd.get(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", ygoi.zugSXUGB, zzgul.class});
        }
        if (iOrdinal == 3) {
            return new zzgun();
        }
        zzgum zzgumVar = null;
        if (iOrdinal == 4) {
            return new zzguj(zzgumVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgun.class) {
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

    public final List zzh() {
        return this.zzd;
    }
}
