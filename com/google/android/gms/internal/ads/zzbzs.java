package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbzs {
    private final Object zza = new Object();
    private final com.google.android.gms.ads.internal.util.zzj zzb;
    private final zzbzw zzc;
    private boolean zzd;
    private Context zze;
    private VersionInfoParcel zzf;
    private String zzg;
    private zzbdj zzh;
    private Boolean zzi;
    private final AtomicInteger zzj;
    private final AtomicInteger zzk;
    private final zzbzq zzl;
    private final Object zzm;
    private ListenableFuture zzn;
    private final AtomicBoolean zzo;

    public zzbzs() {
        com.google.android.gms.ads.internal.util.zzj zzjVar = new com.google.android.gms.ads.internal.util.zzj();
        this.zzb = zzjVar;
        this.zzc = new zzbzw(com.google.android.gms.ads.internal.client.zzbb.zzb.zze, zzjVar);
        this.zzd = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = new AtomicInteger(0);
        this.zzk = new AtomicInteger(0);
        this.zzl = new zzbzq(null);
        this.zzm = new Object();
        this.zzo = new AtomicBoolean();
    }

    public static /* synthetic */ ArrayList zzo(zzbzs zzbzsVar) {
        Context contextZza = zzbwa.zza(zzbzsVar.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(contextZza).getPackageInfo(4096, contextZza.getApplicationInfo().packageName);
            if (packageInfo.requestedPermissions != null && packageInfo.requestedPermissionsFlags != null) {
                int i = 0;
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(strArr[i]);
                    }
                    i++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final boolean zzA(Context context) {
        if (Hex.isAtLeastO()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziN)).booleanValue()) {
                return this.zzo.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final int zza() {
        return this.zzk.get();
    }

    public final int zzb() {
        return this.zzj.get();
    }

    public final Context zzd() {
        return this.zze;
    }

    public final Resources zze() {
        if (this.zzf.isClientJar) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlp)).booleanValue()) {
                return ExceptionsKt.zzc(this.zze).zzj.getResources();
            }
            ExceptionsKt.zzc(this.zze).zzj.getResources();
            return null;
        } catch (com.google.android.gms.ads.internal.util.client.zzr e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final zzbdj zzg() {
        zzbdj zzbdjVar;
        synchronized (this.zza) {
            zzbdjVar = this.zzh;
        }
        return zzbdjVar;
    }

    public final zzbzw zzh() {
        return this.zzc;
    }

    public final com.google.android.gms.ads.internal.util.zzg zzi() {
        com.google.android.gms.ads.internal.util.zzj zzjVar;
        synchronized (this.zza) {
            zzjVar = this.zzb;
        }
        return zzjVar;
    }

    public final ListenableFuture zzk() {
        if (this.zze != null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdg)).booleanValue()) {
                synchronized (this.zzm) {
                    try {
                        ListenableFuture listenableFuture = this.zzn;
                        if (listenableFuture != null) {
                            return listenableFuture;
                        }
                        ListenableFuture listenableFutureZzb = zzcaf.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzbzn
                            @Override // java.util.concurrent.Callable
                            public final Object call() {
                                return zzbzs.zzo(this.zza);
                            }
                        });
                        this.zzn = listenableFutureZzb;
                        return listenableFutureZzb;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        return zzgdn.zzh(new ArrayList());
    }

    public final Boolean zzl() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzi;
        }
        return bool;
    }

    public final String zzn() {
        return this.zzg;
    }

    public final void zzq() {
        this.zzl.zza();
    }

    public final void zzr() {
        this.zzj.decrementAndGet();
    }

    public final void zzs() {
        this.zzk.incrementAndGet();
    }

    public final void zzt() {
        this.zzj.incrementAndGet();
    }

    public final void zzu(Context context, VersionInfoParcel versionInfoParcel) {
        zzbdj zzbdjVar;
        synchronized (this.zza) {
            try {
                if (!this.zzd) {
                    this.zze = context.getApplicationContext();
                    this.zzf = versionInfoParcel;
                    com.google.android.gms.ads.internal.zzv.zza.zzh.zzc(this.zzc);
                    this.zzb.zzp(this.zze);
                    zzbun.zzb(this.zze, this.zzf);
                    zzbcv zzbcvVar = zzbde.zzcj;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                    if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                        zzbdjVar = new zzbdj();
                    } else {
                        com.google.android.gms.ads.internal.util.zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                        zzbdjVar = null;
                    }
                    this.zzh = zzbdjVar;
                    if (zzbdjVar != null) {
                        zzcai.zza(new zzbzo(this).zzb(), "AppState.registerCsiReporter");
                    }
                    Context context2 = this.zze;
                    if (Hex.isAtLeastO()) {
                        if (((Boolean) zzbdVar.zzd.zzb(zzbde.zziN)).booleanValue()) {
                            try {
                                ((ConnectivityManager) context2.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzbzp(this));
                            } catch (RuntimeException e) {
                                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to register network callback", e);
                                this.zzo.set(true);
                            }
                        }
                    }
                    this.zzd = true;
                    zzk();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.zzv.zza.zzd.zzc(context, versionInfoParcel.afmaVersion);
    }

    public final void zzv(Throwable th, String str) {
        zzbun.zzb(this.zze, this.zzf).zzi(th, str, ((Double) zzbfn.zzf.zze()).floatValue());
    }

    public final void zzw(Throwable th, String str) {
        zzbun.zzb(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzx(Throwable th, String str) {
        zzbun.zzd(this.zze, this.zzf).zzh(th, str);
    }

    public final void zzy(Boolean bool) {
        synchronized (this.zza) {
            this.zzi = bool;
        }
    }

    public final void zzz(String str) {
        this.zzg = str;
    }
}
