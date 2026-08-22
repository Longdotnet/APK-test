package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.internal.ads.zzayu;

/* JADX INFO: loaded from: classes.dex */
public final class zzft extends zzayu implements zzdq {
    public final OnAdMetadataChangedListener zza;

    public zzft(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        super("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
        this.zza = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zze();
        parcel2.writeNoException();
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zze() {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zza;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
