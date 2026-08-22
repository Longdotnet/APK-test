package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.appcompat.widget.TooltipPopup;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.Objects;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzau extends zzba {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ TooltipPopup zzb;

    public zzau(TooltipPopup tooltipPopup, Activity activity) {
        this.zza = activity;
        Objects.requireNonNull(tooltipPopup);
        this.zzb = tooltipPopup;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zza() {
        TooltipPopup.zzv(this.zza, "mobile_ads_settings");
        return new zzfo();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzh(new ObjectWrapper(this.zza), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzc() {
        zzdc zzdcVar;
        Activity activity = this.zza;
        zzbde.zza(activity);
        boolean zBooleanValue = ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzle)).booleanValue();
        TooltipPopup tooltipPopup = this.zzb;
        if (!zBooleanValue) {
            zzi zziVar = (zzi) tooltipPopup.mMessageView;
            try {
                ObjectWrapper objectWrapper = new ObjectWrapper(activity);
                zzdc zzdcVar2 = (zzdc) zziVar.getRemoteCreatorInstance(activity);
                Parcel parcelZza = zzdcVar2.zza();
                zzayv.zzg(parcelZza, objectWrapper);
                parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
                Parcel parcelZzda = zzdcVar2.zzda(1, parcelZza);
                IBinder strongBinder = parcelZzda.readStrongBinder();
                parcelZzda.recycle();
                if (strongBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                return iInterfaceQueryLocalInterface instanceof zzdb ? (zzdb) iInterfaceQueryLocalInterface : new zzcz(strongBinder);
            } catch (RemoteException e) {
                e = e;
                zzo.zzk("Could not get remote MobileAdsSettingManager.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e2) {
                e = e2;
                zzo.zzk("Could not get remote MobileAdsSettingManager.", e);
                return null;
            }
        }
        try {
            ObjectWrapper objectWrapper2 = new ObjectWrapper(activity);
            try {
                IBinder iBinderInstantiate = ExceptionsKt.zzc(activity).instantiate("com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl");
                if (iBinderInstantiate == null) {
                    zzdcVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = iBinderInstantiate.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
                    zzdcVar = iInterfaceQueryLocalInterface2 instanceof zzdc ? (zzdc) iInterfaceQueryLocalInterface2 : new zzdc(iBinderInstantiate);
                }
                Parcel parcelZza2 = zzdcVar.zza();
                zzayv.zzg(parcelZza2, objectWrapper2);
                parcelZza2.writeInt(ModuleDescriptor.MODULE_VERSION);
                Parcel parcelZzda2 = zzdcVar.zzda(1, parcelZza2);
                IBinder strongBinder2 = parcelZzda2.readStrongBinder();
                parcelZzda2.recycle();
                if (strongBinder2 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface3 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                return iInterfaceQueryLocalInterface3 instanceof zzdb ? (zzdb) iInterfaceQueryLocalInterface3 : new zzcz(strongBinder2);
            } catch (Exception e3) {
                throw new com.google.android.gms.ads.internal.util.client.zzr(e3);
            }
        } catch (RemoteException e4) {
            e = e4;
            zzbup zzbupVarZza = zzbun.zza(activity);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza;
            zzbupVarZza.zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e5) {
            e = e5;
            zzbup zzbupVarZza2 = zzbun.zza(activity);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza2;
            zzbupVarZza2.zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        } catch (NullPointerException e6) {
            e = e6;
            zzbup zzbupVarZza3 = zzbun.zza(activity);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza3;
            zzbupVarZza3.zzh(e, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }
}
