package com.google.android.gms.common.api.internal;

import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zabb implements ResultCallback {
    public final /* synthetic */ StatusPendingResult zaa;
    public final /* synthetic */ boolean zab;
    public final /* synthetic */ GoogleApiClient zac;
    public final /* synthetic */ zabe zad;

    public zabb(zabe zabeVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zad = zabeVar;
        this.zaa = statusPendingResult;
        this.zab = z;
        this.zac = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(Result result) {
        Status status = (Status) result;
        zabe zabeVar = this.zad;
        Storage storage = Storage.getInstance(zabeVar.zan);
        String strZaa = storage.zaa("defaultGoogleSignInAccount");
        storage.zab("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strZaa)) {
            storage.zab(Storage.zae("googleSignInAccount", strZaa));
            storage.zab(Storage.zae("googleSignInOptions", strZaa));
        }
        if (status.isSuccess() && zabeVar.isConnected()) {
            zabeVar.disconnect();
            zabeVar.connect();
        }
        this.zaa.setResult(status);
        if (this.zab) {
            this.zac.disconnect();
        }
    }
}
