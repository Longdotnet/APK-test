package com.facebook.appevents;

import com.facebook.internal.Utility;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class AccessTokenAppIdPair implements Serializable {
    private static final long serialVersionUID = 1;
    public final String accessTokenString;
    public final String applicationId;

    public final class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        public final String accessTokenString;
        public final String appId;

        public SerializationProxyV1(String str, String str2) {
            this.accessTokenString = str;
            this.appId = str2;
        }

        private final Object readResolve() {
            return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
        }
    }

    public AccessTokenAppIdPair(String str, String str2) {
        this.applicationId = str2;
        this.accessTokenString = Utility.isNullOrEmpty(str) ? null : str;
    }

    private final Object writeReplace() {
        return new SerializationProxyV1(this.accessTokenString, this.applicationId);
    }

    public final boolean equals(Object obj) {
        boolean zEquals;
        if (!(obj instanceof AccessTokenAppIdPair)) {
            return false;
        }
        AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
        String str = accessTokenAppIdPair.accessTokenString;
        String str2 = this.accessTokenString;
        if (str == null) {
            zEquals = str2 == null;
        } else {
            zEquals = str.equals(str2);
        }
        return zEquals && accessTokenAppIdPair.applicationId.equals(this.applicationId);
    }

    public final int hashCode() {
        String str = this.accessTokenString;
        return (str == null ? 0 : str.hashCode()) ^ this.applicationId.hashCode();
    }
}
