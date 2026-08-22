package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: loaded from: classes.dex */
public abstract class AuthCredential extends AbstractSafeParcelable {
    public abstract String getProvider();

    public abstract String getSignInMethod();

    public abstract AuthCredential zza();
}
