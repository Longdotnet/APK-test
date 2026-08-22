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
public final class zzas extends zzba {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbpm zzb;
    public final /* synthetic */ TooltipPopup zzc;

    public zzas(TooltipPopup tooltipPopup, Context context, zzbpm zzbpmVar) {
        this.zza = context;
        this.zzb = zzbpmVar;
        Objects.requireNonNull(tooltipPopup);
        this.zzc = tooltipPopup;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final /* bridge */ /* synthetic */ Object zza() {
        TooltipPopup.zzv(this.zza, "ads_preloader");
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzb(zzcr zzcrVar) {
        ObjectWrapper objectWrapper = new ObjectWrapper(this.zza);
        zzbpm zzbpmVar = this.zzb;
        zzck zzckVarZzg = zzcrVar.zzg(objectWrapper, zzbpmVar, ModuleDescriptor.MODULE_VERSION);
        zzckVarZzg.zzo(zzbpmVar);
        return zzckVarZzg;
    }

    @Override // com.google.android.gms.ads.internal.client.zzba
    public final Object zzc() {
        zzck zzciVar;
        zzcl zzclVar;
        Context context = this.zza;
        ObjectWrapper objectWrapper = new ObjectWrapper(context);
        zzbde.zza(context);
        boolean zBooleanValue = ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzle)).booleanValue();
        zzbpm zzbpmVar = this.zzb;
        TooltipPopup tooltipPopup = this.zzc;
        if (zBooleanValue) {
            try {
                try {
                    IBinder iBinderInstantiate = ExceptionsKt.zzc(context).instantiate("com.google.android.gms.ads.ChimeraAdPreloaderCreatorImpl");
                    if (iBinderInstantiate == null) {
                        zzclVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloaderCreator");
                        zzclVar = iInterfaceQueryLocalInterface instanceof zzcl ? (zzcl) iInterfaceQueryLocalInterface : new zzcl(iBinderInstantiate);
                    }
                    Parcel parcelZza = zzclVar.zza();
                    zzayv.zzg(parcelZza, objectWrapper);
                    zzayv.zzg(parcelZza, zzbpmVar);
                    parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
                    Parcel parcelZzda = zzclVar.zzda(1, parcelZza);
                    IBinder strongBinder = parcelZzda.readStrongBinder();
                    parcelZzda.recycle();
                    if (strongBinder == null) {
                        zzciVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
                        zzciVar = iInterfaceQueryLocalInterface2 instanceof zzck ? (zzck) iInterfaceQueryLocalInterface2 : new zzci(strongBinder);
                    }
                    zzciVar.zzo(zzbpmVar);
                } catch (Exception e) {
                    throw new com.google.android.gms.ads.internal.util.client.zzr(e);
                }
            } catch (RemoteException e2) {
                e = e2;
                zzbup zzbupVarZza = zzbun.zza(context);
                tooltipPopup.mTmpAnchorPos = zzbupVarZza;
                zzbupVarZza.zzh(e, "ClientApiBroker.getAdPreloader");
                return null;
            } catch (com.google.android.gms.ads.internal.util.client.zzr e3) {
                e = e3;
                zzbup zzbupVarZza2 = zzbun.zza(context);
                tooltipPopup.mTmpAnchorPos = zzbupVarZza2;
                zzbupVarZza2.zzh(e, "ClientApiBroker.getAdPreloader");
                return null;
            } catch (NullPointerException e4) {
                e = e4;
                zzbup zzbupVarZza3 = zzbun.zza(context);
                tooltipPopup.mTmpAnchorPos = zzbupVarZza3;
                zzbupVarZza3.zzh(e, "ClientApiBroker.getAdPreloader");
                return null;
            }
        } else {
            zzi zziVar = (zzi) tooltipPopup.mTmpAppPos;
            try {
                ObjectWrapper objectWrapper2 = new ObjectWrapper(context);
                zzcl zzclVar2 = (zzcl) zziVar.getRemoteCreatorInstance(context);
                Parcel parcelZza2 = zzclVar2.zza();
                zzayv.zzg(parcelZza2, objectWrapper2);
                zzayv.zzg(parcelZza2, zzbpmVar);
                parcelZza2.writeInt(ModuleDescriptor.MODULE_VERSION);
                Parcel parcelZzda2 = zzclVar2.zzda(1, parcelZza2);
                IBinder strongBinder2 = parcelZzda2.readStrongBinder();
                parcelZzda2.recycle();
                if (strongBinder2 == null) {
                    zzciVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
                    zzciVar = iInterfaceQueryLocalInterface3 instanceof zzck ? (zzck) iInterfaceQueryLocalInterface3 : new zzci(strongBinder2);
                }
                zzciVar.zzo(zzbpmVar);
            } catch (RemoteException e5) {
                e = e5;
                zzo.zzk("Could not get remote AdPreloaderCreator.", e);
                return null;
            } catch (RemoteCreator.RemoteCreatorException e6) {
                e = e6;
                zzo.zzk("Could not get remote AdPreloaderCreator.", e);
                return null;
            }
        }
        return zzciVar;
    }
}
