package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: loaded from: classes.dex */
final class zzag extends BaseImplementation.ApiMethodImpl<Result, zzam> {
    final /* synthetic */ Account zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzag(zzal zzalVar, Api api, GoogleApiClient googleApiClient, Account account) {
        super((Api<?>) api, googleApiClient);
        this.zza = account;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final Result createFailedResult(Status status) {
        return new zzak(status);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        com.google.android.gms.auth.account.zze zzeVar = (com.google.android.gms.auth.account.zze) ((zzam) anyClient).getService();
        zzaf zzafVar = new zzaf(this);
        Account account = this.zza;
        com.google.android.gms.auth.account.zzc zzcVar = (com.google.android.gms.auth.account.zzc) zzeVar;
        Parcel parcelZza = zzcVar.zza();
        zzc.zzd(parcelZza, zzafVar);
        zzc.zzc(parcelZza, account);
        zzcVar.zzc(3, parcelZza);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        setResult((Result) obj);
    }
}
