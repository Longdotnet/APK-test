package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes2.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zab(2);
    public String zba;
    public String zbb;
    public GoogleSignInAccount zbc;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 4, this.zba, false);
        CloseableKt.writeParcelable(parcel, 7, this.zbc, i, false);
        CloseableKt.writeString(parcel, 8, this.zbb, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
