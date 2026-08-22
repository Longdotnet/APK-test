package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzblb;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzblo;
import com.google.android.gms.internal.ads.zzbpm;
import java.util.Objects;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzak extends zzba {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbpm zzb;
    public final /* synthetic */ OnH5AdsEventListener zzc;

    public zzak(TooltipPopup tooltipPopup, Context context, zzbpm zzbpmVar, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbpmVar;
        this.zzc = onH5AdsEventListener;
        Objects.requireNonNull(tooltipPopup);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* synthetic */ Object zza() {
        return new zzblo();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzl(new ObjectWrapper(this.zza), this.zzb, ModuleDescriptor.MODULE_VERSION, new zzblb(this.zzc));
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzc() {
        Context context = this.zza;
        ObjectWrapper objectWrapper = new ObjectWrapper(context);
        try {
            try {
                return zzblj.zzb(ExceptionsKt.zzc(context).instantiate("com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl")).zze(objectWrapper, this.zzb, ModuleDescriptor.MODULE_VERSION, new zzblb(this.zzc));
            } catch (Exception e) {
                throw new com.google.android.gms.ads.internal.util.client.zzr(e);
            }
        } catch (RemoteException | com.google.android.gms.ads.internal.util.client.zzr | NullPointerException unused) {
            return null;
        }
    }
}
