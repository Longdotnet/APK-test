package com.facebook;

import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class FacebookGraphResponseException extends FacebookException {
    public final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse, String str) {
        super(str);
        this.graphResponse = graphResponse;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public final String toString() {
        GraphResponse graphResponse = this.graphResponse;
        FacebookRequestError facebookRequestError = graphResponse == null ? null : graphResponse.error;
        StringBuilder sb = new StringBuilder("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(" ");
        }
        if (facebookRequestError != null) {
            sb.append("httpResponseCode: ");
            sb.append(facebookRequestError.requestStatusCode);
            sb.append(", facebookErrorCode: ");
            sb.append(facebookRequestError.errorCode);
            sb.append(", facebookErrorType: ");
            sb.append(facebookRequestError.errorType);
            sb.append(", message: ");
            sb.append(facebookRequestError.getErrorMessage());
            sb.append(eoBKjVuj.Wyl);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "errorStringBuilder.toString()");
        return string;
    }
}
