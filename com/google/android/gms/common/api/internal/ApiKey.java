package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ApiKey<O extends Api.ApiOptions> {
    public final int zaa;
    public final Api zab;
    public final Api.ApiOptions zac;
    public final String zad;

    public ApiKey(Api api, Api.ApiOptions apiOptions, String str) {
        this.zab = api;
        this.zac = apiOptions;
        this.zad = str;
        this.zaa = Arrays.hashCode(new Object[]{api, apiOptions, str});
    }

    public static <O extends Api.ApiOptions> ApiKey<O> getSharedApiKey(Api<O> api, O o, String str) {
        return new ApiKey<>(api, o, str);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        return zzah.equal(this.zab, apiKey.zab) && zzah.equal(this.zac, apiKey.zac) && zzah.equal(this.zad, apiKey.zad);
    }

    public final int hashCode() {
        return this.zaa;
    }

    public final String zaa() {
        return this.zab.zad();
    }
}
