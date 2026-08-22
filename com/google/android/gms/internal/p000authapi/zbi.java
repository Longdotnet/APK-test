package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zbi extends zbm {
    final /* synthetic */ Credential zba;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zbi(zbl zblVar, GoogleApiClient googleApiClient, Credential credential) {
        super(googleApiClient);
        this.zba = credential;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.internal.p000authapi.zbm
    public final void zba(Context context, zbt zbtVar) {
        zbtVar.zbc(new zbk(this), new zbp(this.zba));
    }
}
