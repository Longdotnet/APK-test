package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzest implements zzeub {
    private final Bundle zza;

    public zzest(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (bundle != null) {
            zzcvaVar.zzb.putAll(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (bundle != null) {
            zzcvaVar.zza.putAll(bundle);
        }
    }
}
