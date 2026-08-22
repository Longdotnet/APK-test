package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbtl;
import java.util.Objects;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzai extends zzba {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbpm zzb;

    public zzai(TooltipPopup tooltipPopup, Context context, zzbpm zzbpmVar) {
        this.zza = context;
        this.zzb = zzbpmVar;
        Objects.requireNonNull(tooltipPopup);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzm(new ObjectWrapper(this.zza), this.zzb, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzc() {
        Context context = this.zza;
        ObjectWrapper objectWrapper = new ObjectWrapper(context);
        try {
            try {
                return zzbtl.zzb(ExceptionsKt.zzc(context).instantiate("com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl")).zze(objectWrapper, this.zzb, ModuleDescriptor.MODULE_VERSION);
            } catch (Exception e) {
                throw new com.google.android.gms.ads.internal.util.client.zzr(e);
            }
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
            return null;
        }
    }
}
