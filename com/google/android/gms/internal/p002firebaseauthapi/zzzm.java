package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.login.vu.dLDI;

/* JADX INFO: loaded from: classes2.dex */
public enum zzzm {
    REFRESH_TOKEN("refresh_token"),
    AUTHORIZATION_CODE(dLDI.loNj);

    private final String zzd;

    zzzm(String str) {
        this.zzd = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zzd;
    }
}
