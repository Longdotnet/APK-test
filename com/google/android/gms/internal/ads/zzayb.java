package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzayb extends zzayk {
    private final boolean zzh;

    public zzayb(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "jIv42z2v6FXxayFh75bTXtsxRSsCK/ciQjkFKmgks8cLq7HP+HDebRZyGvyOBC97", "2wHbvH170oRSgA6rj2BMxMfMsZs+WbUtizDquheRwWE=", zzastVar, i, 61);
        this.zzh = zzawxVar.zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        long jLongValue = ((Long) this.zze.invoke(null, this.zza.zzb(), Boolean.valueOf(this.zzh))).longValue();
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzC(jLongValue);
        }
    }
}
