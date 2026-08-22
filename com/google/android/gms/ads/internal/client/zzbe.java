package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;

/* JADX INFO: loaded from: classes.dex */
public final class zzbe extends zzayu implements zzcv {
    public final FullScreenContentCallback zza;

    public zzbe(FullScreenContentCallback fullScreenContentCallback) {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
        this.zza = fullScreenContentCallback;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzb() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzc() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdDismissedFullScreenContent();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzd(zze zzeVar) {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdFailedToShowFullScreenContent(zzeVar.zza());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zze zzeVar = (zze) zzayv.zza(parcel, zze.CREATOR);
            zzayv.zzd(parcel);
            zzd(zzeVar);
        } else if (i == 2) {
            zzf();
        } else if (i == 3) {
            zzc();
        } else if (i != 4 && i != 5) {
            return false;
        }
        parcel2.writeNoException();
        return true;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zze() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzcv
    public final void zzf() {
        FullScreenContentCallback fullScreenContentCallback = this.zza;
        if (fullScreenContentCallback != null) {
            fullScreenContentCallback.onAdShowedFullScreenContent();
        }
    }
}
