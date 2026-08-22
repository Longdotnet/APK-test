package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.appset.zzb;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbix;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcwl;
import com.google.android.gms.internal.ads.zzded;
import com.google.android.gms.internal.ads.zzdgc;
import com.google.android.gms.internal.ads.zzdvt;
import com.google.android.gms.internal.ads.zzecl;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzb(25);
    public static final AtomicLong zzy = new AtomicLong(0);
    public static final ConcurrentHashMap zzz = new ConcurrentHashMap();
    public final zzc zza;
    public final zza zzb;
    public final zzr zzc;
    public final zzcfg zzd;
    public final zzbix zze;
    public final String zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzad zzi;
    public final int zzj;
    public final int zzk;
    public final String zzl;
    public final VersionInfoParcel zzm;
    public final String zzn;
    public final zzl zzo;
    public final zzbiv zzp;
    public final String zzq;
    public final String zzr;
    public final String zzs;
    public final zzcwl zzt;
    public final zzded zzu;
    public final zzbtj zzv;
    public final boolean zzw;
    public final long zzx;

    public AdOverlayInfoParcel(zza zzaVar, zzr zzrVar, zzad zzadVar, zzcfg zzcfgVar, boolean z, int i, VersionInfoParcel versionInfoParcel, zzded zzdedVar, zzecl zzeclVar) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzadVar;
        this.zzj = i;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdedVar;
        this.zzv = zzeclVar;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public static AdOverlayInfoParcel zza(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            if (!((Boolean) zzbd.zza.zzd.zzb(zzbde.zzno)).booleanValue()) {
                return null;
            }
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "AdOverlayInfoParcel.getFromIntent");
            return null;
        }
    }

    public static final IBinder zzc(Object obj) {
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzno)).booleanValue()) {
            return null;
        }
        return new ObjectWrapper(obj).asBinder();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 2, this.zza, i, false);
        zza zzaVar = this.zzb;
        CloseableKt.writeIBinder(parcel, 3, zzc(zzaVar));
        zzr zzrVar = this.zzc;
        CloseableKt.writeIBinder(parcel, 4, zzc(zzrVar));
        zzcfg zzcfgVar = this.zzd;
        CloseableKt.writeIBinder(parcel, 5, zzc(zzcfgVar));
        zzbix zzbixVar = this.zze;
        CloseableKt.writeIBinder(parcel, 6, zzc(zzbixVar));
        CloseableKt.writeString(parcel, 7, this.zzf, false);
        CloseableKt.zzc(parcel, 8, 4);
        parcel.writeInt(this.zzg ? 1 : 0);
        CloseableKt.writeString(parcel, 9, this.zzh, false);
        zzad zzadVar = this.zzi;
        CloseableKt.writeIBinder(parcel, 10, zzc(zzadVar));
        CloseableKt.zzc(parcel, 11, 4);
        parcel.writeInt(this.zzj);
        CloseableKt.zzc(parcel, 12, 4);
        parcel.writeInt(this.zzk);
        CloseableKt.writeString(parcel, 13, this.zzl, false);
        CloseableKt.writeParcelable(parcel, 14, this.zzm, i, false);
        CloseableKt.writeString(parcel, 16, this.zzn, false);
        CloseableKt.writeParcelable(parcel, 17, this.zzo, i, false);
        zzbiv zzbivVar = this.zzp;
        CloseableKt.writeIBinder(parcel, 18, zzc(zzbivVar));
        CloseableKt.writeString(parcel, 19, this.zzq, false);
        CloseableKt.writeString(parcel, 24, this.zzr, false);
        CloseableKt.writeString(parcel, 25, this.zzs, false);
        zzcwl zzcwlVar = this.zzt;
        CloseableKt.writeIBinder(parcel, 26, zzc(zzcwlVar));
        zzded zzdedVar = this.zzu;
        CloseableKt.writeIBinder(parcel, 27, zzc(zzdedVar));
        zzbtj zzbtjVar = this.zzv;
        CloseableKt.writeIBinder(parcel, 28, zzc(zzbtjVar));
        CloseableKt.zzc(parcel, 29, 4);
        parcel.writeInt(this.zzw ? 1 : 0);
        CloseableKt.zzc(parcel, 30, 8);
        long j = this.zzx;
        parcel.writeLong(j);
        CloseableKt.zzb(parcel, iZza);
        zzbcv zzbcvVar = zzbde.zzno;
        zzbd zzbdVar = zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            zzz.put(Long.valueOf(j), new zzp(zzaVar, zzrVar, zzcfgVar, zzbivVar, zzbixVar, zzadVar, zzcwlVar, zzdedVar, zzbtjVar, zzcaf.zzd.schedule(new zzq(j), ((Integer) zzbdVar.zzd.zzb(zzbde.zznq)).intValue(), TimeUnit.SECONDS)));
        }
    }

    public AdOverlayInfoParcel(zza zzaVar, zzr zzrVar, zzbiv zzbivVar, zzbix zzbixVar, zzad zzadVar, zzcfg zzcfgVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzded zzdedVar, zzecl zzeclVar, boolean z2) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = zzbivVar;
        this.zze = zzbixVar;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzadVar;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdedVar;
        this.zzv = zzeclVar;
        this.zzw = z2;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zza zzaVar, zzr zzrVar, zzbiv zzbivVar, zzbix zzbixVar, zzad zzadVar, zzcfg zzcfgVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzded zzdedVar, zzecl zzeclVar) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = zzbivVar;
        this.zze = zzbixVar;
        this.zzf = str2;
        this.zzg = z;
        this.zzh = str;
        this.zzi = zzadVar;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdedVar;
        this.zzv = zzeclVar;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzc zzcVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, VersionInfoParcel versionInfoParcel, String str4, zzl zzlVar, IBinder iBinder6, String str5, String str6, String str7, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, boolean z2, long j) {
        this.zza = zzcVar;
        this.zzf = str;
        this.zzg = z;
        this.zzh = str2;
        this.zzj = i;
        this.zzk = i2;
        this.zzl = str3;
        this.zzm = versionInfoParcel;
        this.zzn = str4;
        this.zzo = zzlVar;
        this.zzq = str5;
        this.zzr = str6;
        this.zzs = str7;
        this.zzw = z2;
        this.zzx = j;
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzno)).booleanValue()) {
            zzp zzpVar = (zzp) zzz.remove(Long.valueOf(j));
            if (zzpVar != null) {
                this.zzb = zzpVar.zza;
                this.zzc = zzpVar.zzb;
                this.zzd = zzpVar.zzc;
                this.zzp = zzpVar.zzd;
                this.zze = zzpVar.zze;
                this.zzt = zzpVar.zzg;
                this.zzu = zzpVar.zzh;
                this.zzv = zzpVar.zzi;
                this.zzi = zzpVar.zzf;
                zzpVar.zzj.cancel(false);
                return;
            }
            throw new NullPointerException("AdOverlayObjects is null");
        }
        this.zzb = (zza) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder));
        this.zzc = (zzr) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder2));
        this.zzd = (zzcfg) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder3));
        this.zzp = (zzbiv) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder6));
        this.zze = (zzbix) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder4));
        this.zzi = (zzad) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder5));
        this.zzt = (zzcwl) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder7));
        this.zzu = (zzded) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder8));
        this.zzv = (zzbtj) ObjectWrapper.unwrap(ObjectWrapper.asInterface(iBinder9));
    }

    public AdOverlayInfoParcel(zzc zzcVar, zza zzaVar, zzr zzrVar, zzad zzadVar, VersionInfoParcel versionInfoParcel, zzcfg zzcfgVar, zzded zzdedVar, String str) {
        this.zza = zzcVar;
        this.zzb = zzaVar;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzadVar;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdedVar;
        this.zzv = null;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzcfg zzcfgVar, VersionInfoParcel versionInfoParcel, String str, String str2, zzbtj zzbtjVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcfgVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = 14;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzr = str2;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzbtjVar;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzdgc zzdgcVar, zzcfg zzcfgVar, int i, VersionInfoParcel versionInfoParcel, String str, zzl zzlVar, String str2, String str3, String str4, zzcwl zzcwlVar, zzecl zzeclVar, String str5) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzdgcVar;
        this.zzd = zzcfgVar;
        this.zzp = null;
        this.zze = null;
        this.zzg = false;
        if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzaX)).booleanValue()) {
            this.zzf = null;
            this.zzh = null;
        } else {
            this.zzf = str2;
            this.zzh = str3;
        }
        this.zzi = null;
        this.zzj = i;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = str;
        this.zzo = zzlVar;
        this.zzq = str5;
        this.zzr = null;
        this.zzs = str4;
        this.zzt = zzcwlVar;
        this.zzu = null;
        this.zzv = zzeclVar;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzdvt zzdvtVar, zzcfg zzcfgVar, VersionInfoParcel versionInfoParcel) {
        this.zzc = zzdvtVar;
        this.zzd = zzcfgVar;
        this.zzj = 1;
        this.zzm = versionInfoParcel;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }
}
