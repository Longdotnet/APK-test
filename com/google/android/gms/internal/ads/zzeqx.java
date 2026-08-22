package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzeqx implements zzeub {
    private final String zza;
    private final String zzb;
    private final Bundle zzc;

    public /* synthetic */ zzeqx(String str, String str2, Bundle bundle, zzeqy zzeqyVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* synthetic */ void zza(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzeub
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = ((zzcva) obj).zza;
        bundle.putString("consent_string", this.zza);
        bundle.putString("fc_consent", this.zzb);
        Bundle bundle2 = this.zzc;
        if (bundle2 != null) {
            bundle.putBundle("iab_consent_info", bundle2);
        }
    }
}
