package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzmt extends zzadf implements zzael {
    private static final zzmt zzb;
    private int zzd;
    private zzmz zze;
    private zzacc zzf = zzacc.zzb;

    static {
        zzmt zzmtVar = new zzmt();
        zzb = zzmtVar;
        zzadf.zzG(zzmt.class, zzmtVar);
    }

    private zzmt() {
    }

    public static zzms zzb() {
        return (zzms) zzb.zzt();
    }

    public static zzmt zzd() {
        return zzb;
    }

    public static zzmt zze(zzacc zzaccVar, zzacs zzacsVar) {
        return (zzmt) zzadf.zzx(zzb, zzaccVar, zzacsVar);
    }

    public static /* synthetic */ void zzi(zzmt zzmtVar, zzmz zzmzVar) {
        zzmzVar.getClass();
        zzmtVar.zze = zzmzVar;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzmz zzf() {
        zzmz zzmzVar = this.zze;
        return zzmzVar == null ? zzmz.zzd() : zzmzVar;
    }

    public final zzacc zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzmt();
        }
        zzmr zzmrVar = null;
        if (i2 == 4) {
            return new zzms(zzmrVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
