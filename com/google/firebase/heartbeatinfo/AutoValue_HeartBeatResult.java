package com.google.firebase.heartbeatinfo;

import com.google.android.gms.ads.jY.UUFMQdNK;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class AutoValue_HeartBeatResult extends HeartBeatResult {
    public final List usedDates;
    public final String userAgent;

    public AutoValue_HeartBeatResult(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.userAgent = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.usedDates = list;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        return this.userAgent.equals(heartBeatResult.getUserAgent()) && this.usedDates.equals(heartBeatResult.getUsedDates());
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final List getUsedDates() {
        return this.usedDates;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final String getUserAgent() {
        return this.userAgent;
    }

    public final int hashCode() {
        return ((this.userAgent.hashCode() ^ 1000003) * 1000003) ^ this.usedDates.hashCode();
    }

    public final String toString() {
        return UUFMQdNK.wrONeI + this.userAgent + ", usedDates=" + this.usedDates + "}";
    }
}
