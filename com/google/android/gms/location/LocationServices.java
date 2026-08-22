package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzz;

/* JADX INFO: loaded from: classes.dex */
public abstract class LocationServices {
    public static final Api API;
    public static final Api.ClientKey zza;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        API = new Api("LocationServices.API", new zzbh(), clientKey);
        new zzz();
        new zzaf();
        new com.google.android.gms.internal.location.zzbi();
    }
}
