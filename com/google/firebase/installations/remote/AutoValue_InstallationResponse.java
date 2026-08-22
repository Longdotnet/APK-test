package com.google.firebase.installations.remote;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_InstallationResponse extends InstallationResponse {
    public final TokenResult authToken;
    public final String fid;
    public final String refreshToken;
    public final InstallationResponse.ResponseCode responseCode;
    public final String uri;

    public final class Builder extends InstallationResponse.Builder {
        public TokenResult authToken;
        public String fid;
        public String refreshToken;
        public InstallationResponse.ResponseCode responseCode;
        public String uri;

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse build() {
            return new AutoValue_InstallationResponse(this.uri, this.fid, this.refreshToken, this.authToken, this.responseCode);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setAuthToken(TokenResult tokenResult) {
            this.authToken = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setFid(String str) {
            this.fid = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setRefreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setResponseCode(InstallationResponse.ResponseCode responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.Builder
        public final InstallationResponse.Builder setUri(String str) {
            this.uri = str;
            return this;
        }
    }

    public AutoValue_InstallationResponse(String str, String str2, String str3, TokenResult tokenResult, InstallationResponse.ResponseCode responseCode) {
        this.uri = str;
        this.fid = str2;
        this.refreshToken = str3;
        this.authToken = tokenResult;
        this.responseCode = responseCode;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.uri;
        if (str != null ? str.equals(installationResponse.getUri()) : installationResponse.getUri() == null) {
            String str2 = this.fid;
            if (str2 != null ? str2.equals(installationResponse.getFid()) : installationResponse.getFid() == null) {
                String str3 = this.refreshToken;
                if (str3 != null ? str3.equals(installationResponse.getRefreshToken()) : installationResponse.getRefreshToken() == null) {
                    TokenResult tokenResult = this.authToken;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.getAuthToken()) : installationResponse.getAuthToken() == null) {
                        InstallationResponse.ResponseCode responseCode = this.responseCode;
                        if (responseCode == null) {
                            if (installationResponse.getResponseCode() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.getResponseCode())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final TokenResult getAuthToken() {
        return this.authToken;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getFid() {
        return this.fid;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getRefreshToken() {
        return this.refreshToken;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final InstallationResponse.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final String getUri() {
        return this.uri;
    }

    public final int hashCode() {
        String str = this.uri;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.fid;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.refreshToken;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.authToken;
        int iHashCode4 = (iHashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.responseCode;
        return (responseCode != null ? responseCode.hashCode() : 0) ^ iHashCode4;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    public final InstallationResponse.Builder toBuilder() {
        Builder builder = new Builder();
        builder.uri = getUri();
        builder.fid = getFid();
        builder.refreshToken = getRefreshToken();
        builder.authToken = getAuthToken();
        builder.responseCode = getResponseCode();
        return builder;
    }

    public final String toString() {
        return "InstallationResponse{uri=" + this.uri + ", fid=" + this.fid + ", refreshToken=" + this.refreshToken + ", authToken=" + this.authToken + ", responseCode=" + this.responseCode + "}";
    }
}
