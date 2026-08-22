package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbay;
import com.google.android.gms.internal.ads.zzbaz;
import com.google.android.gms.internal.ads.zzbdy;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbub;
import com.google.android.gms.internal.ads.zzbuc;
import com.google.android.gms.internal.ads.zzbwh;
import com.google.android.gms.internal.ads.zzbwi;
import com.google.protobuf.DescriptorProtos;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbw extends zzayu implements zzbx {
    public zzbw() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzbx zzaf(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbk zzbiVar = null;
        zzcv zzctVar = null;
        zzbn zzblVar = null;
        zzdt zzdrVar = null;
        zzcb zzbzVar = null;
        zzcs zzcsVar = null;
        zzbh zzbfVar = null;
        zzco zzcmVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperZzo = zzo();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzo);
                return true;
            case 2:
                zzy();
                parcel2.writeNoException();
                return true;
            case 3:
                boolean zZzac = zzac();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zZzac ? 1 : 0);
                return true;
            case 4:
                zzm zzmVar = (zzm) zzayv.zza(parcel, zzm.CREATOR);
                zzayv.zzd(parcel);
                boolean zZzad = zzad(zzmVar);
                parcel2.writeNoException();
                parcel2.writeInt(zZzad ? 1 : 0);
                return true;
            case 5:
                zzA();
                parcel2.writeNoException();
                return true;
            case 6:
                zzC();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbiVar = iInterfaceQueryLocalInterface instanceof zzbk ? (zzbk) iInterfaceQueryLocalInterface : new zzbi(strongBinder);
                }
                zzayv.zzd(parcel);
                zzE(zzbiVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzcmVar = iInterfaceQueryLocalInterface2 instanceof zzco ? (zzco) iInterfaceQueryLocalInterface2 : new zzcm(strongBinder2);
                }
                zzayv.zzd(parcel);
                zzH(zzcmVar);
                parcel2.writeNoException();
                return true;
            case 9:
                zzZ();
                parcel2.writeNoException();
                return true;
            case 10:
                parcel2.writeNoException();
                return true;
            case 11:
                zzB();
                parcel2.writeNoException();
                return true;
            case 12:
                zzr zzrVarZzh = zzh();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzrVarZzh);
                return true;
            case 13:
                zzr zzrVar = (zzr) zzayv.zza(parcel, zzr.CREATOR);
                zzayv.zzd(parcel);
                zzG(zzrVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbtz zzbtzVarZzb = zzbty.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzN(zzbtzVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                zzbuc zzbucVarZzb = zzbub.zzb(parcel.readStrongBinder());
                String string = parcel.readString();
                zzayv.zzd(parcel);
                zzS(zzbucVarZzb, string);
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
            case 28:
            default:
                return false;
            case 18:
                String strZzt = zzt();
                parcel2.writeNoException();
                parcel2.writeString(strZzt);
                return true;
            case 19:
                zzbdz zzbdzVarZzb = zzbdy.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzP(zzbdzVarZzb);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzbfVar = iInterfaceQueryLocalInterface3 instanceof zzbh ? (zzbh) iInterfaceQueryLocalInterface3 : new zzbf(strongBinder3, "com.google.android.gms.ads.internal.client.IAdClickListener");
                }
                zzayv.zzd(parcel);
                zzD(zzbfVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcsVar = iInterfaceQueryLocalInterface4 instanceof zzcs ? (zzcs) iInterfaceQueryLocalInterface4 : new zzcs(strongBinder4);
                }
                zzayv.zzd(parcel);
                zzae(zzcsVar);
                parcel2.writeNoException();
                return true;
            case 22:
                boolean zZzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzO(zZzh);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                boolean zZzab = zzab();
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(zZzab ? 1 : 0);
                return true;
            case 24:
                zzbwi zzbwiVarZzb = zzbwh.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzU(zzbwiVarZzb);
                parcel2.writeNoException();
                return true;
            case 25:
                String string2 = parcel.readString();
                zzayv.zzd(parcel);
                zzV(string2);
                parcel2.writeNoException();
                return true;
            case 26:
                zzed zzedVarZzm = zzm();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzedVarZzm);
                return true;
            case 29:
                zzgc zzgcVar = (zzgc) zzayv.zza(parcel, zzgc.CREATOR);
                zzayv.zzd(parcel);
                zzW(zzgcVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzeh zzehVar = (zzeh) zzayv.zza(parcel, zzeh.CREATOR);
                zzayv.zzd(parcel);
                zzL(zzehVar);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                String strZzs = zzs();
                parcel2.writeNoException();
                parcel2.writeString(strZzs);
                return true;
            case 32:
                zzco zzcoVarZzk = zzk();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzcoVarZzk);
                return true;
            case 33:
                zzbk zzbkVarZzj = zzj();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbkVarZzj);
                return true;
            case 34:
                boolean zZzh2 = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzM(zZzh2);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                String strZzu = zzu();
                parcel2.writeNoException();
                parcel2.writeString(strZzu);
                return true;
            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzbzVar = iInterfaceQueryLocalInterface5 instanceof zzcb ? (zzcb) iInterfaceQueryLocalInterface5 : new zzbz(strongBinder5);
                }
                zzayv.zzd(parcel);
                zzF(zzbzVar);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                Bundle bundleZze = zze();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, bundleZze);
                return true;
            case 38:
                String string3 = parcel.readString();
                zzayv.zzd(parcel);
                zzT(string3);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                zzx zzxVar = (zzx) zzayv.zza(parcel, zzx.CREATOR);
                zzayv.zzd(parcel);
                zzJ(zzxVar);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                zzbaz zzbazVarZze = zzbay.zze(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzI(zzbazVarZze);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                zzea zzeaVarZzl = zzl();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzeaVarZzl);
                return true;
            case 42:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
                    zzdrVar = iInterfaceQueryLocalInterface6 instanceof zzdt ? (zzdt) iInterfaceQueryLocalInterface6 : new zzdr(strongBinder6);
                }
                zzayv.zzd(parcel);
                zzQ(zzdrVar);
                parcel2.writeNoException();
                return true;
            case 43:
                zzm zzmVar2 = (zzm) zzayv.zza(parcel, zzm.CREATOR);
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoadCallback");
                    zzblVar = iInterfaceQueryLocalInterface7 instanceof zzbn ? (zzbn) iInterfaceQueryLocalInterface7 : new zzbl(strongBinder7, "com.google.android.gms.ads.internal.client.IAdLoadCallback");
                }
                zzayv.zzd(parcel);
                zzz(zzmVar2, zzblVar);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzY(iObjectWrapperAsInterface);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                    zzctVar = iInterfaceQueryLocalInterface8 instanceof zzcv ? (zzcv) iInterfaceQueryLocalInterface8 : new zzct(strongBinder8, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
                }
                zzayv.zzd(parcel);
                zzK(zzctVar);
                parcel2.writeNoException();
                return true;
            case 46:
                boolean zZzaa = zzaa();
                parcel2.writeNoException();
                int i5 = zzayv.zza;
                parcel2.writeInt(zZzaa ? 1 : 0);
                return true;
            case 47:
                long jZzc = zzc();
                parcel2.writeNoException();
                parcel2.writeLong(jZzc);
                return true;
            case 48:
                long j = parcel.readLong();
                zzayv.zzd(parcel);
                zzR(j);
                parcel2.writeNoException();
                return true;
        }
    }
}
