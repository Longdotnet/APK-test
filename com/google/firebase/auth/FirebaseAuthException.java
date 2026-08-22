package com.google.firebase.auth;

import com.google.firebase.FirebaseException;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseAuthException extends FirebaseException {
    private final String zza;

    public FirebaseAuthException(String str, String str2) {
        super(str2);
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zza = str;
    }

    public String getErrorCode() {
        return this.zza;
    }
}
