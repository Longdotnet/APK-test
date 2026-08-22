package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbgs;
import com.google.android.gms.internal.ads.zzbgv;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.Objects;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaw extends zzba {
    public final /* synthetic */ NativeAdView zza;
    public final /* synthetic */ FrameLayout zzb;
    public final /* synthetic */ Context zzc;
    public final /* synthetic */ TooltipPopup zzd;

    public zzaw(TooltipPopup tooltipPopup, NativeAdView nativeAdView, FrameLayout frameLayout, Context context) {
        this.zza = nativeAdView;
        this.zzb = frameLayout;
        this.zzc = context;
        Objects.requireNonNull(tooltipPopup);
        this.zzd = tooltipPopup;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zza() {
        TooltipPopup.zzv(this.zzc, "native_ad_view_delegate");
        return new zzfp();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzj(new ObjectWrapper(this.zza), new ObjectWrapper(this.zzb));
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzc() {
        Context context = this.zzc;
        zzbde.zza(context);
        boolean zBooleanValue = ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzle)).booleanValue();
        FrameLayout frameLayout = this.zzb;
        NativeAdView nativeAdView = this.zza;
        TooltipPopup tooltipPopup = this.zzd;
        if (!zBooleanValue) {
            return ((zzbil) tooltipPopup.mLayoutParams).zza(context, nativeAdView, frameLayout);
        }
        try {
            try {
                return zzbgs.zzdC(zzbgv.zzb(ExceptionsKt.zzc(context).instantiate("com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl")).zze(new ObjectWrapper(context), new ObjectWrapper(nativeAdView), new ObjectWrapper(frameLayout), ModuleDescriptor.MODULE_VERSION));
            } catch (Exception e) {
                throw new com.google.android.gms.ads.internal.util.client.zzr(e);
            }
        } catch (RemoteException e2) {
            e = e2;
            zzbup zzbupVarZza = zzbun.zza(context);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza;
            zzbupVarZza.zzh(e, MnHfHMYQDPUO.gpXLTqMVUk);
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
            e = e3;
            zzbup zzbupVarZza2 = zzbun.zza(context);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza2;
            zzbupVarZza2.zzh(e, MnHfHMYQDPUO.gpXLTqMVUk);
            return null;
        } catch (NullPointerException e4) {
            e = e4;
            zzbup zzbupVarZza3 = zzbun.zza(context);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza3;
            zzbupVarZza3.zzh(e, MnHfHMYQDPUO.gpXLTqMVUk);
            return null;
        }
    }
}
