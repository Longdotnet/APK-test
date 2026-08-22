package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzre {
    private final zzcn[] zza;
    private final zzrw zzb;
    private final zzcq zzc;

    public zzre(zzcn... zzcnVarArr) {
        zzrw zzrwVar = new zzrw();
        zzcq zzcqVar = new zzcq();
        zzcn[] zzcnVarArr2 = {zzrwVar, zzcqVar};
        this.zza = zzcnVarArr2;
        System.arraycopy(zzcnVarArr, 0, zzcnVarArr2, 0, 0);
        this.zzb = zzrwVar;
        this.zzc = zzcqVar;
    }

    public final long zza(long j) {
        zzcq zzcqVar = this.zzc;
        return zzcqVar.zzg() ? zzcqVar.zzi(j) : j;
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzbb zzc(zzbb zzbbVar) {
        zzcq zzcqVar = this.zzc;
        zzcqVar.zzk(zzbbVar.zzb);
        zzcqVar.zzj(zzbbVar.zzc);
        return zzbbVar;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzcn[] zze() {
        return this.zza;
    }
}
