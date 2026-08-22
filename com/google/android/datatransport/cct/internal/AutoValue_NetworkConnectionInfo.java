package com.google.android.datatransport.cct.internal;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {
    public final NetworkConnectionInfo.MobileSubtype mobileSubtype;
    public final NetworkConnectionInfo.NetworkType networkType;

    public AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.networkType = networkType;
        this.mobileSubtype = mobileSubtype;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.networkType;
        if (networkType != null ? networkType.equals(((AutoValue_NetworkConnectionInfo) networkConnectionInfo).networkType) : ((AutoValue_NetworkConnectionInfo) networkConnectionInfo).networkType == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
            if (mobileSubtype == null) {
                if (((AutoValue_NetworkConnectionInfo) networkConnectionInfo).mobileSubtype == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(((AutoValue_NetworkConnectionInfo) networkConnectionInfo).mobileSubtype)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.networkType;
        int iHashCode = ((networkType == null ? 0 : networkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
        return (mobileSubtype != null ? mobileSubtype.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.networkType + ", mobileSubtype=" + this.mobileSubtype + "}";
    }
}
