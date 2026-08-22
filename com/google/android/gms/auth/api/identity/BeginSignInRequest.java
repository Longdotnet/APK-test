package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class BeginSignInRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new zza(11);
    public final PasswordRequestOptions zba;
    public final GoogleIdTokenRequestOptions zbb;
    public final String zbc;
    public final boolean zbd;
    public final int zbe;

    public final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new zza(15);
        public final boolean zba;
        public final String zbb;
        public final String zbc;
        public final boolean zbd;
        public final String zbe;
        public final ArrayList zbf;
        public final boolean zbg;

        public GoogleIdTokenRequestOptions(boolean z, String str, String str2, boolean z2, String str3, ArrayList arrayList, boolean z3) {
            boolean z4 = true;
            if (z2 && z3) {
                z4 = false;
            }
            zzah.checkArgument(z4, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.zba = z;
            if (z) {
                zzah.checkNotNull(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.zbb = str;
            this.zbc = str2;
            this.zbd = z2;
            ArrayList arrayList2 = null;
            if (arrayList != null && !arrayList.isEmpty()) {
                arrayList2 = new ArrayList(arrayList);
                Collections.sort(arrayList2);
            }
            this.zbf = arrayList2;
            this.zbe = str3;
            this.zbg = z3;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            return this.zba == googleIdTokenRequestOptions.zba && zzah.equal(this.zbb, googleIdTokenRequestOptions.zbb) && zzah.equal(this.zbc, googleIdTokenRequestOptions.zbc) && this.zbd == googleIdTokenRequestOptions.zbd && zzah.equal(this.zbe, googleIdTokenRequestOptions.zbe) && zzah.equal(this.zbf, googleIdTokenRequestOptions.zbf) && this.zbg == googleIdTokenRequestOptions.zbg;
        }

        public final int hashCode() {
            Boolean boolValueOf = Boolean.valueOf(this.zba);
            Boolean boolValueOf2 = Boolean.valueOf(this.zbd);
            Boolean boolValueOf3 = Boolean.valueOf(this.zbg);
            return Arrays.hashCode(new Object[]{boolValueOf, this.zbb, this.zbc, boolValueOf2, this.zbe, this.zbf, boolValueOf3});
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iZza = CloseableKt.zza(parcel, 20293);
            CloseableKt.zzc(parcel, 1, 4);
            parcel.writeInt(this.zba ? 1 : 0);
            CloseableKt.writeString(parcel, 2, this.zbb, false);
            CloseableKt.writeString(parcel, 3, this.zbc, false);
            CloseableKt.zzc(parcel, 4, 4);
            parcel.writeInt(this.zbd ? 1 : 0);
            CloseableKt.writeString(parcel, 5, this.zbe, false);
            CloseableKt.writeStringList(parcel, 6, this.zbf);
            CloseableKt.zzc(parcel, 7, 4);
            parcel.writeInt(this.zbg ? 1 : 0);
            CloseableKt.zzb(parcel, iZza);
        }
    }

    public final class PasswordRequestOptions extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new zza(16);
        public final boolean zba;

        public PasswordRequestOptions(boolean z) {
            this.zba = z;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof PasswordRequestOptions) && this.zba == ((PasswordRequestOptions) obj).zba;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zba)});
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iZza = CloseableKt.zza(parcel, 20293);
            CloseableKt.zzc(parcel, 1, 4);
            parcel.writeInt(this.zba ? 1 : 0);
            CloseableKt.zzb(parcel, iZza);
        }
    }

    public BeginSignInRequest(PasswordRequestOptions passwordRequestOptions, GoogleIdTokenRequestOptions googleIdTokenRequestOptions, String str, boolean z, int i) {
        zzah.checkNotNull(passwordRequestOptions);
        this.zba = passwordRequestOptions;
        zzah.checkNotNull(googleIdTokenRequestOptions);
        this.zbb = googleIdTokenRequestOptions;
        this.zbc = str;
        this.zbd = z;
        this.zbe = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        return zzah.equal(this.zba, beginSignInRequest.zba) && zzah.equal(this.zbb, beginSignInRequest.zbb) && zzah.equal(this.zbc, beginSignInRequest.zbc) && this.zbd == beginSignInRequest.zbd && this.zbe == beginSignInRequest.zbe;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zba, this.zbb, this.zbc, Boolean.valueOf(this.zbd)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 1, this.zba, i, false);
        CloseableKt.writeParcelable(parcel, 2, this.zbb, i, false);
        CloseableKt.writeString(parcel, 3, this.zbc, false);
        CloseableKt.zzc(parcel, 4, 4);
        parcel.writeInt(this.zbd ? 1 : 0);
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(this.zbe);
        CloseableKt.zzb(parcel, iZza);
    }
}
