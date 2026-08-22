package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: loaded from: classes.dex */
public abstract class zad {
    public static final zaa zac;
    public static final Api zag;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        Api.ClientKey clientKey2 = new Api.ClientKey();
        zaa zaaVar = new zaa();
        zac = zaaVar;
        zab zabVar = new zab();
        new Scope("profile");
        new Scope("email");
        zag = new Api("SignIn.API", zaaVar, clientKey);
        new Api("SignIn.INTERNAL_API", zabVar, clientKey2);
    }
}
