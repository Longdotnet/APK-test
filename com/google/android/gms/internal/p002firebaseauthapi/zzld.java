package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzld extends zzadf implements zzael {
    private static final zzld zzb;
    private int zzd;
    private int zze;

    static {
        zzld zzldVar = new zzld();
        zzb = zzldVar;
        zzadf.zzG(zzld.class, zzldVar);
    }

    private zzld() {
    }

    public static zzlc zzb() {
        return (zzlc) zzb.zzt();
    }

    public static zzld zzd(zzacc zzaccVar, zzacs zzacsVar) {
        return (zzld) zzadf.zzx(zzb, zzaccVar, zzacsVar);
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
            return zzadf.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzd"});
        }
        if (i2 == 3) {
            return new zzld();
        }
        zzlb zzlbVar = null;
        if (i2 == 4) {
            return new zzlc(zzlbVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
