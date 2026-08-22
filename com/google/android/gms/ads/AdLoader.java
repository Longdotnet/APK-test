package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.internal.client.zzaq;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzek;
import com.google.android.gms.ads.internal.client.zzfi;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzgc;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbpm;

/* JADX INFO: loaded from: classes.dex */
public final class AdLoader {
    public final Context zzb;
    public final zzbq zzc;

    public final class Builder {
        public final Context zza;
        public final zzbt zzb;

        public Builder(Context context, String str) {
            zzah.checkNotNull(context, "context cannot be null");
            TooltipPopup tooltipPopup = zzbb.zzb.zzd;
            zzbpm zzbpmVar = new zzbpm();
            tooltipPopup.getClass();
            zzbt zzbtVar = (zzbt) new zzaq(tooltipPopup, context, str, zzbpmVar).zzd(context, false);
            this.zza = context;
            this.zzb = zzbtVar;
        }

        public final AdLoader build() {
            Context context = this.zza;
            try {
                return new AdLoader(context, this.zzb.zze());
            } catch (RemoteException e) {
                zzo.zzh("Failed to build AdLoader.", e);
                return new AdLoader(context, new zzfi(new zzfk()));
            }
        }

        public final void withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                zzbt zzbtVar = this.zzb;
                boolean z = nativeAdOptions.zza;
                boolean z2 = nativeAdOptions.zzc;
                int i = nativeAdOptions.zzd;
                VideoOptions videoOptions = nativeAdOptions.zze;
                zzbtVar.zzo(new zzbge(4, z, -1, z2, i, videoOptions != null ? new zzgc(videoOptions) : null, nativeAdOptions.zzf, nativeAdOptions.zzb, nativeAdOptions.zzh, nativeAdOptions.zzg, nativeAdOptions.zzi - 1));
            } catch (RemoteException e) {
                zzo.zzk("Failed to specify native ad options", e);
            }
        }
    }

    public AdLoader(Context context, zzbq zzbqVar) {
        this.zzb = context;
        this.zzc = zzbqVar;
    }

    public final void loadAd(AdRequest adRequest) {
        zzek zzekVar = adRequest.zza;
        Context context = this.zzb;
        zzbde.zza(context);
        if (((Boolean) zzbfc.zzc.zze()).booleanValue()) {
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb.execute(new zza(this, zzekVar, 0));
                return;
            }
        }
        try {
            this.zzc.zzg(zzq.zza(context, zzekVar));
        } catch (RemoteException e) {
            zzo.zzh("Failed to load ad.", e);
        }
    }
}
