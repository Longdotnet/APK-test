package com.google.android.gms.ads.rewarded;

import com.facebook.internal.FetchedAppSettings;

/* JADX INFO: loaded from: classes.dex */
public final class ServerSideVerificationOptions {
    public final String zza;
    public final String zzb;

    public /* synthetic */ ServerSideVerificationOptions(FetchedAppSettings.DialogFeatureConfig dialogFeatureConfig) {
        this.zza = dialogFeatureConfig.dialogName;
        this.zzb = dialogFeatureConfig.featureName;
    }
}
