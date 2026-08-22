package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.protobuf.DescriptorProtos;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbps extends zzayu implements zzbpt {
    public zzbps() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbpw zzbpuVar = null;
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string = parcel.readString();
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface : new zzbpu(strongBinder);
                }
                zzbpw zzbpwVar = zzbpuVar;
                zzayv.zzd(parcel);
                zzu(iObjectWrapperAsInterface, zzrVar, zzmVar, string, zzbpwVar);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper iObjectWrapperZzn = zzn();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, iObjectWrapperZzn);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string2 = parcel.readString();
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface2 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface2 : new zzbpu(strongBinder2);
                }
                zzayv.zzd(parcel);
                zzx(iObjectWrapperAsInterface2, zzmVar2, string2, zzbpuVar);
                parcel2.writeNoException();
                return true;
            case 4:
                zzI();
                parcel2.writeNoException();
                return true;
            case 5:
                zzo();
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface3 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface3 : new zzbpu(strongBinder3);
                }
                zzbpw zzbpwVar2 = zzbpuVar;
                zzayv.zzd(parcel);
                zzv(iObjectWrapperAsInterface3, zzrVar2, zzmVar3, string3, string4, zzbpwVar2);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper iObjectWrapperAsInterface4 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface4 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface4 : new zzbpu(strongBinder4);
                }
                zzbpw zzbpwVar3 = zzbpuVar;
                zzayv.zzd(parcel);
                zzy(iObjectWrapperAsInterface4, zzmVar4, string5, string6, zzbpwVar3);
                parcel2.writeNoException();
                return true;
            case 8:
                zzE();
                parcel2.writeNoException();
                return true;
            case 9:
                zzF();
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface5 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string7 = parcel.readString();
                zzbwn zzbwnVarZzb = zzbwm.zzb(parcel.readStrongBinder());
                String string8 = parcel.readString();
                zzayv.zzd(parcel);
                zzp(iObjectWrapperAsInterface5, zzmVar5, string7, zzbwnVarZzb, string8);
                parcel2.writeNoException();
                return true;
            case 11:
                com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string9 = parcel.readString();
                zzayv.zzd(parcel);
                zzs(zzmVar6, string9);
                parcel2.writeNoException();
                return true;
            case 12:
                zzL();
                parcel2.writeNoException();
                return true;
            case 13:
                boolean zZzN = zzN();
                parcel2.writeNoException();
                int i3 = zzayv.zza;
                parcel2.writeInt(zZzN ? 1 : 0);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface6 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface5 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface5 : new zzbpu(strongBinder5);
                }
                zzbpw zzbpwVar4 = zzbpuVar;
                zzbge zzbgeVar = (zzbge) zzayv.zza(parcel, zzbge.CREATOR);
                ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                zzayv.zzd(parcel);
                zzz(iObjectWrapperAsInterface6, zzmVar7, string10, string11, zzbpwVar4, zzbgeVar, arrayListCreateStringArrayList);
                parcel2.writeNoException();
                return true;
            case 15:
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 16:
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 17:
                Bundle bundleZze = zze();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, bundleZze);
                return true;
            case 18:
                Bundle bundleZzf = zzf();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, bundleZzf);
                return true;
            case 19:
                Bundle bundleZzg = zzg();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, bundleZzg);
                return true;
            case 20:
                com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                zzayv.zzd(parcel);
                zzB(zzmVar8, string12, string13);
                parcel2.writeNoException();
                return true;
            case 21:
                IObjectWrapper iObjectWrapperAsInterface7 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzD(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                return true;
            case 22:
                parcel2.writeNoException();
                int i4 = zzayv.zza;
                parcel2.writeInt(0);
                return true;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                IObjectWrapper iObjectWrapperAsInterface8 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbwn zzbwnVarZzb2 = zzbwm.zzb(parcel.readStrongBinder());
                ArrayList<String> arrayListCreateStringArrayList2 = parcel.createStringArrayList();
                zzayv.zzd(parcel);
                zzr(iObjectWrapperAsInterface8, zzbwnVarZzb2, arrayListCreateStringArrayList2);
                parcel2.writeNoException();
                return true;
            case 24:
                zzbhj zzbhjVarZzi = zzi();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbhjVarZzi);
                return true;
            case 25:
                boolean zZzh = zzayv.zzh(parcel);
                zzayv.zzd(parcel);
                zzG(zZzh);
                parcel2.writeNoException();
                return true;
            case 26:
                com.google.android.gms.ads.internal.client.zzed zzedVarZzh = zzh();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzedVarZzh);
                return true;
            case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                zzbqf zzbqfVarZzk = zzk();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbqfVarZzk);
                return true;
            case 28:
                IObjectWrapper iObjectWrapperAsInterface9 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar9 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string14 = parcel.readString();
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface6 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface6 : new zzbpu(strongBinder6);
                }
                zzayv.zzd(parcel);
                zzA(iObjectWrapperAsInterface9, zzmVar9, string14, zzbpuVar);
                parcel2.writeNoException();
                return true;
            case 29:
            default:
                return false;
            case 30:
                IObjectWrapper iObjectWrapperAsInterface10 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzK(iObjectWrapperAsInterface10);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                IObjectWrapper iObjectWrapperAsInterface11 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbmh zzbmhVarZzb = zzbmg.zzb(parcel.readStrongBinder());
                ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(zzbmn.CREATOR);
                zzayv.zzd(parcel);
                zzq(iObjectWrapperAsInterface11, zzbmhVarZzb, arrayListCreateTypedArrayList);
                parcel2.writeNoException();
                return true;
            case 32:
                IObjectWrapper iObjectWrapperAsInterface12 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar10 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string15 = parcel.readString();
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface7 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface7 : new zzbpu(strongBinder7);
                }
                zzayv.zzd(parcel);
                zzC(iObjectWrapperAsInterface12, zzmVar10, string15, zzbpuVar);
                parcel2.writeNoException();
                return true;
            case 33:
                zzbse zzbseVarZzl = zzl();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzbseVarZzl);
                return true;
            case 34:
                zzbse zzbseVarZzm = zzm();
                parcel2.writeNoException();
                zzayv.zzf(parcel2, zzbseVarZzm);
                return true;
            case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                IObjectWrapper iObjectWrapperAsInterface13 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                com.google.android.gms.ads.internal.client.zzm zzmVar11 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string16 = parcel.readString();
                String string17 = parcel.readString();
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface8 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface8 : new zzbpu(strongBinder8);
                }
                zzbpw zzbpwVar5 = zzbpuVar;
                zzayv.zzd(parcel);
                zzw(iObjectWrapperAsInterface13, zzrVar3, zzmVar11, string16, string17, zzbpwVar5);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                zzbpz zzbpzVarZzj = zzj();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbpzVarZzj);
                return true;
            case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                IObjectWrapper iObjectWrapperAsInterface14 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzJ(iObjectWrapperAsInterface14);
                parcel2.writeNoException();
                return true;
            case 38:
                IObjectWrapper iObjectWrapperAsInterface15 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzm zzmVar12 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                String string18 = parcel.readString();
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
                    zzbpuVar = iInterfaceQueryLocalInterface9 instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface9 : new zzbpu(strongBinder9);
                }
                zzayv.zzd(parcel);
                zzt(iObjectWrapperAsInterface15, zzmVar12, string18, zzbpuVar);
                parcel2.writeNoException();
                return true;
            case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                IObjectWrapper iObjectWrapperAsInterface16 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzH(iObjectWrapperAsInterface16);
                parcel2.writeNoException();
                return true;
        }
    }
}
