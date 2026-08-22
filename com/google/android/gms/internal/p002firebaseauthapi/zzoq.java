package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzoq extends zzadf implements zzael {
    private static final zzoq zzb;
    private String zzd = "";

    static {
        zzoq zzoqVar = new zzoq();
        zzb = zzoqVar;
        zzadf.zzG(zzoq.class, zzoqVar);
    }

    private zzoq() {
    }

    public static zzoq zzb() {
        return zzb;
    }

    public static zzoq zzc(zzacc zzaccVar, zzacs zzacsVar) {
        return (zzoq) zzadf.zzx(zzb, zzaccVar, zzacsVar);
    }

    public final String zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzoq();
        }
        zzoo zzooVar = null;
        if (i2 == 4) {
            return new zzop(zzooVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
