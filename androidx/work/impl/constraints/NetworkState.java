package androidx.work.impl.constraints;

/* JADX INFO: loaded from: classes.dex */
public final class NetworkState {
    public boolean mIsConnected;
    public boolean mIsMetered;
    public boolean mIsNotRoaming;
    public boolean mIsValidated;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.mIsConnected == networkState.mIsConnected && this.mIsValidated == networkState.mIsValidated && this.mIsMetered == networkState.mIsMetered && this.mIsNotRoaming == networkState.mIsNotRoaming;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean, int] */
    public final int hashCode() {
        boolean z = this.mIsValidated;
        ?? r1 = this.mIsConnected;
        int i = r1;
        if (z) {
            i = r1 + 16;
        }
        int i2 = i;
        if (this.mIsMetered) {
            i2 = i + 256;
        }
        return this.mIsNotRoaming ? i2 + 4096 : i2;
    }

    public final String toString() {
        return "[ Connected=" + this.mIsConnected + " Validated=" + this.mIsValidated + " Metered=" + this.mIsMetered + " NotRoaming=" + this.mIsNotRoaming + " ]";
    }
}
