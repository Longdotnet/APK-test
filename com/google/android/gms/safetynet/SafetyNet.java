package com.google.android.gms.safetynet;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.safetynet.zzy;

/* JADX INFO: loaded from: classes.dex */
public abstract class SafetyNet {
    public static final Api API = new Api("SafetyNet.API", new zzk(), new Api.ClientKey());

    static {
        new com.google.android.gms.internal.safetynet.zzk();
        new zzy();
    }
}
