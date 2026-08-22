package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzg extends zzw implements zzh {
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

    public zzg() {
        super(eoBKjVuj.HmyWknNF);
    }
}
