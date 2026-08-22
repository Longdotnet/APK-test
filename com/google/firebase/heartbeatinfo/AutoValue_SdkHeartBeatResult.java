package com.google.firebase.heartbeatinfo;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_SdkHeartBeatResult extends SdkHeartBeatResult {
    public final long millis;
    public final String sdkName;

    public AutoValue_SdkHeartBeatResult(String str, long j) {
        if (str == null) {
            throw new NullPointerException("Null sdkName");
        }
        this.sdkName = str;
        this.millis = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SdkHeartBeatResult)) {
            return false;
        }
        SdkHeartBeatResult sdkHeartBeatResult = (SdkHeartBeatResult) obj;
        return this.sdkName.equals(sdkHeartBeatResult.getSdkName()) && this.millis == sdkHeartBeatResult.getMillis();
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public final long getMillis() {
        return this.millis;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public final String getSdkName() {
        return this.sdkName;
    }

    public final int hashCode() {
        int iHashCode = (this.sdkName.hashCode() ^ 1000003) * 1000003;
        long j = this.millis;
        return iHashCode ^ ((int) ((j >>> 32) ^ j));
    }

    public final String toString() {
        return "SdkHeartBeatResult{sdkName=" + this.sdkName + ", millis=" + this.millis + "}";
    }
}
