package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {
    public static final SignInOptions zaa = new SignInOptions();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SignInOptions)) {
            return false;
        }
        ((SignInOptions) obj).getClass();
        return zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null);
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
