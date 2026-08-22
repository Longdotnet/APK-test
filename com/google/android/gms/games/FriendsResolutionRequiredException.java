package com.google.android.gms.games;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class FriendsResolutionRequiredException extends ResolvableApiException {
    public static FriendsResolutionRequiredException zza(Status status) {
        return new FriendsResolutionRequiredException(status);
    }
}
