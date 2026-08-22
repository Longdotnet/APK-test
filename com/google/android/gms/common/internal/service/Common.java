package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes.dex */
public abstract class Common {
    public static final Api API;
    public static final Api.ClientKey CLIENT_KEY;
    public static final zae zaa;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        CLIENT_KEY = clientKey;
        API = new Api("Common.API", new zab(), clientKey);
        zaa = new zae();
    }
}
