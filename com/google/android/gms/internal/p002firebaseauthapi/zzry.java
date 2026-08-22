package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzry extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzry> CREATOR = new zzrz();
    private final String zza;
    private final PhoneAuthCredential zzb;

    public zzry(String str, PhoneAuthCredential phoneAuthCredential) {
        this.zza = str;
        this.zzb = phoneAuthCredential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeParcelable(parcel, 2, this.zzb, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final PhoneAuthCredential zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
