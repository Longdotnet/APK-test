package com.google.android.gms.ads.internal.client;

import android.content.Context;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbpm;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzao extends zzba {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzr zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzbpm zzd;
    public final /* synthetic */ TooltipPopup zze;

    public zzao(TooltipPopup tooltipPopup, Context context, zzr zzrVar, String str, zzbpm zzbpmVar) {
        this.zza = context;
        this.zzb = zzrVar;
        this.zzc = str;
        this.zzd = zzbpmVar;
        Objects.requireNonNull(tooltipPopup);
        this.zze = tooltipPopup;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zza() {
        TooltipPopup.zzv(this.zza, "interstitial");
        return new zzfm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zze(new ObjectWrapper(this.zza), this.zzb, this.zzc, this.zzd, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() {
        zzk zzkVar = (zzk) this.zze.mContext;
        zzbpm zzbpmVar = this.zzd;
        return zzkVar.zza(this.zza, this.zzb, this.zzc, zzbpmVar, 2);
    }
}
