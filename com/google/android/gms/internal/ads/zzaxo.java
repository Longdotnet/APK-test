package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxo extends zzayk {
    private final long zzh;

    public zzaxo(zzawx zzawxVar, String str, String str2, zzast zzastVar, long j, int i, int i2) {
        super(zzawxVar, "bz3lIaHWpCquphICM8d57wBZcB7vA3QBLpLSSF22FzCVTv7HI8nqsTojeybBUatg", "nJy2u10FH1OsIt1ONuXNmQ7d3Q3+he826LogUVDBAds=", zzastVar, i, 25);
        this.zzh = j;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        long jLongValue = ((Long) this.zze.invoke(null, null)).longValue();
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            try {
                zzastVar.zzr(jLongValue);
                long j = this.zzh;
                if (j != 0) {
                    zzastVar.zzR(jLongValue - j);
                    zzastVar.zzS(j);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
