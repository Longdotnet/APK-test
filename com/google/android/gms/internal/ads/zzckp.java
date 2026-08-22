package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzckp implements zzhgr {
    private final zzhha zza;

    private zzckp(zzckg zzckgVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzckp zza(zzckg zzckgVar, zzhha zzhhaVar) {
        return new zzckp(zzckgVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzfds zzb() {
        zzfds zzfdsVarZzd = zzfds.zzd(((zzchl) this.zza).zza());
        zzhgz.zzb(zzfdsVarZzd);
        return zzfdsVarZzd;
    }
}
