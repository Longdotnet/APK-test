package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* JADX INFO: loaded from: classes.dex */
final class zzae extends BaseImplementation.ApiMethodImpl<Object, zzam> {
    final /* synthetic */ String zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzae(zzal zzalVar, Api api, GoogleApiClient googleApiClient, String str) {
        super((Api<?>) api, googleApiClient);
        this.zza = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return new zzai(status, null);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        com.google.android.gms.auth.account.zze zzeVar = (com.google.android.gms.auth.account.zze) ((zzam) anyClient).getService();
        zzad zzadVar = new zzad(this);
        String str = this.zza;
        com.google.android.gms.auth.account.zzc zzcVar = (com.google.android.gms.auth.account.zzc) zzeVar;
        Parcel parcelZza = zzcVar.zza();
        zzc.zzd(parcelZza, zzadVar);
        parcelZza.writeString(str);
        zzcVar.zzc(2, parcelZza);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        setResult((Result) obj);
    }
}
