package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: loaded from: classes.dex */
final class zzac extends BaseImplementation.ApiMethodImpl<Result, zzam> {
    final /* synthetic */ boolean zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzac(zzal zzalVar, Api api, GoogleApiClient googleApiClient, boolean z) {
        super((Api<?>) api, googleApiClient);
        this.zza = z;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        return new zzaj(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        com.google.android.gms.auth.account.zze zzeVar = (com.google.android.gms.auth.account.zze) ((zzam) anyClient).getService();
        boolean z = this.zza;
        com.google.android.gms.auth.account.zzc zzcVar = (com.google.android.gms.auth.account.zzc) zzeVar;
        Parcel parcelZza = zzcVar.zza();
        zzc.zzb(parcelZza, z);
        zzcVar.zzc(1, parcelZza);
        setResult(new zzaj(Status.RESULT_SUCCESS));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        setResult((Result) obj);
    }
}
