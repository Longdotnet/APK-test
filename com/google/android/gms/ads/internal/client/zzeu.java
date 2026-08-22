package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.initialization.AdapterStatus;

/* JADX INFO: loaded from: classes.dex */
public final class zzeu implements AdapterStatus {
    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final String getDescription() {
        return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
    }

    @Override // com.google.android.gms.ads.initialization.AdapterStatus
    public final int getLatency() {
        return 0;
    }
}
