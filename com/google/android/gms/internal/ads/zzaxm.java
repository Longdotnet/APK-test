package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxm extends zzayk {
    public zzaxm(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2) {
        super(zzawxVar, "ptULCqFpkxWHwh0HVZoMpk0Xr91rKWbEROvrSrbrHF8bfcD+J1G9qxssmqT2HcO0", "gABvx04l+Prrr7UIzRlxJTdbXEyGkYLmeTdDcw+INuA=", zzastVar, i, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        zzast zzastVar = this.zzd;
        zzastVar.zzm(-1L);
        zzastVar.zzl(-1L);
        int[] iArr = (int[]) this.zze.invoke(null, this.zza.zzb());
        synchronized (zzastVar) {
            try {
                zzastVar.zzm(iArr[0]);
                zzastVar.zzl(iArr[1]);
                int i = iArr[2];
                if (i != Integer.MIN_VALUE) {
                    zzastVar.zzk(i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
