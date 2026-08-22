package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbaw;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbwv;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzcj extends zzayu implements zzck {
    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzce zzccVar = null;
        zzch zzcfVar = null;
        switch (i) {
            case 1:
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzfv.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallback");
                    zzccVar = iInterfaceQueryLocalInterface instanceof zzce ? (zzce) iInterfaceQueryLocalInterface : new zzcc(strongBinder, "com.google.android.gms.ads.internal.client.IAdPreloadCallback");
                }
                zzayv.zzd(parcel);
                zzp(arrayListCreateTypedArrayList, zzccVar);
                parcel2.writeNoException();
                return true;
            case 2:
                String string = parcel.readString();
                zzayv.zzd(parcel);
                boolean zZzu = zzu(string);
                parcel2.writeNoException();
                parcel2.writeInt(zZzu ? 1 : 0);
                return true;
            case 3:
                String string2 = parcel.readString();
                zzayv.zzd(parcel);
                zzbwv zzbwvVarZzm = zzm(string2);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbwvVarZzm);
                return true;
            case 4:
                String string3 = parcel.readString();
                zzayv.zzd(parcel);
                boolean zZzs = zzs(string3);
                parcel2.writeNoException();
                parcel2.writeInt(zZzs ? 1 : 0);
                return true;
            case 5:
                String string4 = parcel.readString();
                zzayv.zzd(parcel);
                zzbaw zzbawVarZzh = zzh(string4);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbawVarZzh);
                return true;
            case 6:
                String string5 = parcel.readString();
                zzayv.zzd(parcel);
                boolean zZzt = zzt(string5);
                parcel2.writeNoException();
                parcel2.writeInt(zZzt ? 1 : 0);
                return true;
            case 7:
                String string6 = parcel.readString();
                zzayv.zzd(parcel);
                zzbx zzbxVarZzj = zzj(string6);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbxVarZzj);
                return true;
            case 8:
                zzbpq zzbpqVarZzf = zzbpp.zzf(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzo(zzbpqVarZzf);
                parcel2.writeNoException();
                return true;
            case 9:
                String string7 = parcel.readString();
                zzfv zzfvVar = (zzfv) zzayv.zza(parcel, zzfv.CREATOR);
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
                    zzcfVar = iInterfaceQueryLocalInterface2 instanceof zzch ? (zzch) iInterfaceQueryLocalInterface2 : new zzcf(strongBinder2, "com.google.android.gms.ads.internal.client.IAdPreloadCallbackV2");
                }
                zzayv.zzd(parcel);
                boolean zZzv = zzv(string7, zzfvVar, zzcfVar);
                parcel2.writeNoException();
                parcel2.writeInt(zZzv ? 1 : 0);
                return true;
            case 10:
                int i3 = parcel.readInt();
                String string8 = parcel.readString();
                zzayv.zzd(parcel);
                boolean zZzr = zzr(i3, string8);
                parcel2.writeNoException();
                parcel2.writeInt(zZzr ? 1 : 0);
                return true;
            case 11:
                String string9 = parcel.readString();
                zzayv.zzd(parcel);
                zzbx zzbxVarZzi = zzi(string9);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbxVarZzi);
                return true;
            case 12:
                String string10 = parcel.readString();
                zzayv.zzd(parcel);
                zzbaw zzbawVarZzg = zzg(string10);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbawVarZzg);
                return true;
            case 13:
                String string11 = parcel.readString();
                zzayv.zzd(parcel);
                zzbwv zzbwvVarZzl = zzl(string11);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbwvVarZzl);
                return true;
            case 14:
                int i4 = parcel.readInt();
                String string12 = parcel.readString();
                zzayv.zzd(parcel);
                zzfv zzfvVarZzk = zzk(i4, string12);
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzfvVarZzk);
                return true;
            case 15:
                int i5 = parcel.readInt();
                zzayv.zzd(parcel);
                Bundle bundleZzf = zzf(i5);
                parcel2.writeNoException();
                zzayv.zzf(parcel2, bundleZzf);
                return true;
            case 16:
                int i6 = parcel.readInt();
                String string13 = parcel.readString();
                zzayv.zzd(parcel);
                int iZze = zze(i6, string13);
                parcel2.writeNoException();
                parcel2.writeInt(iZze);
                return true;
            case 17:
                int i7 = parcel.readInt();
                String string14 = parcel.readString();
                zzayv.zzd(parcel);
                boolean zZzq = zzq(i7, string14);
                parcel2.writeNoException();
                parcel2.writeInt(zZzq ? 1 : 0);
                return true;
            case 18:
                int i8 = parcel.readInt();
                zzayv.zzd(parcel);
                zzn(i8);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
