package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzoe extends zzadf implements zzael {
    private static final zzoe zzb;
    private zzns zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzoe zzoeVar = new zzoe();
        zzb = zzoeVar;
        zzadf.zzG(zzoe.class, zzoeVar);
    }

    private zzoe() {
    }

    public static zzod zzc() {
        return (zzod) zzb.zzt();
    }

    public static /* synthetic */ void zzf(zzoe zzoeVar, zzns zznsVar) {
        zznsVar.getClass();
        zzoeVar.zzd = zznsVar;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzns zzb() {
        zzns zznsVar = this.zzd;
        return zznsVar == null ? zzns.zzd() : zznsVar;
    }

    public final zzoy zze() {
        zzoy zzoyVarZzb = zzoy.zzb(this.zzg);
        return zzoyVarZzb == null ? zzoy.UNRECOGNIZED : zzoyVarZzb;
    }

    public final boolean zzi() {
        return this.zzd != null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzoe();
        }
        zzob zzobVar = null;
        if (i2 == 4) {
            return new zzod(zzobVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final int zzk() {
        int i = this.zze;
        int i2 = 2;
        if (i != 0) {
            if (i == 1) {
                i2 = 3;
            } else if (i != 2) {
                i2 = i != 3 ? 0 : 5;
            } else {
                i2 = 4;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }
}
