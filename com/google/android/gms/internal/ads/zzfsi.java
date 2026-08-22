package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes.dex */
final class zzfsi extends zzgcb {
    Object zza;

    public zzfsi(Object obj, Runnable runnable) {
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final String zza() {
        Object obj = this.zza;
        return obj == null ? "" : obj.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final void zzb() {
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final boolean zzc(Object obj) {
        return super.zzc(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgcb
    public final boolean zzd(Throwable th) {
        return super.zzd(th);
    }
}
