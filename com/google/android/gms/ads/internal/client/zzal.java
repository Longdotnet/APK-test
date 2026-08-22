package com.google.android.gms.ads.internal.client;

import android.content.Context;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbpq;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzal extends zzba {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzr zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzbpq zzd;
    public final /* synthetic */ TooltipPopup zze;

    public zzal(TooltipPopup tooltipPopup, Context context, zzr zzrVar, String str, zzbpq zzbpqVar) {
        this.zza = context;
        this.zzb = zzrVar;
        this.zzc = str;
        this.zzd = zzbpqVar;
        Objects.requireNonNull(tooltipPopup);
        this.zze = tooltipPopup;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zza() {
        TooltipPopup.zzv(this.zza, "banner");
        return new zzfm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzd(new ObjectWrapper(this.zza), this.zzb, this.zzc, this.zzd, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() {
        return ((zzk) this.zze.mContext).zza(this.zza, this.zzb, this.zzc, this.zzd, 1);
    }
}
