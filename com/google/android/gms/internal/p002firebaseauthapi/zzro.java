package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzro extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzro> CREATOR = new zzrp();
    private final PhoneAuthCredential zza;
    private final String zzb;

    public zzro(PhoneAuthCredential phoneAuthCredential, String str) {
        this.zza = phoneAuthCredential;
        this.zzb = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final PhoneAuthCredential zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
