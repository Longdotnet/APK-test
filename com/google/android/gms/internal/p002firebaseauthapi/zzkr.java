package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzkr extends zzadf implements zzael {
    private static final zzkr zzb;
    private int zzd;

    static {
        zzkr zzkrVar = new zzkr();
        zzb = zzkrVar;
        zzadf.zzG(zzkr.class, zzkrVar);
    }

    private zzkr() {
    }

    public static zzkq zzb() {
        return (zzkq) zzb.zzt();
    }

    public static zzkr zzd() {
        return zzb;
    }

    public final int zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzkr();
        }
        zzkp zzkpVar = null;
        if (i2 == 4) {
            return new zzkq(zzkpVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
