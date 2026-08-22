package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.protobuf.DescriptorProtos;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbpv extends zzayu implements zzbpw {
    public zzbpv() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzbpw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return iInterfaceQueryLocalInterface instanceof zzbpw ? (zzbpw) iInterfaceQueryLocalInterface : new zzbpu(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                int i3 = parcel.readInt();
                zzayv.zzd(parcel);
                zzg(i3);
                break;
            case 4:
                zzn();
                break;
            case 5:
                zzp();
                break;
            case 6:
                zzo();
                break;
            case 7:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    boolean z = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata") instanceof zzbqa;
                }
                zzayv.zzd(parcel);
                break;
            case 8:
                zzm();
                break;
            case 9:
                String string = parcel.readString();
                String string2 = parcel.readString();
                zzayv.zzd(parcel);
                zzq(string, string2);
                break;
            case 10:
                zzbhi.zzb(parcel.readStrongBinder());
                parcel.readString();
                zzayv.zzd(parcel);
                break;
            case 11:
                zzw();
                break;
            case 12:
                parcel.readString();
                zzayv.zzd(parcel);
                break;
            case 13:
                zzz();
                break;
            case 14:
                zzbwo zzbwoVar = (zzbwo) zzayv.zza(parcel, zzbwo.CREATOR);
                zzayv.zzd(parcel);
                zzs(zzbwoVar);
                break;
            case 15:
                zzx();
                break;
            case 16:
                zzbws zzbwsVarZzb = zzbwr.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzt(zzbwsVarZzb);
                break;
            case 17:
                int i4 = parcel.readInt();
                zzayv.zzd(parcel);
                zzj(i4);
                break;
            case 18:
                zzv();
                break;
            case 19:
                zzayv.zzd(parcel);
                break;
            case 20:
                zzy();
                break;
            case 21:
                String string3 = parcel.readString();
                zzayv.zzd(parcel);
                zzl(string3);
                break;
            case 22:
                int i5 = parcel.readInt();
                String string4 = parcel.readString();
                zzayv.zzd(parcel);
                zzi(i5, string4);
                break;
            case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                com.google.android.gms.ads.internal.client.zze zzeVar = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzayv.zzd(parcel);
                zzh(zzeVar);
                break;
            case 24:
                com.google.android.gms.ads.internal.client.zze zzeVar2 = (com.google.android.gms.ads.internal.client.zze) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zze.CREATOR);
                zzayv.zzd(parcel);
                zzk(zzeVar2);
                break;
            case 25:
                zzu();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
