package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.client.zzcr;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzayv;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbld;
import com.google.android.gms.internal.ads.zzble;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzdjn;
import com.google.android.gms.internal.ads.zzdjp;
import com.google.android.gms.internal.ads.zzdtt;
import com.google.android.gms.internal.ads.zzekb;
import com.google.android.gms.internal.ads.zzexa;
import com.google.android.gms.internal.ads.zzeyo;
import com.google.android.gms.internal.ads.zzfaf;
import com.google.android.gms.internal.ads.zzfbt;
import com.google.android.gms.internal.ads.zzfbx;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ClientApi extends zzayu implements zzcr {
    public ClientApi() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbt zzb(IObjectWrapper iObjectWrapper, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzekb(zzche.zza(context, zzbpqVar, i), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzexa zzexaVarZzs = zzche.zza(context, zzbpqVar, i).zzs();
        zzexaVarZzs.zza(str);
        zzexaVarZzs.zzb(context);
        return zzexaVarZzs.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzd(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeyo zzeyoVarZzt = zzche.zza(context, zzbpqVar, i).zzt();
        zzeyoVarZzt.zzc(context);
        zzeyoVarZzt.zza(zzrVar);
        zzeyoVarZzt.zzb(str);
        return zzeyoVarZzt.zzd().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzayu
    public final boolean zzde(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                String string = parcel.readString();
                zzbpq zzbpqVarZzf = zzbpp.zzf(parcel.readStrongBinder());
                int i3 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbx zzbxVarZzd = zzd(iObjectWrapperAsInterface, zzrVar, string, zzbpqVarZzf, i3);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbxVarZzd);
                return true;
            case 2:
                IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar2 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                String string2 = parcel.readString();
                zzbpq zzbpqVarZzf2 = zzbpp.zzf(parcel.readStrongBinder());
                int i4 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbx zzbxVarZze = zze(iObjectWrapperAsInterface2, zzrVar2, string2, zzbpqVarZzf2, i4);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbxVarZze);
                return true;
            case 3:
                IObjectWrapper iObjectWrapperAsInterface3 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                String string3 = parcel.readString();
                zzbpq zzbpqVarZzf3 = zzbpp.zzf(parcel.readStrongBinder());
                int i5 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbt zzbtVarZzb = zzb(iObjectWrapperAsInterface3, string3, zzbpqVarZzf3, i5);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbtVarZzb);
                return true;
            case 4:
                ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 5:
                IObjectWrapper iObjectWrapperAsInterface4 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface5 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzbgt zzbgtVarZzj = zzj(iObjectWrapperAsInterface4, iObjectWrapperAsInterface5);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbgtVarZzj);
                return true;
            case 6:
                IObjectWrapper iObjectWrapperAsInterface6 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbpq zzbpqVarZzf4 = zzbpp.zzf(parcel.readStrongBinder());
                int i6 = parcel.readInt();
                zzayv.zzd(parcel);
                Context context = (Context) ObjectWrapper.unwrap(iObjectWrapperAsInterface6);
                zzfbt zzfbtVarZzv = zzche.zza(context, zzbpqVarZzf4, i6).zzv();
                zzfbtVarZzv.zzb(context);
                zzfbx zzfbxVarZzb = zzfbtVarZzv.zzc().zzb();
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzfbxVarZzb);
                return true;
            case 7:
                ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, null);
                return true;
            case 8:
                IObjectWrapper iObjectWrapperAsInterface7 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzbtq zzbtqVarZzn = zzn(iObjectWrapperAsInterface7);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbtqVarZzn);
                return true;
            case 9:
                IObjectWrapper iObjectWrapperAsInterface8 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                int i7 = parcel.readInt();
                zzayv.zzd(parcel);
                zzdb zzdbVarZzh = zzh(iObjectWrapperAsInterface8, i7);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzdbVarZzh);
                return true;
            case 10:
                IObjectWrapper iObjectWrapperAsInterface9 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar3 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                String string4 = parcel.readString();
                int i8 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbx zzbxVarZzf = zzf(iObjectWrapperAsInterface9, zzrVar3, string4, i8);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbxVarZzf);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperAsInterface10 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface11 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                IObjectWrapper iObjectWrapperAsInterface12 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzdjn zzdjnVar = new zzdjn((View) ObjectWrapper.unwrap(iObjectWrapperAsInterface10), (HashMap) ObjectWrapper.unwrap(iObjectWrapperAsInterface11), (HashMap) ObjectWrapper.unwrap(iObjectWrapperAsInterface12));
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzdjnVar);
                return true;
            case 12:
                IObjectWrapper iObjectWrapperAsInterface13 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                String string5 = parcel.readString();
                zzbpq zzbpqVarZzf5 = zzbpp.zzf(parcel.readStrongBinder());
                int i9 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbwv zzbwvVarZzp = zzp(iObjectWrapperAsInterface13, string5, zzbpqVarZzf5, i9);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbwvVarZzp);
                return true;
            case 13:
                IObjectWrapper iObjectWrapperAsInterface14 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                com.google.android.gms.ads.internal.client.zzr zzrVar4 = (com.google.android.gms.ads.internal.client.zzr) zzayv.zza(parcel, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                String string6 = parcel.readString();
                zzbpq zzbpqVarZzf6 = zzbpp.zzf(parcel.readStrongBinder());
                int i10 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbx zzbxVarZzc = zzc(iObjectWrapperAsInterface14, zzrVar4, string6, zzbpqVarZzf6, i10);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbxVarZzc);
                return true;
            case 14:
                IObjectWrapper iObjectWrapperAsInterface15 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbpq zzbpqVarZzf7 = zzbpp.zzf(parcel.readStrongBinder());
                int i11 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbza zzbzaVarZzq = zzq(iObjectWrapperAsInterface15, zzbpqVarZzf7, i11);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbzaVarZzq);
                return true;
            case 15:
                IObjectWrapper iObjectWrapperAsInterface16 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbpq zzbpqVarZzf8 = zzbpp.zzf(parcel.readStrongBinder());
                int i12 = parcel.readInt();
                zzayv.zzd(parcel);
                zzbtj zzbtjVarZzm = zzm(iObjectWrapperAsInterface16, zzbpqVarZzf8, i12);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzbtjVarZzm);
                return true;
            case 16:
                IObjectWrapper iObjectWrapperAsInterface17 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbpq zzbpqVarZzf9 = zzbpp.zzf(parcel.readStrongBinder());
                int i13 = parcel.readInt();
                zzble zzbleVarZzc = zzbld.zzc(parcel.readStrongBinder());
                zzayv.zzd(parcel);
                zzblh zzblhVarZzl = zzl(iObjectWrapperAsInterface17, zzbpqVarZzf9, i13, zzbleVarZzc);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzblhVarZzl);
                return true;
            case 17:
                IObjectWrapper iObjectWrapperAsInterface18 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbpq zzbpqVarZzf10 = zzbpp.zzf(parcel.readStrongBinder());
                int i14 = parcel.readInt();
                zzayv.zzd(parcel);
                zzdw zzdwVarZzi = zzi(iObjectWrapperAsInterface18, zzbpqVarZzf10, i14);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzdwVarZzi);
                return true;
            case 18:
                IObjectWrapper iObjectWrapperAsInterface19 = ObjectWrapper.asInterface(parcel.readStrongBinder());
                zzbpq zzbpqVarZzf11 = zzbpp.zzf(parcel.readStrongBinder());
                int i15 = parcel.readInt();
                zzayv.zzd(parcel);
                zzck zzckVarZzg = zzg(iObjectWrapperAsInterface19, zzbpqVarZzf11, i15);
                parcel2.writeNoException();
                zzayv.zzg(parcel2, zzckVarZzg);
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfaf zzfafVarZzu = zzche.zza(context, zzbpqVar, i).zzu();
        zzfafVarZzu.zzc(context);
        zzfafVarZzu.zza(zzrVar);
        zzfafVarZzu.zzb(str);
        return zzfafVarZzu.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzf(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i) {
        return new zzu((Context) ObjectWrapper.unwrap(iObjectWrapper), zzrVar, str, new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzck zzg(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpqVar, i).zzz();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdb zzh(IObjectWrapper iObjectWrapper, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i).zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdw zzi(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpqVar, i).zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbgt zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdjp((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzblh zzl(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i, zzble zzbleVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdtt zzdttVarZzj = zzche.zza(context, zzbpqVar, i).zzj();
        zzdttVarZzj.zzb(context);
        zzdttVarZzj.zza(zzbleVar);
        return zzdttVarZzj.zzc().zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbtj zzm(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpqVar, i).zzm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbtq zzn(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (adOverlayInfoParcelZza == null) {
            return new com.google.android.gms.ads.internal.overlay.zzv(activity, 4);
        }
        int i = adOverlayInfoParcelZza.zzk;
        if (i == 1) {
            return new com.google.android.gms.ads.internal.overlay.zzv(activity, 0);
        }
        if (i == 2) {
            return new com.google.android.gms.ads.internal.overlay.zzv(activity, 2);
        }
        if (i == 3) {
            return new com.google.android.gms.ads.internal.overlay.zzv(activity, 3);
        }
        if (i != 4) {
            return i != 5 ? new com.google.android.gms.ads.internal.overlay.zzv(activity, 4) : new com.google.android.gms.ads.internal.overlay.zzv(activity, 1);
        }
        return new zzac(activity, adOverlayInfoParcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbwv zzp(IObjectWrapper iObjectWrapper, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfbt zzfbtVarZzv = zzche.zza(context, zzbpqVar, i).zzv();
        zzfbtVarZzv.zzb(context);
        zzfbtVarZzv.zza(str);
        return zzfbtVarZzv.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbza zzq(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpqVar, i).zzp();
    }
}
