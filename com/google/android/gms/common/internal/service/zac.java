package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import com.google.android.gms.common.api.Api;

/* JADX INFO: loaded from: classes.dex */
public final class zac extends zaf {
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        zal zalVar = (zal) ((zah) anyClient).getService();
        zad zadVar = new zad(this);
        Parcel parcelZaa = zalVar.zaa();
        com.google.android.gms.internal.base.zac.zad(parcelZaa, zadVar);
        zalVar.zad(1, parcelZaa);
    }
}
