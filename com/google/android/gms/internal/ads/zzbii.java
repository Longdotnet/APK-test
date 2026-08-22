package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.protobuf.DescriptorProtos;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbii extends zzayu implements zzbij {
    public zzbii() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbig zzbieVar = null;
        com.google.android.gms.ads.internal.client.zzdf zzddVar = null;
        switch (i) {
            case 2:
                String strZzr = zzr();
                parcel2.writeNoException();
                parcel2.writeString(strZzr);
                return true;
            case 3:
                List listZzv = zzv();
                parcel2.writeNoException();
                parcel2.writeList(listZzv);
                return true;
            case 4:
                String strZzp = zzp();
                parcel2.writeNoException();
                parcel2.writeString(strZzp);
                return true;
            case 5:
                zzbgp zzbgpVarZzl = zzl();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbgpVarZzl);
                return true;
            case 6:
                String strZzq = zzq();
                parcel2.writeNoException();
                parcel2.writeString(strZzq);
                return true;
            case 7:
                String strZzo = zzo();
                parcel2.writeNoException();
                parcel2.writeString(strZzo);
                return true;
            case 8:
                double dZze = zze();
                parcel2.writeNoException();
                parcel2.writeDouble(dZze);
                return true;
            case 9:
                String strZzu = zzu();
                parcel2.writeNoException();
                parcel2.writeString(strZzu);
                return true;
            case 10:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzed zzedVarZzi = zzi();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzedVarZzi);
                return true;
            case 12:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 13:
                zzy();
                parcel2.writeNoException();
                return true;
            case 14:
                zzbgi zzbgiVarZzj = zzj();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbgiVarZzj);
                return true;
            case 15:
                Bundle bundle = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                zzA(bundle);
                parcel2.writeNoException();
                return true;
            case 16:
                Bundle bundle2 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                boolean zZzL = zzL(bundle2);
                parcel2.writeNoException();
                parcel2.writeInt(zZzL ? 1 : 0);
                return true;
            case 17:
                Bundle bundle3 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                zzD(bundle3);
                parcel2.writeNoException();
                return true;
            case 18:
                IObjectWrapper iObjectWrapperZzn = zzn();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzn);
                return true;
            case 19:
                IObjectWrapper iObjectWrapperZzm = zzm();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzm);
                return true;
            case 20:
                Bundle bundleZzg = zzg();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, bundleZzg);
                return true;
            case 21:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    zzbieVar = iInterfaceQueryLocalInterface instanceof zzbig ? (zzbig) iInterfaceQueryLocalInterface : new zzbie(strongBinder);
                }
                zzayv.zzd(parcel);
                zzI(zzbieVar);
                parcel2.writeNoException();
                return true;
            case 22:
                zzx();
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                List listZzw = zzw();
                parcel2.writeNoException();
                parcel2.writeList(listZzw);
                return true;
            case 24:
                boolean zZzK = zzK();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zZzK ? 1 : 0);
                return true;
            case 25:
                com.google.android.gms.ads.internal.client.zzdj zzdjVarZzb = com.google.android.gms.ads.internal.client.zzfa.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzz(zzdjVarZzb);
                parcel2.writeNoException();
                return true;
            case 26:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    String str = yzwzcWHcnH.xdTMBvS;
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface(str);
                    zzddVar = iInterfaceQueryLocalInterface2 instanceof com.google.android.gms.ads.internal.client.zzdf ? (com.google.android.gms.ads.internal.client.zzdf) iInterfaceQueryLocalInterface2 : new com.google.android.gms.ads.internal.client.zzdd(strongBinder2, str);
                }
                zzayv.zzd(parcel);
                zzF(zzddVar);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                zzE();
                parcel2.writeNoException();
                return true;
            case 28:
                zzB();
                parcel2.writeNoException();
                return true;
            case 29:
                zzbgm zzbgmVarZzk = zzk();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbgmVarZzk);
                return true;
            case 30:
                boolean zZzJ = zzJ();
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(zZzJ ? 1 : 0);
                return true;
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                com.google.android.gms.ads.internal.client.zzea zzeaVarZzh = zzh();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzeaVarZzh);
                return true;
            case 32:
                com.google.android.gms.ads.internal.client.zzdt zzdtVarZzb = com.google.android.gms.ads.internal.client.zzfu.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzG(zzdtVarZzb);
                parcel2.writeNoException();
                return true;
            case 33:
                Bundle bundle4 = (Bundle) zzayv.zza(parcel, Bundle.CREATOR);
                zzayv.zzd(parcel);
                zzC(bundle4);
                parcel2.writeNoException();
                return true;
            case 34:
                long jZzf = zzf();
                parcel2.writeNoException();
                parcel2.writeLong(jZzf);
                return true;
            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                long j = parcel.readLong();
                zzayv.zzd(parcel);
                zzH(j);
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
