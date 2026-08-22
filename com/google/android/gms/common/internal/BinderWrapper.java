package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new com.google.android.gms.drive.zza(8);
    public final IBinder zza;

    public BinderWrapper(IBinder iBinder) {
        this.zza = iBinder;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zza);
    }

    public /* synthetic */ BinderWrapper(Parcel parcel) {
        this.zza = parcel.readStrongBinder();
    }
}
