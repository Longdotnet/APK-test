package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzefq extends zzbrf {
    private final zzedp zza;

    public /* synthetic */ zzefq(zzefs zzefsVar, zzedp zzedpVar, zzefr zzefrVar) {
        Objects.requireNonNull(zzefsVar);
        this.zza = zzedpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zze(String str) {
        ((zzefd) this.zza.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) {
        ((zzefd) this.zza.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrg
    public final void zzg() {
        ((zzefd) this.zza.zzc).zzo();
    }
}
