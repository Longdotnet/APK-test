package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzchm implements zzhgr {
    private final zzchh zza;

    private zzchm(zzchh zzchhVar) {
        this.zza = zzchhVar;
    }

    public static zzchm zza(zzchh zzchhVar) {
        return new zzchm(zzchhVar);
    }

    public static WeakReference zzd(zzchh zzchhVar) {
        WeakReference weakReferenceZzg = zzchhVar.zzg();
        zzhgz.zzb(weakReferenceZzg);
        return weakReferenceZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }

    public final WeakReference zzc() {
        return zzd(this.zza);
    }
}
