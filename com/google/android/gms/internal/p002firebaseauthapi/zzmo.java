package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;

/* JADX INFO: loaded from: classes2.dex */
public final class zzmo extends zzadf implements zzael {
    private static final zzmo zzb;
    private zzacc zzd = zzacc.zzb;
    private zzok zze;

    static {
        zzmo zzmoVar = new zzmo();
        zzb = zzmoVar;
        zzadf.zzG(zzmo.class, zzmoVar);
    }

    private zzmo() {
    }

    public static zzmn zza() {
        return (zzmn) zzb.zzt();
    }

    public static zzmo zzc(byte[] bArr, zzacs zzacsVar) {
        return (zzmo) zzadf.zzy(zzb, bArr, zzacsVar);
    }

    public static /* synthetic */ void zzf(zzmo zzmoVar, zzok zzokVar) {
        zzokVar.getClass();
        zzmoVar.zze = zzokVar;
    }

    public final zzacc zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzadf
    public final Object zzj(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadf.zzD(zzb, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003\t", new Object[]{eoBKjVuj.cCLSom, "zze"});
        }
        if (i2 == 3) {
            return new zzmo();
        }
        zzmm zzmmVar = null;
        if (i2 == 4) {
            return new zzmn(zzmmVar);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
