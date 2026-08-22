package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbhf extends zzayu implements zzbhg {
    public zzbhf() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                IObjectWrapper iObjectWrapperZzg = zzg();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzg);
                return true;
            case 3:
                String strZzk = zzk();
                parcel2.writeNoException();
                parcel2.writeString(strZzk);
                return true;
            case 4:
                List listZzm = zzm();
                parcel2.writeNoException();
                parcel2.writeList(listZzm);
                return true;
            case 5:
                String strZzi = zzi();
                parcel2.writeNoException();
                parcel2.writeString(strZzi);
                return true;
            case 6:
                zzbgp zzbgpVarZze = zze();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbgpVarZze);
                return true;
            case 7:
                String strZzj = zzj();
                parcel2.writeNoException();
                parcel2.writeString(strZzj);
                return true;
            case 8:
                String strZzh = zzh();
                parcel2.writeNoException();
                parcel2.writeString(strZzh);
                return true;
            case 9:
                Bundle bundleZzb = zzb();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, bundleZzb);
                return true;
            case 10:
                zzn();
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzed zzedVarZzc = zzc();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzedVarZzc);
                return true;
            case 12:
                Bundle bundle = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                zzo(bundle);
                parcel2.writeNoException();
                return true;
            case 13:
                Bundle bundle2 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                boolean zZzq = zzq(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zZzq ? 1 : 0);
                return true;
            case 14:
                Bundle bundle3 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                zzp(bundle3);
                parcel2.writeNoException();
                return true;
            case 15:
                zzbgi zzbgiVarZzd = zzd();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbgiVarZzd);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperZzf = zzf();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzf);
                return true;
            case 17:
                String strZzl = zzl();
                parcel2.writeNoException();
                parcel2.writeString(strZzl);
                return true;
            default:
                return false;
        }
    }
}
