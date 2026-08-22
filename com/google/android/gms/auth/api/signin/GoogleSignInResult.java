package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleSignInResult implements Result {
    public final Status zba;
    public final GoogleSignInAccount zbb;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.zbb = googleSignInAccount;
        this.zba = status;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zba;
    }
}
