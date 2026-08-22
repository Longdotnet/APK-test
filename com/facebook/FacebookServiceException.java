package com.facebook;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class FacebookServiceException extends FacebookException {
    public static final long serialVersionUID = 1;
    public final FacebookRequestError requestError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacebookServiceException(FacebookRequestError requestError, String str) {
        super(str);
        Intrinsics.checkNotNullParameter(requestError, "requestError");
        this.requestError = requestError;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder("{FacebookServiceException: httpResponseCode: ");
        FacebookRequestError facebookRequestError = this.requestError;
        sb.append(facebookRequestError.requestStatusCode);
        sb.append(", facebookErrorCode: ");
        sb.append(facebookRequestError.errorCode);
        sb.append(", facebookErrorType: ");
        sb.append(facebookRequestError.errorType);
        sb.append(", message: ");
        sb.append(facebookRequestError.getErrorMessage());
        sb.append("}");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder()\n        .append(\"{FacebookServiceException: \")\n        .append(\"httpResponseCode: \")\n        .append(requestError.requestStatusCode)\n        .append(\", facebookErrorCode: \")\n        .append(requestError.errorCode)\n        .append(\", facebookErrorType: \")\n        .append(requestError.errorType)\n        .append(\", message: \")\n        .append(requestError.errorMessage)\n        .append(\"}\")\n        .toString()");
        return string;
    }
}
