package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
public final class zzcvm implements zzhgr {
    private final zzhha zza;

    private zzcvm(zzcvh zzcvhVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcvm zza(zzcvh zzcvhVar, zzhha zzhhaVar) {
        return new zzcvm(zzcvhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        String strZzg = ((zzcsq) this.zza.zzb()).zzg();
        zzhgz.zzb(strZzg);
        return strZzg;
    }
}
