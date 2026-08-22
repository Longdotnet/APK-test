package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbwu extends zzayu implements zzbwv {
    public zzbwu() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzbwv zzt(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return iInterfaceQueryLocalInterface instanceof zzbwv ? (zzbwv) iInterfaceQueryLocalInterface : new zzbwt(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbxc zzbxaVar = null;
        zzbxc zzbxaVar2 = null;
        com.google.android.gms.ads.internal.client.zzdq zzdoVar = null;
        zzbxd zzbxdVar = null;
        zzbwy zzbwwVar = null;
        switch (i) {
            case 1:
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbxaVar = iInterfaceQueryLocalInterface instanceof zzbxc ? (zzbxc) iInterfaceQueryLocalInterface : new zzbxa(strongBinder);
                }
                zzayv.zzd(parcel);
                zzh(zzmVar, zzbxaVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
                    zzbwwVar = iInterfaceQueryLocalInterface2 instanceof zzbwy ? (zzbwy) iInterfaceQueryLocalInterface2 : new zzbww(strongBinder2);
                }
                zzayv.zzd(parcel);
                zzn(zzbwwVar);
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzr = zzr();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zZzr ? 1 : 0);
                return true;
            case 4:
                String strZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeString(strZzg);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzp(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case 6:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
                    zzbxdVar = iInterfaceQueryLocalInterface3 instanceof zzbxd ? (zzbxd) iInterfaceQueryLocalInterface3 : new zzbxd(strongBinder3);
                }
                zzayv.zzd(parcel);
                zzs(zzbxdVar);
                parcel2.writeNoException();
                return true;
            case 7:
                zzbxj zzbxjVar = (zzbxj) zzayv.zza(parcel, zzbxj.CREATOR);
                zzayv.zzd(parcel);
                zzo(zzbxjVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
                    zzdoVar = iInterfaceQueryLocalInterface4 instanceof com.google.android.gms.ads.internal.client.zzdq ? (com.google.android.gms.ads.internal.client.zzdq) iInterfaceQueryLocalInterface4 : new com.google.android.gms.ads.internal.client.zzdo(strongBinder4, "com.google.android.gms.ads.internal.client.IOnAdMetadataChangedListener");
                }
                zzayv.zzd(parcel);
                zzk(zzdoVar);
                parcel2.writeNoException();
                return true;
            case 9:
                Bundle bundleZzc = zzc();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, bundleZzc);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                boolean zZzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzq(iObjectWrapperAsInterface2, zZzh);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbws zzbwsVarZze = zze();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbwsVarZze);
                return true;
            case 12:
                com.google.android.gms.ads.internal.client.zzea zzeaVarZzd = zzd();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzeaVarZzd);
                return true;
            case 13:
                com.google.android.gms.ads.internal.client.zzdt zzdtVarZzb = com.google.android.gms.ads.internal.client.zzfu.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzl(zzdtVarZzb);
                parcel2.writeNoException();
                return true;
            case 14:
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
                    zzbxaVar2 = iInterfaceQueryLocalInterface5 instanceof zzbxc ? (zzbxc) iInterfaceQueryLocalInterface5 : new zzbxa(strongBinder5);
                }
                zzayv.zzd(parcel);
                zzi(zzmVar2, zzbxaVar2);
                parcel2.writeNoException();
                return true;
            case 15:
                boolean zZzh2 = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzj(zZzh2);
                parcel2.writeNoException();
                return true;
            case 16:
                String strZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeString(strZzf);
                return true;
            case 17:
                long jZzb = zzb();
                parcel2.writeNoException();
                parcel2.writeLong(jZzb);
                return true;
            case 18:
                long j = parcel.readLong();
                zzayv.zzd(parcel);
                zzm(j);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
