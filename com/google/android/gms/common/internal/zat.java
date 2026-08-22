package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new com.google.android.gms.drive.zza(5);
    public final int zaa;
    public final Account zab;
    public final int zac;
    public final GoogleSignInAccount zad;

    public zat(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.zaa = i;
        this.zab = account;
        this.zac = i2;
        this.zad = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zaa);
        CloseableKt.writeParcelable(parcel, 2, this.zab, i, false);
        CloseableKt.zzc(parcel, 3, 4);
        parcel.writeInt(this.zac);
        CloseableKt.writeParcelable(parcel, 4, this.zad, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
