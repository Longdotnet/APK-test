package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: loaded from: classes.dex */
public final class zzok extends zzadf implements zzael {
    private static final zzok zzb;
    private int zzd;
    private zzadk zze = zzadf.zzz();

    static {
        zzok zzokVar = new zzok();
        zzb = zzokVar;
        zzadf.zzG(zzok.class, zzokVar);
    }

    private zzok() {
    }

    public static zzoh zza() {
        return (zzoh) zzb.zzt();
    }

    public static /* synthetic */ void zze(zzok zzokVar, zzoj zzojVar) {
        zzojVar.getClass();
        zzadk zzadkVar = zzokVar.zze;
        if (!zzadkVar.zzc()) {
            zzokVar.zze = zzadf.zzA(zzadkVar);
        }
        zzokVar.zze.add(zzojVar);
    }

    public final zzoj zzb(int i) {
        return (zzoj) this.zze.get(0);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zzoj.class});
        }
        if (i2 == 3) {
            return new zzok();
        }
        zzog zzogVar = null;
        if (i2 == 4) {
            return new zzoh(zzogVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
