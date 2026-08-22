package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbhi extends zzayu implements zzbhj {
    public zzbhi() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzbhj zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return iInterfaceQueryLocalInterface instanceof zzbhj ? (zzbhj) iInterfaceQueryLocalInterface : new zzbhh(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                String string = parcel.readString();
                zzayv.zzd(parcel);
                String strZzj = zzj(string);
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 2:
                String string2 = parcel.readString();
                zzayv.zzd(parcel);
                zzbgp zzbgpVarZzg = zzg(string2);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbgpVarZzg);
                return true;
            case 3:
                List<String> listZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeStringList(listZzk);
                return true;
            case 4:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 5:
                String string3 = parcel.readString();
                zzayv.zzd(parcel);
                zzn(string3);
                parcel2.writeNoException();
                return true;
            case 6:
                zzo();
                parcel2.writeNoException();
                return true;
            case 7:
                com.google.android.gms.ads.internal.client.zzed zzedVarZze = zze();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzedVarZze);
                return true;
            case 8:
                zzl();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperZzh = zzh();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzh);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                boolean zZzs = zzs(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                parcel2.writeInt(zZzs ? 1 : 0);
                return true;
            case 11:
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 12:
                boolean zZzq = zzq();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zZzq ? 1 : 0);
                return true;
            case 13:
                boolean zZzt = zzt();
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(zZzt ? 1 : 0);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzp(iObjectWrapperAsInterface2);
                parcel2.writeNoException();
                return true;
            case 15:
                zzm();
                parcel2.writeNoException();
                return true;
            case 16:
                zzbgm zzbgmVarZzf = zzf();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbgmVarZzf);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                boolean zZzr = zzr(iObjectWrapperAsInterface3);
                parcel2.writeNoException();
                parcel2.writeInt(zZzr ? 1 : 0);
                return true;
            default:
                return false;
        }
    }
}
