package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzbte implements NativeCustomFormatAd {
    private final zzbhj zza;
    private NativeCustomFormatAd.DisplayOpenMeasurement zzb;

    public zzbte(zzbhj zzbhjVar) {
        this.zza = zzbhjVar;
    }

    public final void destroy() {
        try {
            this.zza.zzl();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final String getCustomFormatId() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final NativeCustomFormatAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzb == null) {
                zzbhj zzbhjVar = this.zza;
                if (zzbhjVar.zzq()) {
                    this.zzb = new zzbsx(zzbhjVar);
                }
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        return this.zzb;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzbgp zzbgpVarZzg = this.zza.zzg(str);
            if (zzbgpVarZzg != null) {
                return new zzbsy(zzbgpVarZzg);
            }
            return null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final MediaContent getMediaContent() {
        try {
            zzbhj zzbhjVar = this.zza;
            if (zzbhjVar.zzf() != null) {
                return new com.google.android.gms.ads.internal.client.zzff(zzbhjVar.zzf(), zzbhjVar);
            }
            return null;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zza.zzj(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
            return null;
        }
    }

    public final void performClick(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
