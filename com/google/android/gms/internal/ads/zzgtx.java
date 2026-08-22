package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtx extends zzgzh implements zzhat {
    private static final zzgtx zza;
    private static volatile zzhba zzb;
    private int zzc;
    private int zzd;

    static {
        zzgtx zzgtxVar = new zzgtx();
        zza = zzgtxVar;
        zzgzh.zzbZ(zzgtx.class, zzgtxVar);
    }

    private zzgtx() {
    }

    public static zzgtv zzc() {
        return (zzgtv) zza.zzaZ();
    }

    public static zzgtx zzf() {
        return zza;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzgto zzb() {
        zzgto zzgtoVar;
        int i = this.zzc;
        if (i == 0) {
            zzgtoVar = zzgto.UNKNOWN_HASH;
        } else if (i == 1) {
            zzgtoVar = zzgto.SHA1;
        } else if (i == 2) {
            zzgtoVar = zzgto.SHA384;
        } else if (i == 3) {
            zzgtoVar = zzgto.SHA256;
        } else if (i != 4) {
            zzgtoVar = i != 5 ? null : zzgto.SHA224;
        } else {
            zzgtoVar = zzgto.SHA512;
        }
        return zzgtoVar == null ? zzgto.UNRECOGNIZED : zzgtoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzgtx();
        }
        zzgtw zzgtwVar = null;
        if (iOrdinal == 4) {
            return new zzgtv(zzgtwVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgtx.class) {
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
