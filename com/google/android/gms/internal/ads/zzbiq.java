package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzbiq {
    private final com.google.android.gms.ads.formats.zzg zza;
    private final com.google.android.gms.ads.formats.zzf zzb;
    private zzbhk zzc;

    public zzbiq(com.google.android.gms.ads.formats.zzg zzgVar, com.google.android.gms.ads.formats.zzf zzfVar) {
        this.zza = zzgVar;
        this.zzb = zzfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzbhk zzf(zzbhj zzbhjVar) {
        zzbhk zzbhkVar = this.zzc;
        if (zzbhkVar != null) {
            return zzbhkVar;
        }
        zzbhk zzbhkVar2 = new zzbhk(zzbhjVar);
        this.zzc = zzbhkVar2;
        return zzbhkVar2;
    }

    public final zzbht zzc() {
        zzbip zzbipVar = null;
        if (this.zzb == null) {
            return null;
        }
        return new zzbin(this, zzbipVar);
    }

    public final zzbhw zzd() {
        return new zzbio(this, null);
    }
}
