package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.protobuf.DescriptorProtos;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbro extends zzayu implements zzbrp {
    public zzbro() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzbrp zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzbrp ? (zzbrp) iInterfaceQueryLocalInterface : new zzbrn(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [com.google.android.gms.internal.ads.zzbrs] */
    /* JADX WARN: Type inference failed for: r11v2, types: [com.google.android.gms.internal.ads.zzbrd] */
    /* JADX WARN: Type inference failed for: r11v4, types: [com.google.android.gms.internal.ads.zzbrm] */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.google.android.gms.internal.ads.zzbrm] */
    /* JADX WARN: Type inference failed for: r11v7, types: [com.google.android.gms.internal.ads.zzbrd] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.google.android.gms.internal.ads.zzbro, com.google.android.gms.internal.ads.zzbrp] */
    /* JADX WARN: Type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzbrj] */
    /* JADX WARN: Type inference failed for: r5v18, types: [com.google.android.gms.internal.ads.zzbrj] */
    /* JADX WARN: Type inference failed for: r7v14, types: [com.google.android.gms.internal.ads.zzbra] */
    /* JADX WARN: Type inference failed for: r7v5, types: [com.google.android.gms.internal.ads.zzbrg] */
    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface zzbqyVar = null;
        if (i == 1) {
            IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
            String string = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) zzayv.zza(parcel, creator);
            Bundle bundle2 = (Bundle) zzayv.zza(parcel, creator);
            com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder != null) {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzbqyVar = iInterfaceQueryLocalInterface instanceof zzbrs ? (zzbrs) iInterfaceQueryLocalInterface : new zzbrq(strongBinder);
            }
            ?? r11 = zzbqyVar;
            zzayv.zzd(parcel);
            zzh(iObjectWrapperAsInterface, string, bundle, bundle2, zzrVar, r11);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzbse zzbseVarZzf = zzf();
            parcel2.writeNoException();
            zzayv.zzf(parcel2, zzbseVarZzf);
        } else if (i == 3) {
            zzbse zzbseVarZzg = zzg();
            parcel2.writeNoException();
            zzayv.zzf(parcel2, zzbseVarZzg);
        } else if (i == 5) {
            com.google.android.gms.ads.internal.client.zzed zzedVarZze = zze();
            parcel2.writeNoException();
            zzayv.zzg(parcel2, zzedVarZze);
        } else if (i == 10) {
            ObjectWrapper.asInterface(parcel.readStrongBinder());
            zzayv.zzd(parcel);
            parcel2.writeNoException();
        } else if (i != 11) {
            switch (i) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbqyVar = iInterfaceQueryLocalInterface2 instanceof zzbrd ? (zzbrd) iInterfaceQueryLocalInterface2 : new zzbrb(strongBinder2);
                    }
                    ?? r12 = zzbqyVar;
                    zzbpw zzbpwVarZzb = zzbpv.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzayv.zzd(parcel);
                    zzj(string2, string3, zzmVar, iObjectWrapperAsInterface2, r12, zzbpwVarZzb, zzrVar2);
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar2 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzbqyVar = iInterfaceQueryLocalInterface3 instanceof zzbrg ? (zzbrg) iInterfaceQueryLocalInterface3 : new zzbre(strongBinder3);
                    }
                    ?? r7 = zzbqyVar;
                    zzbpw zzbpwVarZzb2 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzl(string4, string5, zzmVar2, iObjectWrapperAsInterface3, r7, zzbpwVarZzb2);
                    parcel2.writeNoException();
                    break;
                case 15:
                    IObjectWrapper iObjectWrapperAsInterface4 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    boolean zZzs = zzs(iObjectWrapperAsInterface4);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzs ? 1 : 0);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar3 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface5 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbqyVar = iInterfaceQueryLocalInterface4 instanceof zzbrm ? (zzbrm) iInterfaceQueryLocalInterface4 : new zzbrk(strongBinder4);
                    }
                    ?? r13 = zzbqyVar;
                    zzbpw zzbpwVarZzb3 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzp(string6, string7, zzmVar3, iObjectWrapperAsInterface5, r13, zzbpwVarZzb3);
                    parcel2.writeNoException();
                    break;
                case 17:
                    IObjectWrapper iObjectWrapperAsInterface6 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    boolean zZzt = zzt(iObjectWrapperAsInterface6);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzt ? 1 : 0);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar4 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface7 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbqyVar = iInterfaceQueryLocalInterface5 instanceof zzbrj ? (zzbrj) iInterfaceQueryLocalInterface5 : new zzbrh(strongBinder5);
                    }
                    ?? r5 = zzbqyVar;
                    zzbpw zzbpwVarZzb4 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzm(string8, string9, zzmVar4, iObjectWrapperAsInterface7, r5, zzbpwVarZzb4);
                    parcel2.writeNoException();
                    break;
                case 19:
                    String string10 = parcel.readString();
                    zzayv.zzd(parcel);
                    zzq(string10);
                    parcel2.writeNoException();
                    break;
                case 20:
                    String string11 = parcel.readString();
                    String string12 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar5 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface8 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder6 = parcel.readStrongBinder();
                    if (strongBinder6 != null) {
                        IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzbqyVar = iInterfaceQueryLocalInterface6 instanceof zzbrm ? (zzbrm) iInterfaceQueryLocalInterface6 : new zzbrk(strongBinder6);
                    }
                    ?? r14 = zzbqyVar;
                    zzbpw zzbpwVarZzb5 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzo(string11, string12, zzmVar5, iObjectWrapperAsInterface8, r14, zzbpwVarZzb5);
                    parcel2.writeNoException();
                    break;
                case 21:
                    String string13 = parcel.readString();
                    String string14 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar6 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface9 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder7 = parcel.readStrongBinder();
                    if (strongBinder7 != null) {
                        IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzbqyVar = iInterfaceQueryLocalInterface7 instanceof zzbrd ? (zzbrd) iInterfaceQueryLocalInterface7 : new zzbrb(strongBinder7);
                    }
                    ?? r15 = zzbqyVar;
                    zzbpw zzbpwVarZzb6 = zzbpv.zzb(parcel.readStrongBinder());
                    com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    zzayv.zzd(parcel);
                    zzk(string13, string14, zzmVar6, iObjectWrapperAsInterface9, r15, zzbpwVarZzb6, zzrVar3);
                    parcel2.writeNoException();
                    break;
                case 22:
                    String string15 = parcel.readString();
                    String string16 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar7 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface10 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder8 = parcel.readStrongBinder();
                    if (strongBinder8 != null) {
                        IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzbqyVar = iInterfaceQueryLocalInterface8 instanceof zzbrj ? (zzbrj) iInterfaceQueryLocalInterface8 : new zzbrh(strongBinder8);
                    }
                    ?? r6 = zzbqyVar;
                    zzbpw zzbpwVarZzb7 = zzbpv.zzb(parcel.readStrongBinder());
                    zzbge zzbgeVar = (zzbge) zzayv.zza(parcel, zzbge.CREATOR);
                    zzayv.zzd(parcel);
                    zzn(string15, string16, zzmVar7, iObjectWrapperAsInterface10, r6, zzbpwVarZzb7, zzbgeVar);
                    parcel2.writeNoException();
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    String string17 = parcel.readString();
                    String string18 = parcel.readString();
                    com.google.android.gms.ads.internal.client.zzm zzmVar8 = (com.google.android.gms.ads.internal.client.zzm) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    IObjectWrapper iObjectWrapperAsInterface11 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    IBinder strongBinder9 = parcel.readStrongBinder();
                    if (strongBinder9 != null) {
                        IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IAppOpenCallback");
                        zzbqyVar = iInterfaceQueryLocalInterface9 instanceof zzbra ? (zzbra) iInterfaceQueryLocalInterface9 : new zzbqy(strongBinder9);
                    }
                    ?? r8 = zzbqyVar;
                    zzbpw zzbpwVarZzb8 = zzbpv.zzb(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    zzi(string17, string18, zzmVar8, iObjectWrapperAsInterface11, r8, zzbpwVarZzb8);
                    parcel2.writeNoException();
                    break;
                case 24:
                    IObjectWrapper iObjectWrapperAsInterface12 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                    zzayv.zzd(parcel);
                    boolean zZzr = zzr(iObjectWrapperAsInterface12);
                    parcel2.writeNoException();
                    parcel2.writeInt(zZzr ? 1 : 0);
                    break;
                default:
                    return false;
            }
        } else {
            parcel.createStringArray();
            zzayv.zzd(parcel);
            parcel2.writeNoException();
        }
        return true;
    }
}
