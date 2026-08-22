package com.google.android.gms.ads.internal.client;

import android.content.Context;
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
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbun;
import com.google.android.gms.internal.ads.zzbup;
import java.util.Objects;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzaq extends zzba {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbpm zzc;
    public final /* synthetic */ TooltipPopup zzd;

    public zzaq(TooltipPopup tooltipPopup, Context context, String str, zzbpm zzbpmVar) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbpmVar;
        Objects.requireNonNull(tooltipPopup);
        this.zzd = tooltipPopup;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zza() {
        TooltipPopup.zzv(this.zza, "native_ad");
        return new zzfk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        return zzcrVar.zzb(new ObjectWrapper(this.zza), this.zzb, this.zzc, ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzc() {
        zzbu zzbuVar;
        Context context = this.zza;
        zzbde.zza(context);
        boolean zBooleanValue = ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzle)).booleanValue();
        zzbpm zzbpmVar = this.zzc;
        TooltipPopup tooltipPopup = this.zzd;
        String str = this.zzb;
        if (!zBooleanValue) {
            zzi zziVar = (zzi) tooltipPopup.mContentView;
            try {
                ObjectWrapper objectWrapper = new ObjectWrapper(context);
                zzbu zzbuVar2 = (zzbu) zziVar.getRemoteCreatorInstance(context);
                Parcel parcelZza = zzbuVar2.zza();
                zzayv.zzg(parcelZza, objectWrapper);
                parcelZza.writeString(str);
                zzayv.zzg(parcelZza, zzbpmVar);
                parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
                Parcel parcelZzda = zzbuVar2.zzda(1, parcelZza);
                IBinder strongBinder = parcelZzda.readStrongBinder();
                parcelZzda.recycle();
                if (strongBinder == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return iInterfaceQueryLocalInterface instanceof zzbt ? (zzbt) iInterfaceQueryLocalInterface : new zzbr(strongBinder);
            } catch (RemoteException e) {
                e = e;
                zzo.zzk("Could not create remote builder for AdLoader.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e2) {
                e = e2;
                zzo.zzk("Could not create remote builder for AdLoader.", e);
                return null;
            }
        }
        try {
            ObjectWrapper objectWrapper2 = new ObjectWrapper(context);
            try {
                IBinder iBinderInstantiate = ExceptionsKt.zzc(context).instantiate("com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl");
                if (iBinderInstantiate == null) {
                    zzbuVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = iBinderInstantiate.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
                    zzbuVar = iInterfaceQueryLocalInterface2 instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface2 : new zzbu(iBinderInstantiate);
                }
                Parcel parcelZza2 = zzbuVar.zza();
                zzayv.zzg(parcelZza2, objectWrapper2);
                parcelZza2.writeString(str);
                zzayv.zzg(parcelZza2, zzbpmVar);
                parcelZza2.writeInt(ModuleDescriptor.MODULE_VERSION);
                Parcel parcelZzda2 = zzbuVar.zzda(1, parcelZza2);
                IBinder strongBinder2 = parcelZzda2.readStrongBinder();
                parcelZzda2.recycle();
                if (strongBinder2 == null) {
                    return null;
                }
                IInterface iInterfaceQueryLocalInterface3 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return iInterfaceQueryLocalInterface3 instanceof zzbt ? (zzbt) iInterfaceQueryLocalInterface3 : new zzbr(strongBinder2);
            } catch (Exception e3) {
                throw new com.google.android.gms.ads.internal.util.client.zzr(e3);
            }
        } catch (RemoteException e4) {
            e = e4;
            zzbup zzbupVarZza = zzbun.zza(context);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza;
            zzbupVarZza.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e5) {
            e = e5;
            zzbup zzbupVarZza2 = zzbun.zza(context);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza2;
            zzbupVarZza2.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        } catch (NullPointerException e6) {
            e = e6;
            zzbup zzbupVarZza3 = zzbun.zza(context);
            tooltipPopup.mTmpAnchorPos = zzbupVarZza3;
            zzbupVarZza3.zzh(e, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }
}
