package com.google.firebase.installations;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_InstallationTokenResult extends InstallationTokenResult {
    public final String token;
    public final long tokenCreationTimestamp;
    public final long tokenExpirationTimestamp;

    public final class Builder extends InstallationTokenResult.Builder {
        public String token;
        public Long tokenCreationTimestamp;
        public Long tokenExpirationTimestamp;

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public final InstallationTokenResult build() {
            String strM = this.token == null ? " token" : "";
            if (this.tokenExpirationTimestamp == null) {
                strM = strM.concat(" tokenExpirationTimestamp");
            }
            if (this.tokenCreationTimestamp == null) {
                strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM, " tokenCreationTimestamp");
            }
            if (strM.isEmpty()) {
                return new AutoValue_InstallationTokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.tokenCreationTimestamp.longValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(strM));
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public final InstallationTokenResult.Builder setToken(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.token = str;
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public final InstallationTokenResult.Builder setTokenCreationTimestamp(long j) {
            this.tokenCreationTimestamp = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.installations.InstallationTokenResult.Builder
        public final InstallationTokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.tokenExpirationTimestamp = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_InstallationTokenResult(String str, long j, long j2) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.tokenCreationTimestamp = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationTokenResult)) {
            return false;
        }
        InstallationTokenResult installationTokenResult = (InstallationTokenResult) obj;
        return this.token.equals(installationTokenResult.getToken()) && this.tokenExpirationTimestamp == installationTokenResult.getTokenExpirationTimestamp() && this.tokenCreationTimestamp == installationTokenResult.getTokenCreationTimestamp();
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final long getTokenCreationTimestamp() {
        return this.tokenCreationTimestamp;
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public final int hashCode() {
        int iHashCode = (this.token.hashCode() ^ 1000003) * 1000003;
        long j = this.tokenExpirationTimestamp;
        long j2 = this.tokenCreationTimestamp;
        return ((iHashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // com.google.firebase.installations.InstallationTokenResult
    public final InstallationTokenResult.Builder toBuilder() {
        Builder builder = new Builder();
        builder.token = getToken();
        builder.tokenExpirationTimestamp = Long.valueOf(getTokenExpirationTimestamp());
        builder.tokenCreationTimestamp = Long.valueOf(getTokenCreationTimestamp());
        return builder;
    }

    public final String toString() {
        return "InstallationTokenResult{token=" + this.token + ", tokenExpirationTimestamp=" + this.tokenExpirationTimestamp + ", tokenCreationTimestamp=" + this.tokenCreationTimestamp + "}";
    }
}
