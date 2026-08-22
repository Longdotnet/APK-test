package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class GetSignInIntentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetSignInIntentRequest> CREATOR = new zza(14);
    public final String zba;
    public final String zbb;
    public final String zbc;
    public final String zbd;
    public final boolean zbe;
    public final int zbf;

    public GetSignInIntentRequest(String str, String str2, String str3, String str4, boolean z, int i) {
        zzah.checkNotNull(str);
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = str4;
        this.zbe = z;
        this.zbf = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        return zzah.equal(this.zba, getSignInIntentRequest.zba) && zzah.equal(this.zbd, getSignInIntentRequest.zbd) && zzah.equal(this.zbb, getSignInIntentRequest.zbb) && zzah.equal(Boolean.valueOf(this.zbe), Boolean.valueOf(getSignInIntentRequest.zbe)) && this.zbf == getSignInIntentRequest.zbf;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbd, Boolean.valueOf(this.zbe), Integer.valueOf(this.zbf)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zba, false);
        CloseableKt.writeString(parcel, 2, this.zbb, false);
        CloseableKt.writeString(parcel, 3, this.zbc, false);
        CloseableKt.writeString(parcel, 4, this.zbd, false);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zbe ? 1 : 0);
        CloseableKt.zzc(parcel, 6, 4);
        parcel.writeInt(this.zbf);
        CloseableKt.zzb(parcel, iZza);
    }
}
