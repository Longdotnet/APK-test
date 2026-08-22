package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* JADX INFO: loaded from: classes.dex */
public final class zbai extends zba implements IInterface {
    public zbai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.ISignInService");
    }

    public final void zbc(zby zbyVar, BeginSignInRequest beginSignInRequest) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbyVar);
        zbc.zbb(parcelZba, beginSignInRequest);
        zbb(1, parcelZba);
    }

    public final void zbd(zbab zbabVar, GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest, String str) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbabVar);
        zbc.zbb(parcelZba, getPhoneNumberHintIntentRequest);
        parcelZba.writeString(str);
        zbb(4, parcelZba);
    }

    public final void zbe(zbad zbadVar, GetSignInIntentRequest getSignInIntentRequest) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbadVar);
        zbc.zbb(parcelZba, getSignInIntentRequest);
        zbb(3, parcelZba);
    }

    public final void zbf(IStatusCallback iStatusCallback, String str) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, iStatusCallback);
        parcelZba.writeString(str);
        zbb(2, parcelZba);
    }
}
