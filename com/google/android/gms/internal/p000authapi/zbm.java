package com.google.android.gms.internal.p000authapi;

import android.content.Context;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: loaded from: classes.dex */
abstract class zbm extends BaseImplementation.ApiMethodImpl {
    public zbm(GoogleApiClient googleApiClient) {
        super((Api<?>) Auth.CREDENTIALS_API, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zbo zboVar = (zbo) anyClient;
        zba(zboVar.getContext(), (zbt) zboVar.getService());
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        setResult((Result) obj);
    }

    public abstract void zba(Context context, zbt zbtVar);
}
