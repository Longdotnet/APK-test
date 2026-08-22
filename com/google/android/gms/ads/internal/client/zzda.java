package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbmj;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpq;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzda extends zzayu implements zzdb {
    public zzda() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzdn zzdlVar;
        switch (i) {
            case 1:
                zzk();
                parcel2.writeNoException();
                return true;
            case 2:
                float f = parcel.readFloat();
                zzayv.zzd(parcel);
                zzq(f);
                parcel2.writeNoException();
                return true;
            case 3:
                String string = parcel.readString();
                zzayv.zzd(parcel);
                zzr(string);
                parcel2.writeNoException();
                return true;
            case 4:
                boolean zZzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzp(zZzh);
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                String string2 = parcel.readString();
                zzayv.zzd(parcel);
                zzn(iObjectWrapperAsInterface, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                String string3 = parcel.readString();
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzl(string3, iObjectWrapperAsInterface2);
                parcel2.writeNoException();
                return true;
            case 7:
                float fZze = zze();
                parcel2.writeNoException();
                parcel2.writeFloat(fZze);
                return true;
            case 8:
                boolean zZzv = zzv();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zZzv ? 1 : 0);
                return true;
            case 9:
                String strZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeString(strZzf);
                return true;
            case 10:
                String string4 = parcel.readString();
                zzayv.zzd(parcel);
                zzh(string4);
                parcel2.writeNoException();
                return true;
            case 11:
                zzbpq zzbpqVarZzf = zzbpp.zzf(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzo(zzbpqVarZzf);
                parcel2.writeNoException();
                return true;
            case 12:
                zzbmk zzbmkVarZzc = zzbmj.zzc(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzs(zzbmkVarZzc);
                parcel2.writeNoException();
                return true;
            case 13:
                List listZzg = zzg();
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzg);
                return true;
            case 14:
                zzfx zzfxVar = (zzfx) zzayv.zza(parcel, zzfx.CREATOR);
                zzayv.zzd(parcel);
                zzu(zzfxVar);
                parcel2.writeNoException();
                return true;
            case 15:
                zzi();
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder == null) {
                    zzdlVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
                    zzdlVar = iInterfaceQueryLocalInterface instanceof zzdn ? (zzdn) iInterfaceQueryLocalInterface : new zzdl(strongBinder, "com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
                }
                zzayv.zzd(parcel);
                zzm(zzdlVar);
                parcel2.writeNoException();
                return true;
            case 17:
                boolean zZzh2 = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzj(zZzh2);
                parcel2.writeNoException();
                return true;
            case 18:
                String string5 = parcel.readString();
                zzayv.zzd(parcel);
                zzt(string5);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
