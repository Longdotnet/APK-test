package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzehq extends zzbrl {
    private final zzedp zza;

    public /* synthetic */ zzehq(zzehs zzehsVar, zzedp zzedpVar, zzehr zzehrVar) {
        Objects.requireNonNull(zzehsVar);
        this.zza = zzedpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zze(String str) {
        ((zzefd) this.zza.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        ((zzefd) this.zza.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrm
    public final void zzg() {
        ((zzefd) this.zza.zzc).zzo();
    }
}
