package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzjt extends zzadf implements zzael {
    private static final zzjt zzb;
    private int zzd;

    static {
        zzjt zzjtVar = new zzjt();
        zzb = zzjtVar;
        zzadf.zzG(zzjt.class, zzjtVar);
    }

    private zzjt() {
    }

    public static zzjs zzb() {
        return (zzjs) zzb.zzt();
    }

    public static zzjt zzd() {
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
            return new zzjt();
        }
        zzjr zzjrVar = null;
        if (i2 == 4) {
            return new zzjs(zzjrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
