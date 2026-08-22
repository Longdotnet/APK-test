package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbvd extends zzayu implements zzbve {
    public zzbvd() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbvi zzbvgVar = null;
        zzbvj zzbvjVar = null;
        zzbvi zzbvgVar2 = null;
        zzbvi zzbvgVar3 = null;
        zzbvi zzbvgVar4 = null;
        switch (i) {
            case 1:
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                zzayv.zzf(parcel2, null);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    boolean z = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener") instanceof zzbvf;
                }
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                return true;
            case 3:
            default:
                return false;
            case 4:
                zzbvq zzbvqVar = (zzbvq) zzayv.zza(parcel, zzbvq.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbvgVar = iInterfaceQueryLocalInterface instanceof zzbvi ? (zzbvi) iInterfaceQueryLocalInterface : new zzbvg(strongBinder2);
                }
                zzayv.zzd(parcel);
                zzg(zzbvqVar, zzbvgVar);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbvq zzbvqVar2 = (zzbvq) zzayv.zza(parcel, zzbvq.CREATOR);
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbvgVar4 = iInterfaceQueryLocalInterface2 instanceof zzbvi ? (zzbvi) iInterfaceQueryLocalInterface2 : new zzbvg(strongBinder3);
                }
                zzayv.zzd(parcel);
                zzf(zzbvqVar2, zzbvgVar4);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbvq zzbvqVar3 = (zzbvq) zzayv.zza(parcel, zzbvq.CREATOR);
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbvgVar3 = iInterfaceQueryLocalInterface3 instanceof zzbvi ? (zzbvi) iInterfaceQueryLocalInterface3 : new zzbvg(strongBinder4);
                }
                zzayv.zzd(parcel);
                zze(zzbvqVar3, zzbvgVar3);
                parcel2.writeNoException();
                return true;
            case 7:
                String string = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                    zzbvgVar2 = iInterfaceQueryLocalInterface4 instanceof zzbvi ? (zzbvi) iInterfaceQueryLocalInterface4 : new zzbvg(strongBinder5);
                }
                zzayv.zzd(parcel);
                zzh(string, zzbvgVar2);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbva zzbvaVar = (zzbva) zzayv.zza(parcel, zzbva.CREATOR);
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.request.ITrustlessTokenListener");
                    zzbvjVar = iInterfaceQueryLocalInterface5 instanceof zzbvj ? (zzbvj) iInterfaceQueryLocalInterface5 : new zzbvj(strongBinder6);
                }
                zzayv.zzd(parcel);
                zzi(zzbvaVar, zzbvjVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
