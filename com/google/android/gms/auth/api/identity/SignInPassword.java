package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class SignInPassword extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInPassword> CREATOR = new zza(22);
    public final String zba;
    public final String zbb;

    public SignInPassword(String str, String str2) {
        zzah.checkNotNull(str, "Account identifier cannot be null");
        String strTrim = str.trim();
        zzah.checkNotEmpty(strTrim, "Account identifier cannot be empty");
        this.zba = strTrim;
        zzah.checkNotEmpty(str2);
        this.zbb = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInPassword)) {
            return false;
        }
        SignInPassword signInPassword = (SignInPassword) obj;
        return zzah.equal(this.zba, signInPassword.zba) && zzah.equal(this.zbb, signInPassword.zbb);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zba, false);
        CloseableKt.writeString(parcel, 2, this.zbb, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
