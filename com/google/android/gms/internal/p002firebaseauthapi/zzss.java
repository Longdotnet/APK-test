package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.auth.EmailAuthCredential;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzss extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzss> CREATOR = new zzst();
    private final EmailAuthCredential zza;

    public zzss(EmailAuthCredential emailAuthCredential) {
        this.zza = emailAuthCredential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zza, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final EmailAuthCredential zza() {
        return this.zza;
    }
}
