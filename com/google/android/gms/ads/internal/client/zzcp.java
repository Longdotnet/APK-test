package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzayt;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbgs;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzble;
import com.google.android.gms.internal.ads.zzblg;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbti;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbwu;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.internal.ads.zzbza;

/* JADX INFO: loaded from: classes.dex */
public final class zzcp extends zzayt implements zzcr {
    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbt zzb(IObjectWrapper iObjectWrapper, String str, zzbpq zzbpqVar, int i) {
        zzbt zzbrVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(3, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbrVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzbrVar = iInterfaceQueryLocalInterface instanceof zzbt ? (zzbt) iInterfaceQueryLocalInterface : new zzbr(strongBinder);
        }
        parcelZzda.recycle();
        return zzbrVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzc(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(13, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzda.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzd(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(1, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzda.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zze(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzrVar);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(2, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzda.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzf(IObjectWrapper iObjectWrapper, zzr zzrVar, String str, int i) {
        zzbx zzbvVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zze(parcelZza, zzrVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(10, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzbvVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbvVar = iInterfaceQueryLocalInterface instanceof zzbx ? (zzbx) iInterfaceQueryLocalInterface : new zzbv(strongBinder);
        }
        parcelZzda.recycle();
        return zzbvVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzck zzg(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        zzck zzciVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(18, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzciVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdPreloader");
            zzciVar = iInterfaceQueryLocalInterface instanceof zzck ? (zzck) iInterfaceQueryLocalInterface : new zzci(strongBinder);
        }
        parcelZzda.recycle();
        return zzciVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdb zzh(IObjectWrapper iObjectWrapper, int i) {
        zzdb zzczVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(9, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzczVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzczVar = iInterfaceQueryLocalInterface instanceof zzdb ? (zzdb) iInterfaceQueryLocalInterface : new zzcz(strongBinder);
        }
        parcelZzda.recycle();
        return zzczVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdw zzi(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        zzdw zzduVar;
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(17, parcelZza);
        IBinder strongBinder = parcelZzda.readStrongBinder();
        if (strongBinder == null) {
            zzduVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzduVar = iInterfaceQueryLocalInterface instanceof zzdw ? (zzdw) iInterfaceQueryLocalInterface : new zzdu(strongBinder);
        }
        parcelZzda.recycle();
        return zzduVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbgt zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, iObjectWrapper2);
        Parcel parcelZzda = zzda(5, parcelZza);
        zzbgt zzbgtVarZzdC = zzbgs.zzdC(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbgtVarZzdC;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzblh zzl(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i, zzble zzbleVar) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        zzayv.zzg(parcelZza, zzbleVar);
        Parcel parcelZzda = zzda(16, parcelZza);
        zzblh zzblhVarZzb = zzblg.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzblhVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbtj zzm(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(15, parcelZza);
        zzbtj zzbtjVarZzb = zzbti.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbtjVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbtq zzn(IObjectWrapper iObjectWrapper) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        Parcel parcelZzda = zzda(8, parcelZza);
        zzbtq zzbtqVarZzI = zzbtp.zzI(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbtqVarZzI;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbwv zzp(IObjectWrapper iObjectWrapper, String str, zzbpq zzbpqVar, int i) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(12, parcelZza);
        zzbwv zzbwvVarZzt = zzbwu.zzt(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbwvVarZzt;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbza zzq(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        Parcel parcelZza = zza();
        zzayv.zzg(parcelZza, iObjectWrapper);
        zzayv.zzg(parcelZza, zzbpqVar);
        parcelZza.writeInt(ModuleDescriptor.MODULE_VERSION);
        Parcel parcelZzda = zzda(14, parcelZza);
        zzbza zzbzaVarZzb = zzbyz.zzb(parcelZzda.readStrongBinder());
        parcelZzda.recycle();
        return zzbzaVarZzb;
    }
}
