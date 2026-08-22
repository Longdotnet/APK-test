package com.google.android.gms.common.internal.service;

import com.facebook.AccessTokenCache;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public final class zao extends GoogleApi {
    public static final Api zae = new Api("ClientTelemetry.API", new zan(), new Api.ClientKey());

    public final Task log(TelemetryData telemetryData) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(com.google.android.gms.internal.base.zaf.zaa);
        builder.setAutoResolveMissingFeatures(false);
        builder.run(new AccessTokenCache(telemetryData, 22));
        return doBestEffortWrite(builder.build());
    }
}
