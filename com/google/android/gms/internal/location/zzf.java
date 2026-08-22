package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;

/* JADX INFO: loaded from: classes.dex */
abstract class zzf extends com.google.android.gms.location.zzb {
    public zzf(GoogleApiClient googleApiClient) {
        super(ActivityRecognition.API, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
