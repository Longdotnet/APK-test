package com.google.android.datatransport.cct.internal;

import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoValue_ClientInfo extends ClientInfo {
    public final AutoValue_AndroidClientInfo androidClientInfo;

    public AutoValue_ClientInfo(AutoValue_AndroidClientInfo autoValue_AndroidClientInfo) {
        this.androidClientInfo = autoValue_AndroidClientInfo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        Object obj2 = ClientInfo.ClientType.ANDROID_FIREBASE;
        ((AutoValue_ClientInfo) clientInfo).getClass();
        return obj2.equals(obj2) && this.androidClientInfo.equals(((AutoValue_ClientInfo) clientInfo).androidClientInfo);
    }

    public final int hashCode() {
        return ((ClientInfo.ClientType.ANDROID_FIREBASE.hashCode() ^ 1000003) * 1000003) ^ this.androidClientInfo.hashCode();
    }

    public final String toString() {
        return RDFWIi.KjeUtdJDabz + ClientInfo.ClientType.ANDROID_FIREBASE + ", androidClientInfo=" + this.androidClientInfo + "}";
    }
}
