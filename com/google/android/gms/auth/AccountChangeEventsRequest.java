package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zza(27);
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final Account zzd;

    public AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzd = account;
        } else {
            this.zzd = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        CloseableKt.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeParcelable(parcel, 4, this.zzd, i, false);
        CloseableKt.zzb(parcel, iZza);
    }
}
