package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
final class zzr extends zzk.zze {
    private final /* synthetic */ String zzac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzr(zzk zzkVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzac = str;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzi) ((zzx) anyClient).getService()).zza(this.zzaf, this.zzac);
    }
}
