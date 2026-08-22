package com.google.android.gms.ads.internal.client;

import android.content.Context;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbxh;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaa extends zzba {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbpm zzc;

    public zzaa(TooltipPopup tooltipPopup, Context context, String str, zzbpm zzbpmVar) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbpmVar;
        Objects.requireNonNull(tooltipPopup);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzp(new ObjectWrapper(this.zza), this.zzb, this.zzc, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zzc() {
        return zzbxh.zza(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zza() {
        TooltipPopup.zzv(this.zza, gZrKCJ.ZstPMe);
        return new zzfs();
    }
}
