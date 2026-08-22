package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzg();
    private String zza;
    private String zzb;
    private final String zzc;
    private String zzd;
    private boolean zze;

    public EmailAuthCredential(String str, String str2, String str3, String str4, boolean z) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        this.zza = str;
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
        }
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = z;
    }

    public static boolean zzi(String str) {
        ActionCodeUrl link;
        return (TextUtils.isEmpty(str) || (link = ActionCodeUrl.parseLink(str)) == null || link.getOperation() != 4) ? false : true;
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getProvider() {
        return "password";
    }

    @Override // com.google.firebase.auth.AuthCredential
    public String getSignInMethod() {
        return !TextUtils.isEmpty(this.zzb) ? "password" : EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, this.zza, false);
        CloseableKt.writeString(parcel, 2, this.zzb, false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, this.zzd, false);
        boolean z = this.zze;
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(z ? 1 : 0);
        CloseableKt.zzb(parcel, iZza);
    }

    @Override // com.google.firebase.auth.AuthCredential
    public final AuthCredential zza() {
        return new EmailAuthCredential(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final EmailAuthCredential zzb(FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zzf();
        this.zze = true;
        return this;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zza;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        return !TextUtils.isEmpty(this.zzc);
    }

    public final boolean zzh() {
        return this.zze;
    }
}
