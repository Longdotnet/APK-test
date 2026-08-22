package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class AuthProxyOptions implements Api.ApiOptions.Optional {
    public static final AuthProxyOptions zza = new AuthProxyOptions(new Bundle());
    public final Bundle zzb;

    public /* synthetic */ AuthProxyOptions(Bundle bundle) {
        this.zzb = bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AuthProxyOptions)) {
            return false;
        }
        Bundle bundle = ((AuthProxyOptions) obj).zzb;
        Bundle bundle2 = this.zzb;
        if (bundle2 == null || bundle == null) {
            if (bundle2 == bundle) {
                return true;
            }
        } else if (bundle2.size() == bundle.size()) {
            Set<String> setKeySet = bundle2.keySet();
            if (setKeySet.containsAll(bundle.keySet())) {
                for (String str : setKeySet) {
                    if (!zzah.equal(bundle2.get(str), bundle.get(str))) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb});
    }
}
