package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new zza(10);
    public final String zba;
    public final String zbb;

    public IdToken(String str, String str2) {
        zzah.checkArgument(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        zzah.checkArgument(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.zba = str;
        this.zbb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return zzah.equal(this.zba, idToken.zba) && zzah.equal(this.zbb, idToken.zbb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zba, false);
        CloseableKt.writeString(parcel, 2, this.zbb, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
