package com.google.firebase.auth;

/* JADX INFO: loaded from: classes.dex */
public abstract class OAuthCredential extends AuthCredential {
    public abstract String getAccessToken();

    public abstract String getIdToken();

    public abstract String getSecret();
}
