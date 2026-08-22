package com.google.android.gms.internal.p000authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* JADX INFO: loaded from: classes.dex */
public final class zbt extends zba implements IInterface {
    public zbt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    public final void zbc(zbs zbsVar, zbp zbpVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbsVar);
        zbc.zbb(parcelZba, zbpVar);
        zbb(3, parcelZba);
    }

    public final void zbd(zbs zbsVar, CredentialRequest credentialRequest) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbsVar);
        zbc.zbb(parcelZba, credentialRequest);
        zbb(1, parcelZba);
    }

    public final void zbe(zbs zbsVar, zbu zbuVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbsVar);
        zbc.zbb(parcelZba, zbuVar);
        zbb(2, parcelZba);
    }

    public final void zbf(zbs zbsVar) {
        Parcel parcelZba = zba();
        zbc.zbc(parcelZba, zbsVar);
        zbb(4, parcelZba);
    }
}
