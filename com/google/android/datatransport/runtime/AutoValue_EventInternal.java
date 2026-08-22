package com.google.android.datatransport.runtime;

import androidx.core.text.jp.CyjpdoedCdLTIO;
import java.util.HashMap;
import okhttp3.Request;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoValue_EventInternal {
    public final HashMap autoMetadata;
    public final Integer code;
    public final EncodedPayload encodedPayload;
    public final long eventMillis;
    public final String transportName;
    public final long uptimeMillis;

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload, long j, long j2, HashMap map) {
        this.transportName = str;
        this.code = num;
        this.encodedPayload = encodedPayload;
        this.eventMillis = j;
        this.uptimeMillis = j2;
        this.autoMetadata = map;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_EventInternal)) {
            return false;
        }
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) obj;
        if (this.transportName.equals(autoValue_EventInternal.transportName)) {
            Integer num = autoValue_EventInternal.code;
            Integer num2 = this.code;
            if (num2 != null ? num2.equals(num) : num == null) {
                if (this.encodedPayload.equals(autoValue_EventInternal.encodedPayload) && this.eventMillis == autoValue_EventInternal.eventMillis && this.uptimeMillis == autoValue_EventInternal.uptimeMillis && this.autoMetadata.equals(autoValue_EventInternal.autoMetadata)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String get(String str) {
        String str2 = (String) this.autoMetadata.get(str);
        return str2 == null ? "" : str2;
    }

    public final int getInteger(String str) {
        String str2 = (String) this.autoMetadata.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final int hashCode() {
        int iHashCode = (this.transportName.hashCode() ^ 1000003) * 1000003;
        Integer num = this.code;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.encodedPayload.hashCode()) * 1000003;
        long j = this.eventMillis;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.uptimeMillis;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.autoMetadata.hashCode();
    }

    public final Request toBuilder() {
        Request request = new Request(2);
        String str = this.transportName;
        if (str == null) {
            throw new NullPointerException("Null transportName");
        }
        request.method = str;
        request.lazyCacheControl = this.code;
        EncodedPayload encodedPayload = this.encodedPayload;
        if (encodedPayload == null) {
            throw new NullPointerException("Null encodedPayload");
        }
        request.url = encodedPayload;
        request.headers = Long.valueOf(this.eventMillis);
        request.body = Long.valueOf(this.uptimeMillis);
        request.tags = new HashMap(this.autoMetadata);
        return request;
    }

    public final String toString() {
        return "EventInternal{transportName=" + this.transportName + ", code=" + this.code + CyjpdoedCdLTIO.mUwHSiFdwsIcPqt + this.encodedPayload + ", eventMillis=" + this.eventMillis + ", uptimeMillis=" + this.uptimeMillis + ", autoMetadata=" + this.autoMetadata + "}";
    }
}
