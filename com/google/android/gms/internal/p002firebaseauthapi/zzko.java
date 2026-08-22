package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzko extends zzadf implements zzael {
    private static final zzko zzb;
    private zzkr zzd;
    private int zze;

    static {
        zzko zzkoVar = new zzko();
        zzb = zzkoVar;
        zzadf.zzG(zzko.class, zzkoVar);
    }

    private zzko() {
    }

    public static zzkn zzb() {
        return (zzkn) zzb.zzt();
    }

    public static zzko zzd(zzacc zzaccVar, zzacs zzacsVar) {
        return (zzko) zzadf.zzx(zzb, zzaccVar, zzacsVar);
    }

    public static /* synthetic */ void zzf(zzko zzkoVar, zzkr zzkrVar) {
        zzkrVar.getClass();
        zzkoVar.zzd = zzkrVar;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzkr zze() {
        zzkr zzkrVar = this.zzd;
        return zzkrVar == null ? zzkr.zzd() : zzkrVar;
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
            return new zzko();
        }
        zzkm zzkmVar = null;
        if (i2 == 4) {
            return new zzkn(zzkmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
