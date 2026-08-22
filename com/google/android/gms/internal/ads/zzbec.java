package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class zzbec extends CustomTabsCallback {
    final /* synthetic */ zzbed zza;

    public zzbec(zzbed zzbedVar) {
        Objects.requireNonNull(zzbedVar);
        this.zza = zzbedVar;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i, Bundle bundle) {
        this.zza.zze(i);
    }
}
