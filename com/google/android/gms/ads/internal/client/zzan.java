package com.google.android.gms.ads.internal.client;

import android.content.Context;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzan extends zzba {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzr zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ TooltipPopup zzd;

    public zzan(TooltipPopup tooltipPopup, Context context, zzr zzrVar, String str) {
        this.zza = context;
        this.zzb = zzrVar;
        this.zzc = str;
        Objects.requireNonNull(tooltipPopup);
        this.zzd = tooltipPopup;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zza() {
        TooltipPopup.zzv(this.zza, FirebaseAnalytics.Event.SEARCH);
        return new zzfm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzf(new ObjectWrapper(this.zza), this.zzb, this.zzc, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() {
        return ((zzk) this.zzd.mContext).zza(this.zza, this.zzb, this.zzc, null, 3);
    }
}
