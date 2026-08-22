package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class zzeup implements zzeub {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzeup(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = z;
        this.zzf = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        String str = this.zza;
        zzfdk.zzf(bundle, "carrier", str, !TextUtils.isEmpty(str));
        int i = this.zzb;
        zzfdk.zze(bundle, "cnt", i, i != -2);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle bundleZza = zzfdk.zza(bundle, "device");
        bundle.putBundle("device", bundleZza);
        Bundle bundleZza2 = zzfdk.zza(bundleZza, "network");
        bundleZza.putBundle("network", bundleZza2);
        bundleZza2.putInt("active_network_state", this.zzf);
        bundleZza2.putBoolean("active_network_metered", this.zze);
    }
}
