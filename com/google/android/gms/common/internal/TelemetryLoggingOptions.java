package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class TelemetryLoggingOptions implements Api.ApiOptions.Optional {
    public static final TelemetryLoggingOptions zaa = new TelemetryLoggingOptions();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TelemetryLoggingOptions)) {
            return false;
        }
        ((TelemetryLoggingOptions) obj).getClass();
        return zzah.equal(null, null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null});
    }
}
