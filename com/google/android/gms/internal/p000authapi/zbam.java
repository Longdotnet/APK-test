package com.google.android.gms.internal.p000authapi;

import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes.dex */
final class zbam extends zbae {
    final /* synthetic */ TaskCompletionSource zba;

    public zbam(zbao zbaoVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbaf
    public final void zbb(Status status, SaveAccountLinkingTokenResult saveAccountLinkingTokenResult) {
        if (status.isSuccess()) {
            this.zba.setResult(saveAccountLinkingTokenResult);
        } else {
            this.zba.setException(zzah.fromStatus(status));
        }
    }
}
