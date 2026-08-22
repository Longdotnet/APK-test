package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final class zzeng implements zzeub {
    private final String zza;
    private final boolean zzb;

    public zzeng(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = this.zza;
        zzcva zzcvaVar = (zzcva) obj;
        if (str != null) {
            Bundle bundleZza = zzfdk.zza(zzcvaVar.zza, "pii");
            bundleZza.putString("afai", str);
            bundleZza.putBoolean("is_afai_lat", this.zzb);
        }
    }
}
