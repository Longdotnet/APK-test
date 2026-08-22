package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbtn;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.Objects;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzac extends zzba {
    public final /* synthetic */ AdActivity zza;
    public final /* synthetic */ TooltipPopup zzb;

    public zzac(TooltipPopup tooltipPopup, AdActivity adActivity) {
        this.zza = adActivity;
        Objects.requireNonNull(tooltipPopup);
        this.zzb = tooltipPopup;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zza() {
        TooltipPopup.zzv(this.zza, "ad_overlay");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzn(new ObjectWrapper(this.zza));
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzc() {
        AdActivity adActivity = this.zza;
        zzbde.zza(adActivity);
        boolean zBooleanValue = ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzle)).booleanValue();
        TooltipPopup tooltipPopup = this.zzb;
        if (!zBooleanValue) {
            return ((zzbtn) tooltipPopup.mTmpDisplayFrame).zza(adActivity);
        }
        try {
            try {
                return zzbtp.zzI(zzbts.zzb(ExceptionsKt.zzc(adActivity).instantiate("com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl")).zze(new ObjectWrapper(adActivity)));
            } catch (Exception e) {
                throw new com.google.android.gms.ads.internal.util.client.zzr(e);
            }
        } catch (RemoteException e2) {
            e = e2;
            zzbup zzbupVarZza = zzbun.zza(adActivity.getApplicationContext());
            tooltipPopup.mTmpAnchorPos = zzbupVarZza;
            zzbupVarZza.zzh(e, "ClientApiBroker.createAdOverlay");
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
            e = e3;
            zzbup zzbupVarZza2 = zzbun.zza(adActivity.getApplicationContext());
            tooltipPopup.mTmpAnchorPos = zzbupVarZza2;
            zzbupVarZza2.zzh(e, "ClientApiBroker.createAdOverlay");
            return null;
        } catch (NullPointerException e4) {
            e = e4;
            zzbup zzbupVarZza3 = zzbun.zza(adActivity.getApplicationContext());
            tooltipPopup.mTmpAnchorPos = zzbupVarZza3;
            zzbupVarZza3.zzh(e, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}
