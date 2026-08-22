package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zza(21);
    public final String zba;
    public final String zbb;
    public final String zbc;
    public final String zbd;
    public final Uri zbe;
    public final String zbf;
    public final String zbg;
    public final String zbh;

    public SignInCredential(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7) {
        zzah.checkNotEmpty(str);
        this.zba = str;
        this.zbb = str2;
        this.zbc = str3;
        this.zbd = str4;
        this.zbe = uri;
        this.zbf = str5;
        this.zbg = str6;
        this.zbh = str7;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        return zzah.equal(this.zba, signInCredential.zba) && zzah.equal(this.zbb, signInCredential.zbb) && zzah.equal(this.zbc, signInCredential.zbc) && zzah.equal(this.zbd, signInCredential.zbd) && zzah.equal(this.zbe, signInCredential.zbe) && zzah.equal(this.zbf, signInCredential.zbf) && zzah.equal(this.zbg, signInCredential.zbg) && zzah.equal(this.zbh, signInCredential.zbh);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zba, false);
        CloseableKt.writeString(parcel, 2, this.zbb, false);
        CloseableKt.writeString(parcel, 3, this.zbc, false);
        CloseableKt.writeString(parcel, 4, this.zbd, false);
        CloseableKt.writeParcelable(parcel, 5, this.zbe, i, false);
        CloseableKt.writeString(parcel, 6, this.zbf, false);
        CloseableKt.writeString(parcel, 7, this.zbg, false);
        CloseableKt.writeString(parcel, 8, this.zbh, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
