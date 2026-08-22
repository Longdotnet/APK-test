package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzapr {
    private int zza = 2500;
    private int zzb;

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    public final void zzc(zzaqm zzaqmVar) throws zzaqm {
        int i = this.zzb + 1;
        this.zzb = i;
        int i2 = this.zza;
        this.zza = i2 + i2;
        if (i > 1) {
            throw zzaqmVar;
        }
    }
}
