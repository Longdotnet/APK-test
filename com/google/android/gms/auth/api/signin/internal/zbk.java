package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zbk extends zbl {
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        zbe zbeVar = (zbe) anyClient;
        zbs zbsVar = (zbs) zbeVar.getService();
        zbh zbhVar = new zbh(this, 1);
        Parcel parcelZba = zbsVar.zba();
        com.google.android.gms.internal.p000authapi.zbc.zbc(parcelZba, zbhVar);
        com.google.android.gms.internal.p000authapi.zbc.zbb(parcelZba, zbeVar.zba);
        zbsVar.zbb(TossType.TOSS_OPEN_BALANCED_VALUE, parcelZba);
    }
}
