package androidx.privacysandbox.ads.adservices.topics;

/* JADX INFO: loaded from: classes.dex */
public final class GetTopicsRequest {
    public final boolean shouldRecordObservation;

    public GetTopicsRequest(boolean z) {
        this.shouldRecordObservation = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) obj;
        getTopicsRequest.getClass();
        return this.shouldRecordObservation == getTopicsRequest.shouldRecordObservation;
    }

    public final int hashCode() {
        return 1169068184 + (this.shouldRecordObservation ? 1231 : 1237);
    }

    public final String toString() {
        return "GetTopicsRequest: adsSdkName=com.google.android.gms.ads, shouldRecordObservation=" + this.shouldRecordObservation;
    }
}
