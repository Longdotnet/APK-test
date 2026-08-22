package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzetj implements zzeub {
    private final String zza;
    private final Bundle zzb;

    public zzetj(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        bundle.putString("rtb", this.zza);
        Bundle bundle2 = this.zzb;
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("adapter_initialization_status", bundle2);
    }
}
