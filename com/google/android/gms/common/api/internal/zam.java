package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
final class zam {
    public final int zaa;
    public final ConnectionResult zab;

    public zam(ConnectionResult connectionResult, int i) {
        zzah.checkNotNull(connectionResult);
        this.zab = connectionResult;
        this.zaa = i;
    }
}
