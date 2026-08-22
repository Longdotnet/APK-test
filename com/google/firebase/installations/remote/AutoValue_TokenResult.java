package com.google.firebase.installations.remote;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_TokenResult extends TokenResult {
    public final TokenResult.ResponseCode responseCode;
    public final String token;
    public final long tokenExpirationTimestamp;

    public final class Builder extends TokenResult.Builder {
        public TokenResult.ResponseCode responseCode;
        public String token;
        public Long tokenExpirationTimestamp;

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult build() {
            String str = this.tokenExpirationTimestamp == null ? " tokenExpirationTimestamp" : "";
            if (str.isEmpty()) {
                return new AutoValue_TokenResult(this.token, this.tokenExpirationTimestamp.longValue(), this.responseCode);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult.Builder setResponseCode(TokenResult.ResponseCode responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult.Builder setToken(String str) {
            this.token = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.Builder
        public final TokenResult.Builder setTokenExpirationTimestamp(long j) {
            this.tokenExpirationTimestamp = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_TokenResult(String str, long j, TokenResult.ResponseCode responseCode) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = responseCode;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.token;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.tokenExpirationTimestamp == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.responseCode;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final TokenResult.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public final int hashCode() {
        String str = this.token;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.tokenExpirationTimestamp;
        int i = (((iHashCode ^ 1000003) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003;
        TokenResult.ResponseCode responseCode = this.responseCode;
        return (responseCode != null ? responseCode.hashCode() : 0) ^ i;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final TokenResult.Builder toBuilder() {
        Builder builder = new Builder();
        builder.token = getToken();
        builder.tokenExpirationTimestamp = Long.valueOf(getTokenExpirationTimestamp());
        builder.responseCode = getResponseCode();
        return builder;
    }

    public final String toString() {
        return "TokenResult{token=" + this.token + ", tokenExpirationTimestamp=" + this.tokenExpirationTimestamp + ", responseCode=" + this.responseCode + "}";
    }
}
