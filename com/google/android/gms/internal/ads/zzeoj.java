package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzeoj implements zzhgr {
    private final zzhha zza;

    private zzeoj(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzeoj zzc(zzhha zzhhaVar) {
        return new zzeoj(zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeoh zzb() {
        return new zzeoh(((zzcvp) this.zza).zzc());
    }
}
