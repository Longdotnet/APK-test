package com.google.firebase.auth;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiFactorInfo extends AbstractSafeParcelable {
    public static final String FACTOR_ID_KEY = "factorIdKey";

    public abstract String getDisplayName();

    public abstract long getEnrollmentTimestamp();

    public abstract String getFactorId();

    public abstract String getUid();

    public abstract JSONObject toJson();
}
