package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhx implements Runnable {
    public static Boolean zzb;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private int zzi;
    private final zzdpw zzj;
    private final List zzk;
    private final zzcgz zzl;
    private final zzbvy zzn;
    public static final Object zza = new Object();
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final zzfic zzg = zzfig.zzb();
    private String zzh = "";
    private boolean zzm = false;

    public zzfhx(Context context, VersionInfoParcel versionInfoParcel, zzdpw zzdpwVar, zzeag zzeagVar, zzbvy zzbvyVar, zzcgz zzcgzVar) {
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzj = zzdpwVar;
        this.zzn = zzbvyVar;
        this.zzl = zzcgzVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjk)).booleanValue()) {
            this.zzk = com.google.android.gms.ads.internal.util.zzs.zzd();
        } else {
            this.zzk = zzfyq.zzn();
        }
    }

    public static boolean zza() {
        boolean zBooleanValue;
        synchronized (zza) {
            try {
                if (zzb == null) {
                    if (((Boolean) zzbex.zzb.zze()).booleanValue()) {
                        zzb = Boolean.valueOf(Math.random() < ((Double) zzbex.zza.zze()).doubleValue());
                    } else {
                        zzb = Boolean.FALSE;
                    }
                }
                zBooleanValue = zzb.booleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zBooleanValue;
    }

    public static void zzb(zzfhx zzfhxVar, zzfhn zzfhnVar) {
        synchronized (zzd) {
            try {
                if (!zzfhxVar.zzm) {
                    zzfhxVar.zzm = true;
                    if (zza()) {
                        try {
                            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                            zzfhxVar.zzh = com.google.android.gms.ads.internal.util.zzs.zzq(zzfhxVar.zze);
                        } catch (RemoteException | RuntimeException e) {
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                        }
                        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.zza;
                        Context context = zzfhxVar.zze;
                        googleApiAvailabilityLight.getClass();
                        zzfhxVar.zzi = GoogleApiAvailabilityLight.getApkVersion(context);
                        zzbcv zzbcvVar = zzbde.zzjf;
                        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                        int iIntValue = ((Integer) zzbdVar.zzd.zzb(zzbcvVar)).intValue();
                        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzmo)).booleanValue()) {
                            long j = iIntValue;
                            zzcaf.zzd.scheduleWithFixedDelay(zzfhxVar, j, j, TimeUnit.MILLISECONDS);
                        } else {
                            long j2 = iIntValue;
                            zzcaf.zzd.scheduleAtFixedRate(zzfhxVar, j2, j2, TimeUnit.MILLISECONDS);
                        }
                        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzjl)).booleanValue()) {
                            zzfhxVar.zzl.zzc();
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zza() && zzfhnVar != null) {
            synchronized (zzc) {
                try {
                    zzfic zzficVar = zzfhxVar.zzg;
                    int iZza = zzficVar.zza();
                    zzbcv zzbcvVar2 = zzbde.zzjg;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar2 = com.google.android.gms.ads.internal.client.zzbd.zza;
                    if (iZza >= ((Integer) zzbdVar2.zzd.zzb(zzbcvVar2)).intValue()) {
                        return;
                    }
                    zzfhy zzfhyVarZza = zzfib.zza();
                    zzfhyVarZza.zzw(zzfhnVar.zzm());
                    zzfhyVarZza.zzs(zzfhnVar.zzl());
                    zzfhyVarZza.zzh(zzfhnVar.zzb());
                    zzfhyVarZza.zzy(3);
                    zzfhyVarZza.zzp(zzfhxVar.zzf.afmaVersion);
                    zzfhyVarZza.zzb(zzfhxVar.zzh);
                    zzfhyVarZza.zzl(Build.VERSION.RELEASE);
                    zzfhyVarZza.zzt(Build.VERSION.SDK_INT);
                    zzfhyVarZza.zzx(zzfhnVar.zzo());
                    zzfhyVarZza.zzk(zzfhnVar.zza());
                    zzfhyVarZza.zzf(zzfhxVar.zzi);
                    zzfhyVarZza.zzv(zzfhnVar.zzn());
                    zzfhyVarZza.zzc(zzfhnVar.zze());
                    zzfhyVarZza.zzg(zzfhnVar.zzg());
                    zzfhyVarZza.zzi(zzfhnVar.zzh());
                    zzfhyVarZza.zzj(zzfhxVar.zzj.zzb(zzfhnVar.zzh()));
                    zzfhyVarZza.zzm(zzfhnVar.zzi());
                    zzfhyVarZza.zzo(zzfhnVar.zzd());
                    zzfhyVarZza.zzd(zzfhnVar.zzf());
                    zzfhyVarZza.zzu(zzfhnVar.zzk());
                    zzfhyVarZza.zzq(zzfhnVar.zzj());
                    zzfhyVarZza.zzr(zzfhnVar.zzc());
                    if (((Boolean) zzbdVar2.zzd.zzb(zzbde.zzjk)).booleanValue()) {
                        zzfhyVarZza.zza(zzfhxVar.zzk);
                    }
                    if (((Boolean) zzbdVar2.zzd.zzb(zzbde.zzjl)).booleanValue()) {
                        zzcgz zzcgzVar = zzfhxVar.zzl;
                        zzhcs zzhcsVarZza = zzcgzVar.zza();
                        String strZzb = zzcgzVar.zzb();
                        if (zzhcsVarZza != null) {
                            zzfhyVarZza.zze(zzhcsVarZza);
                        }
                        if (strZzb != null) {
                            zzfhyVarZza.zzn(strZzb);
                        }
                    }
                    zzfid zzfidVarZza = zzfie.zza();
                    zzfidVarZza.zza(zzfhyVarZza);
                    zzficVar.zzb(zzfidVarZza);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        byte[] bArrZzaV;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                try {
                    if (this.zzg.zza() == 0) {
                        return;
                    }
                    try {
                        synchronized (obj) {
                            zzfic zzficVar = this.zzg;
                            bArrZzaV = ((zzfig) zzficVar.zzbr()).zzaV();
                            zzficVar.zzc();
                        }
                        new zzeaf(this.zze, this.zzf.afmaVersion, this.zzn, Binder.getCallingUid()).zza(new zzead((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzje), 60000, new HashMap(), bArrZzaV, "application/x-protobuf", false));
                    } catch (Exception e) {
                        if ((e instanceof zzdwm) && ((zzdwm) e).zza() == 3) {
                            return;
                        }
                        com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, "CuiMonitor.sendCuiPing");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void zzc(final zzfhn zzfhnVar) {
        zzcaf.zza.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfhw
            @Override // java.lang.Runnable
            public final void run() {
                zzfhx.zzb(this.zza, zzfhnVar);
            }
        });
    }
}
