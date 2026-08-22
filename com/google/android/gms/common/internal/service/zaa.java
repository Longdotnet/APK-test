package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public abstract class zaa extends com.google.android.gms.internal.base.zab {
    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        int i3 = parcel.readInt();
        com.google.android.gms.internal.base.zac.zab(parcel);
        ((zad) this).zaa.setResult(new Status(i3));
        return true;
    }
}
