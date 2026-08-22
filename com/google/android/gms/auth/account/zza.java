package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zza extends com.google.android.gms.internal.auth.zzb implements zzb {
    @Override // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zzb((Account) com.google.android.gms.internal.auth.zzc.zza(parcel, Account.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zzc(com.google.android.gms.internal.auth.zzc.zze(parcel));
        }
        return true;
    }
}
