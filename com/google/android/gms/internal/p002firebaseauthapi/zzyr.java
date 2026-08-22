package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.OnFailureListener;

/* JADX INFO: loaded from: classes.dex */
final class zzyr implements OnFailureListener {
    public zzyr(zzyv zzyvVar) {
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        zzyv.zza.e("SmsRetrieverClient failed to start: ".concat(String.valueOf(exc.getMessage())), new Object[0]);
    }
}
