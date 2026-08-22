package com.google.android.gms.auth.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzbt;

/* JADX INFO: loaded from: classes.dex */
public abstract class AuthProxy {
    public static final Api API = new Api("Auth.PROXY_API", new zza(), new Api.ClientKey());

    static {
        new zzbt();
    }
}
