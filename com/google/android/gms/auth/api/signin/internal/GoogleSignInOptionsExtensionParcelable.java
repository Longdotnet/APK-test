package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zza(25);
    public final int zaa;
    public final int zab;
    public final Bundle zac;

    public GoogleSignInOptionsExtensionParcelable(int i, int i2, Bundle bundle) {
        this.zaa = i;
        this.zab = i2;
        this.zac = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zab);
        CloseableKt.writeBundle(parcel, 3, this.zac, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
