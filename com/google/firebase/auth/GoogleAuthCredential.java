package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaay;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class GoogleAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GoogleAuthCredential> CREATOR = new zzac();
    private final String zza;
    private final String zzb;

    public GoogleAuthCredential(String str, String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        if (str != null && str.length() == 0) {
            throw new IllegalArgumentException("idToken cannot be empty");
        }
        if (str2 != null && str2.length() == 0) {
            throw new IllegalArgumentException("accessToken cannot be empty");
        }
        this.zza = str;
        this.zzb = str2;
    }

    public static zzaay zzb(GoogleAuthCredential googleAuthCredential, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(googleAuthCredential);
        return new zzaay(googleAuthCredential.zza, googleAuthCredential.zzb, googleAuthCredential.getProvider(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "google.com";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new GoogleAuthCredential(this.zza, this.zzb);
    }
}
