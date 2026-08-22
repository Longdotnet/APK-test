package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

/* JADX INFO: loaded from: classes.dex */
public final class zzbtd {
    private final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    private final NativeCustomFormatAd.OnCustomClickListener zzb;
    private NativeCustomFormatAd zzc;

    public zzbtd(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
    }

    public static /* bridge */ /* synthetic */ NativeCustomFormatAd.OnCustomClickListener zzc(zzbtd zzbtdVar) {
        zzbtdVar.getClass();
        return null;
    }

    public static /* bridge */ /* synthetic */ NativeCustomFormatAd.OnCustomFormatAdLoadedListener zzd(zzbtd zzbtdVar) {
        zzbtdVar.getClass();
        return null;
    }

    public final synchronized NativeCustomFormatAd zzf(zzbhj zzbhjVar) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzbte zzbteVar = new zzbte(zzbhjVar);
        this.zzc = zzbteVar;
        return zzbteVar;
    }

    public final zzbht zza() {
        return null;
    }

    public final zzbhw zzb() {
        return new zzbtb(this, null);
    }
}
