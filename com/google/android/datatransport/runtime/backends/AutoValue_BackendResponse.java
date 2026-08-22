package com.google.android.datatransport.runtime.backends;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_BackendResponse {
    public final long nextRequestWaitMillis;
    public final int status;

    public AutoValue_BackendResponse(int i, long j) {
        if (i == 0) {
            throw new NullPointerException("Null status");
        }
        this.status = i;
        this.nextRequestWaitMillis = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_BackendResponse)) {
            return false;
        }
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) obj;
        int i = autoValue_BackendResponse.status;
        int i2 = this.status;
        if (i2 != 0) {
            return (i2 == i) && this.nextRequestWaitMillis == autoValue_BackendResponse.nextRequestWaitMillis;
        }
        throw null;
    }

    public final int hashCode() {
        int iOrdinal = (Fragment$$ExternalSyntheticOutline0.ordinal(this.status) ^ 1000003) * 1000003;
        long j = this.nextRequestWaitMillis;
        return iOrdinal ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.status;
        if (i == 1) {
            str = "OK";
        } else if (i == 2) {
            str = "TRANSIENT_ERROR";
        } else if (i != 3) {
            str = i != 4 ? "null" : "INVALID_PAYLOAD";
        } else {
            str = "FATAL_ERROR";
        }
        sb.append(str);
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.nextRequestWaitMillis);
        sb.append("}");
        return sb.toString();
    }
}
