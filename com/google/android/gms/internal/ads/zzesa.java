package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzesa implements zzeub {
    public final Bundle zza;

    public zzesa(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        Bundle bundleZza = zzfdk.zza(bundle, "device");
        bundleZza.putBundle("android_mem_info", this.zza);
        bundle.putBundle("device", bundleZza);
    }
}
