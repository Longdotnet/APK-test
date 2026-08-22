package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaay;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class PlayGamesAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzaj();
    private final String zza;

    public PlayGamesAuthCredential(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zza = str;
    }

    public static zzaay zzb(PlayGamesAuthCredential playGamesAuthCredential, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(playGamesAuthCredential);
        return new zzaay(null, null, playGamesAuthCredential.getProvider(), null, null, playGamesAuthCredential.zza, str, null, null);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "playgames.google.com";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return "playgames.google.com";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new PlayGamesAuthCredential(this.zza);
    }
}
