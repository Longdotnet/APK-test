package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzo extends zzw implements zzp {
    public zzo() {
        super("com.android.vending.billing.IInAppBillingIsExternalPaymentAvailableCallback");
    }

    @Override // com.google.android.gms.internal.play_billing.zzw
    public final boolean zzb(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzx.zza(parcel, Bundle.CREATOR);
        zzx.zzb(parcel);
        zza(bundle);
        return true;
    }
}
