package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public class zzhm {
    private int zza;

    public final void zza(int i) {
        this.zza |= 536870912;
    }

    public void zzb() {
        this.zza = 0;
    }

    public final void zzc(int i) {
        this.zza = i;
    }

    public final boolean zzd(int i) {
        return (this.zza & i) == i;
    }

    public final boolean zze() {
        return zzd(268435456);
    }

    public final boolean zzf() {
        return zzd(4);
    }

    public final boolean zzg() {
        return zzd(1);
    }

    public final boolean zzh() {
        return zzd(536870912);
    }

    public final boolean zzi() {
        return zzd(67108864);
    }
}
