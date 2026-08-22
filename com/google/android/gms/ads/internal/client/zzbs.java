package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbhm;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbhp;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhs;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbhz;
import com.google.android.gms.internal.ads.zzbia;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzbid;
import com.google.android.gms.internal.ads.zzbmp;
import com.google.android.gms.internal.ads.zzbmx;
import com.google.android.gms.internal.ads.zzbmy;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzbs extends zzayu implements zzbt {
    public zzbs() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        zzbk zzbiVar = null;
        zzcs zzcsVar = null;
        switch (i) {
            case 1:
                zzbq zzbqVarZze = zze();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbqVarZze);
                return true;
            case 2:
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzbiVar = iInterfaceQueryLocalInterface instanceof zzbk ? (zzbk) iInterfaceQueryLocalInterface : new zzbi(strongBinder);
                }
                zzayv.zzd(parcel);
                zzl(zzbiVar);
                parcel2.writeNoException();
                return true;
            case 3:
                zzbhn zzbhnVarZzb = zzbhm.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzf(zzbhnVarZzb);
                parcel2.writeNoException();
                return true;
            case 4:
                zzbhq zzbhqVarZzb = zzbhp.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzg(zzbhqVarZzb);
                parcel2.writeNoException();
                return true;
            case 5:
                String string = parcel.readString();
                zzbhw zzbhwVarZzb = zzbhv.zzb(parcel.readStrongBinder());
                zzbht zzbhtVarZzb = zzbhs.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzh(string, zzbhwVarZzb, zzbhtVarZzb);
                parcel2.writeNoException();
                return true;
            case 6:
                zzbge zzbgeVar = (zzbge) zzayv.zza(parcel, zzbge.CREATOR);
                zzayv.zzd(parcel);
                zzo(zzbgeVar);
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzcsVar = iInterfaceQueryLocalInterface2 instanceof zzcs ? (zzcs) iInterfaceQueryLocalInterface2 : new zzcs(strongBinder2);
                }
                zzayv.zzd(parcel);
                zzq(zzcsVar);
                parcel2.writeNoException();
                return true;
            case 8:
                zzbia zzbiaVarZzb = zzbhz.zzb(parcel.readStrongBinder());
                zzr zzrVar = (zzr) zzayv.zza(parcel, zzr.CREATOR);
                zzayv.zzd(parcel);
                zzj(zzbiaVarZzb, zzrVar);
                parcel2.writeNoException();
                return true;
            case 9:
                PublisherAdViewOptions publisherAdViewOptions = (PublisherAdViewOptions) zzayv.zza(parcel, PublisherAdViewOptions.CREATOR);
                zzayv.zzd(parcel);
                zzp(publisherAdViewOptions);
                parcel2.writeNoException();
                return true;
            case 10:
                zzbid zzbidVarZzb = zzbic.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzk(zzbidVarZzb);
                parcel2.writeNoException();
                return true;
            case 11:
            case 12:
            default:
                return false;
            case 13:
                zzbmp zzbmpVar = (zzbmp) zzayv.zza(parcel, zzbmp.CREATOR);
                zzayv.zzd(parcel);
                zzn(zzbmpVar);
                parcel2.writeNoException();
                return true;
            case 14:
                zzbmy zzbmyVarZzb = zzbmx.zzb(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzi(zzbmyVarZzb);
                parcel2.writeNoException();
                return true;
            case 15:
                AdManagerAdViewOptions adManagerAdViewOptions = (AdManagerAdViewOptions) zzayv.zza(parcel, AdManagerAdViewOptions.CREATOR);
                zzayv.zzd(parcel);
                zzm(adManagerAdViewOptions);
                parcel2.writeNoException();
                return true;
        }
    }
}
