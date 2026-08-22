package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzns extends zzadf implements zzael {
    private static final zzns zzb;
    private String zzd = "";
    private zzacc zze = zzacc.zzb;
    private int zzf;

    static {
        zzns zznsVar = new zzns();
        zzb = zznsVar;
        zzadf.zzG(zzns.class, zznsVar);
    }

    private zzns() {
    }

    public static zznp zza() {
        return (zznp) zzb.zzt();
    }

    public static zzns zzd() {
        return zzb;
    }

    public final zznr zzb() {
        zznr zznrVarZzb = zznr.zzb(this.zzf);
        return zznrVarZzb == null ? zznr.UNRECOGNIZED : zznrVarZzb;
    }

    public final zzacc zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzns();
        }
        zzno zznoVar = null;
        if (i2 == 4) {
            return new zznp(zznoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
