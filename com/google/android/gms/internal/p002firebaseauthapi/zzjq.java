package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzjq extends zzadf implements zzael {
    private static final zzjq zzb;
    private int zzd;
    private zzjt zze;

    static {
        zzjq zzjqVar = new zzjq();
        zzb = zzjqVar;
        zzadf.zzG(zzjq.class, zzjqVar);
    }

    private zzjq() {
    }

    public static zzjp zzb() {
        return (zzjp) zzb.zzt();
    }

    public static zzjq zzd(zzacc zzaccVar, zzacs zzacsVar) {
        return (zzjq) zzadf.zzx(zzb, zzaccVar, zzacsVar);
    }

    public static /* synthetic */ void zzg(zzjq zzjqVar, zzjt zzjtVar) {
        zzjtVar.getClass();
        zzjqVar.zze = zzjtVar;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzjt zze() {
        zzjt zzjtVar = this.zze;
        return zzjtVar == null ? zzjt.zzd() : zzjtVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzjq();
        }
        zzjo zzjoVar = null;
        if (i2 == 4) {
            return new zzjp(zzjoVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
