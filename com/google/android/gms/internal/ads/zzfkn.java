package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzfkn implements zzazw {
    final /* synthetic */ zzfkp zza;

    public zzfkn(zzfkp zzfkpVar) {
        Objects.requireNonNull(zzfkpVar);
        this.zza = zzfkpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zza(boolean z) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzx)).booleanValue()) {
            this.zza.zzq(z);
        }
    }
}
