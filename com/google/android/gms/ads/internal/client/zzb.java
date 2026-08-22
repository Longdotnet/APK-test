package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayu;

/* JADX INFO: loaded from: classes.dex */
public final class zzb extends zzayu implements zzbh {
    public final zza zza;

    public zzb(zza zzaVar) {
        super("com.google.android.gms.ads.internal.client.IAdClickListener");
        this.zza = zzaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzb() {
        this.zza.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzb();
        parcel2.writeNoException();
        return true;
    }
}
