package com.google.firebase.installations.remote;

/* JADX INFO: loaded from: classes.dex */
public abstract class TokenResult {

    public static abstract class Builder {
        public abstract TokenResult build();

        public abstract Builder setResponseCode(ResponseCode responseCode);

        public abstract Builder setToken(String str);

        public abstract Builder setTokenExpirationTimestamp(long j);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static Builder builder() {
        AutoValue_TokenResult.Builder builder = new AutoValue_TokenResult.Builder();
        builder.tokenExpirationTimestamp = 0L;
        return builder;
    }

    public abstract ResponseCode getResponseCode();

    public abstract String getToken();

    public abstract long getTokenExpirationTimestamp();

    public abstract Builder toBuilder();
}
