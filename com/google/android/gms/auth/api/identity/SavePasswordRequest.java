package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class SavePasswordRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SavePasswordRequest> CREATOR = new zza(19);
    public final SignInPassword zba;
    public final String zbb;
    public final int zbc;

    public SavePasswordRequest(SignInPassword signInPassword, String str, int i) {
        zzah.checkNotNull(signInPassword);
        this.zba = signInPassword;
        this.zbb = str;
        this.zbc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SavePasswordRequest)) {
            return false;
        }
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
        return zzah.equal(this.zba, savePasswordRequest.zba) && zzah.equal(this.zbb, savePasswordRequest.zbb) && this.zbc == savePasswordRequest.zbc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zba, i, false);
        CloseableKt.writeString(parcel, 2, this.zbb, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zbc);
        CloseableKt.zzb(parcel, iZza);
    }
}
