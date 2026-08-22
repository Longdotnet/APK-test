package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;

/* JADX INFO: loaded from: classes.dex */
public final class zbz extends zba implements IInterface {
    public zbz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ICredentialSavingService");
    }

    public final void zbc(zbaf zbafVar, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbafVar);
        zbc.zbb(parcelZba, saveAccountLinkingTokenRequest);
        zbb(1, parcelZba);
    }

    public final void zbd(zbah zbahVar, SavePasswordRequest savePasswordRequest) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbahVar);
        zbc.zbb(parcelZba, savePasswordRequest);
        zbb(2, parcelZba);
    }
}
