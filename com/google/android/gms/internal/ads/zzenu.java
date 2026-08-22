package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zzenu implements zzeub {
    final String zza;
    final int zzb;

    public zzenu(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i;
        Bundle bundle = ((zzcva) obj).zza;
        String str = this.zza;
        if (TextUtils.isEmpty(str) || (i = this.zzb) == -1) {
            return;
        }
        Bundle bundleZza = zzfdk.zza(bundle, "pii");
        bundle.putBundle("pii", bundleZza);
        bundleZza.putString("pvid", str);
        bundleZza.putInt("pvid_s", i);
    }
}
