package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaay;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class TwitterAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzak();
    private String zza;
    private String zzb;

    public TwitterAuthCredential(String str, String str2) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zza = str;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2);
        this.zzb = str2;
    }

    public static zzaay zzb(TwitterAuthCredential twitterAuthCredential, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(twitterAuthCredential);
        return new zzaay(null, twitterAuthCredential.zza, twitterAuthCredential.getProvider(), null, twitterAuthCredential.zzb, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "twitter.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "twitter.com";
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
        return new TwitterAuthCredential(this.zza, this.zzb);
    }
}
