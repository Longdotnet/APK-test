package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzgtk extends zzgzh implements zzhat {
    private static final zzgtk zza;
    private static volatile zzhba zzb;
    private int zzc;
    private zzgxz zzd = zzgxz.zzb;

    static {
        zzgtk zzgtkVar = new zzgtk();
        zza = zzgtkVar;
        zzgzh.zzbZ(zzgtk.class, zzgtkVar);
    }

    private zzgtk() {
    }

    public static zzgti zzb() {
        return (zzgti) zza.zzaZ();
    }

    public static zzgtk zzd(zzgxz zzgxzVar, zzgyr zzgyrVar) {
        return (zzgtk) zzgzh.zzbr(zza, zzgxzVar, zzgyrVar);
    }

    public static zzhba zzg() {
        return zza.zzbN();
    }

    public final int zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgzh
    public final Object zzdd(zzgzg zzgzgVar, Object obj, Object obj2) {
        int iOrdinal = zzgzgVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzgzh.zzbQ(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzgtk();
        }
        zzgtj zzgtjVar = null;
        if (iOrdinal == 4) {
            return new zzgti(zzgtjVar);
        }
        if (iOrdinal == 5) {
            return zza;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhba zzgzcVar = zzb;
        if (zzgzcVar == null) {
            synchronized (zzgtk.class) {
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

    public final zzgxz zzf() {
        return this.zzd;
    }
}
