package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: loaded from: classes.dex */
final class zbk extends zbd {
    private final BaseImplementation.ResultHolder zba;

    public zbk(BaseImplementation.ResultHolder resultHolder) {
        this.zba = resultHolder;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbd, com.google.android.gms.internal.p000authapi.zbs
    public final void zbc(Status status) {
        this.zba.setResult(status);
    }
}
