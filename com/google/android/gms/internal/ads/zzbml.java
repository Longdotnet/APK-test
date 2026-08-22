package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* JADX INFO: loaded from: classes.dex */
public final class zzbml implements AdapterStatus {
    private final AdapterStatus.State zza;
    private final String zzb;
    private final int zzc;

    public zzbml(AdapterStatus.State state, String str, int i) {
        this.zza = state;
        this.zzb = str;
        this.zzc = i;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return this.zzb;
    }

    public final AdapterStatus.State getInitializationState() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final int getLatency() {
        return this.zzc;
    }
}
