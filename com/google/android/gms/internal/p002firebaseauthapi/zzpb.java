package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzpb extends zzadf implements zzael {
    private static final zzpb zzb;
    private String zzd = "";
    private zzadk zze = zzadf.zzz();

    static {
        zzpb zzpbVar = new zzpb();
        zzb = zzpbVar;
        zzadf.zzG(zzpb.class, zzpbVar);
    }

    private zzpb() {
    }

    public static zzpb zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzd", "zze", zzoa.class});
        }
        if (i2 == 3) {
            return new zzpb();
        }
        zzoz zzozVar = null;
        if (i2 == 4) {
            return new zzpa(zzozVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
