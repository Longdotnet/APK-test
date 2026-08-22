package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaay;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class GithubAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzab();
    private String zza;

    public GithubAuthCredential(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zza = str;
    }

    public static zzaay zzb(GithubAuthCredential githubAuthCredential, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(githubAuthCredential);
        return new zzaay(null, githubAuthCredential.zza, githubAuthCredential.getProvider(), null, null, null, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "github.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "github.com";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new GithubAuthCredential(this.zza);
    }
}
