package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zznx extends zzadf implements zzael {
    private static final zznx zzb;
    private String zzd = "";
    private zzacc zze = zzacc.zzb;
    private int zzf;

    static {
        zznx zznxVar = new zznx();
        zzb = zznxVar;
        zzadf.zzG(zznx.class, zznxVar);
    }

    private zznx() {
    }

    public static zznw zza() {
        return (zznw) zzb.zzt();
    }

    public static zznx zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzg(zznx zznxVar, String str) {
        str.getClass();
        zznxVar.zzd = str;
    }

    public final zzoy zzd() {
        zzoy zzoyVarZzb = zzoy.zzb(this.zzf);
        return zzoyVarZzb == null ? zzoy.UNRECOGNIZED : zzoyVarZzb;
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
            return new zznx();
        }
        if (i2 == 4) {
            return new zznw(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
