package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;

/* JADX INFO: loaded from: classes.dex */
public final class zzdwg {
    private AdRequest zza;
    private NativeAdOptions zzb;
    private VideoOptions zzc;
    private AdSize zzd = AdSize.BANNER;
    private String zze = "";
    private String zzf = "";
    private boolean zzg = false;

    public zzdwg() {
        Bundle bundle = new Bundle();
        bundle.putString("request_origin", "inspector_ooct");
        this.zza = new AdRequest((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(bundle));
    }

    public final AdRequest zza() {
        return this.zza;
    }

    public final AdSize zzb() {
        return this.zzd;
    }

    public final VideoOptions zzc() {
        return this.zzc;
    }

    public final NativeAdOptions zzd() {
        return this.zzb;
    }

    public final String zze() {
        return this.zze;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final void zzg(AdRequest adRequest) {
        this.zza = adRequest;
    }

    public final void zzh(AdSize adSize) {
        this.zzd = adSize;
    }

    public final void zzi(String str) {
        this.zze = str;
    }

    public final void zzj(String str) {
        this.zzf = str;
    }

    public final void zzk(boolean z) {
        this.zzg = z;
    }

    public final void zzl(NativeAdOptions nativeAdOptions) {
        this.zzb = nativeAdOptions;
    }

    public final void zzm(VideoOptions videoOptions) {
        this.zzc = videoOptions;
    }

    public final boolean zzn() {
        return this.zzg;
    }
}
