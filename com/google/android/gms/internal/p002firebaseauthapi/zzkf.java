package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzkf extends zzadf implements zzael {
    private static final zzkf zzb;
    private zzki zzd;
    private int zze;

    static {
        zzkf zzkfVar = new zzkf();
        zzb = zzkfVar;
        zzadf.zzG(zzkf.class, zzkfVar);
    }

    private zzkf() {
    }

    public static zzke zzb() {
        return (zzke) zzb.zzt();
    }

    public static zzkf zzd() {
        return zzb;
    }

    public static zzkf zze(zzacc zzaccVar, zzacs zzacsVar) {
        return (zzkf) zzadf.zzx(zzb, zzaccVar, zzacsVar);
    }

    public static /* synthetic */ void zzg(zzkf zzkfVar, zzki zzkiVar) {
        zzkiVar.getClass();
        zzkfVar.zzd = zzkiVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzki zzf() {
        zzki zzkiVar = this.zzd;
        return zzkiVar == null ? zzki.zzd() : zzkiVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzkf();
        }
        zzkd zzkdVar = null;
        if (i2 == 4) {
            return new zzke(zzkdVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
