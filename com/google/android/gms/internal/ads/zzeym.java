package com.google.android.gms.internal.ads;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.hSi.sgtsHsWT;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzeym implements zzelo {
    private final Context zza;
    private final Executor zzb;
    private final zzche zzc;
    private final zzeky zzd;
    private final zzelc zze;
    private final ViewGroup zzf;
    private zzbdz zzg;
    private final zzcyv zzh;
    private final zzfhx zzi;
    private final zzdbb zzj;
    private final zzfcu zzk;
    private ListenableFuture zzl;
    private boolean zzm;
    private com.google.android.gms.ads.internal.client.zze zzn;
    private zzeln zzo;

    public zzeym(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzr zzrVar, zzche zzcheVar, zzeky zzekyVar, zzelc zzelcVar, zzfcu zzfcuVar, zzdbb zzdbbVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcheVar;
        this.zzd = zzekyVar;
        this.zze = zzelcVar;
        this.zzk = zzfcuVar;
        this.zzh = zzcheVar.zze();
        this.zzi = zzcheVar.zzy();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdbbVar;
        zzfcuVar.zzt(zzrVar);
        this.zzm = true;
        this.zzn = null;
        this.zzo = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzt() {
        this.zzl = null;
        final com.google.android.gms.ads.internal.client.zze zzeVar = this.zzn;
        this.zzn = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziA)).booleanValue() && zzeVar != null) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyi
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zzdD(zzeVar);
                }
            });
        }
        zzeln zzelnVar = this.zzo;
        if (zzelnVar != null) {
            zzelnVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzl;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) {
        zzcpx zzcpxVarZzk;
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyk
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd.zzdD(zzfdx.zzd(6, null, null));
                }
            });
            return false;
        }
        if (!zza()) {
            zzbcv zzbcvVar = zzbde.zzjp;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && zzmVar.zzf) {
                this.zzc.zzk().zzo(true);
            }
            Pair pair = new Pair(zzdrr.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz));
            String strZza = zzdrr.DYNAMITE_ENTER.zza();
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            Bundle bundleZza = zzdrt.zza(pair, new Pair(strZza, Long.valueOf(System.currentTimeMillis())));
            zzfcu zzfcuVar = this.zzk;
            zzfcuVar.zzu(str);
            zzfcuVar.zzJ(zzmVar);
            zzfcuVar.zzB(bundleZza);
            Context context = this.zza;
            zzfcw zzfcwVarZzL = zzfcuVar.zzL();
            zzfhj zzfhjVarZzb = zzfhi.zzb(context, zzfht.zzf(zzfcwVarZzL), 3, zzmVar);
            zzfhu zzfhuVarZzh = null;
            if (!((Boolean) zzbfk.zzd.zze()).booleanValue() || !zzfcuVar.zzi().zzk) {
                if (((Boolean) zzbdVar.zzd.zzb(zzbde.zziA)).booleanValue()) {
                    zzcpw zzcpwVarZzd = this.zzc.zzd();
                    zzcvf zzcvfVar = new zzcvf();
                    zzcvfVar.zzf(context);
                    zzcvfVar.zzk(zzfcwVarZzL);
                    zzcpwVarZzd.zzi(zzcvfVar.zzl());
                    zzdbu zzdbuVar = new zzdbu();
                    zzeky zzekyVar = this.zzd;
                    Executor executor = this.zzb;
                    zzdbuVar.zzj(zzekyVar, executor);
                    zzdbuVar.zzk(zzekyVar, executor);
                    zzcpwVarZzd.zzf(zzdbuVar.zzn());
                    zzcpwVarZzd.zze(new zzejh(this.zzg));
                    zzcpwVarZzd.zzd(new zzdgw(zzdje.zza, null));
                    zzcpwVarZzd.zzg(new zzcqs(this.zzh, this.zzj));
                    zzcpwVarZzd.zzc(new zzcop(this.zzf));
                    zzcpxVarZzk = zzcpwVarZzd.zzh();
                } else {
                    zzcpw zzcpwVarZzd2 = this.zzc.zzd();
                    zzcvf zzcvfVar2 = new zzcvf();
                    zzcvfVar2.zzf(context);
                    zzcvfVar2.zzk(zzfcwVarZzL);
                    zzcpwVarZzd2.zzi(zzcvfVar2.zzl());
                    zzdbu zzdbuVar2 = new zzdbu();
                    zzeky zzekyVar2 = this.zzd;
                    Executor executor2 = this.zzb;
                    zzdbuVar2.zzj(zzekyVar2, executor2);
                    zzdbuVar2.zza(zzekyVar2, executor2);
                    zzdbuVar2.zza(this.zze, executor2);
                    zzdbuVar2.zzl(zzekyVar2, executor2);
                    zzdbuVar2.zzd(zzekyVar2, executor2);
                    zzdbuVar2.zze(zzekyVar2, executor2);
                    zzdbuVar2.zzf(zzekyVar2, executor2);
                    zzdbuVar2.zzb(zzekyVar2, executor2);
                    zzdbuVar2.zzk(zzekyVar2, executor2);
                    zzdbuVar2.zzi(zzekyVar2, executor2);
                    zzcpwVarZzd2.zzf(zzdbuVar2.zzn());
                    zzcpwVarZzd2.zze(new zzejh(this.zzg));
                    zzcpwVarZzd2.zzd(new zzdgw(zzdje.zza, null));
                    zzcpwVarZzd2.zzg(new zzcqs(this.zzh, this.zzj));
                    zzcpwVarZzd2.zzc(new zzcop(this.zzf));
                    zzcpxVarZzk = zzcpwVarZzd2.zzh();
                }
                if (((Boolean) zzbex.zzc.zze()).booleanValue()) {
                    zzfhuVarZzh = zzcpxVarZzk.zzh();
                    zzfhuVarZzh.zzi(3);
                    zzfhuVarZzh.zzb(zzmVar.zzp);
                    zzfhuVarZzh.zzf(zzmVar.zzm);
                }
                this.zzo = zzelnVar;
                zzcse zzcseVarZzc = zzcpxVarZzk.zzc();
                ListenableFuture listenableFutureZzh = zzcseVarZzc.zzh(zzcseVarZzc.zzi());
                this.zzl = listenableFutureZzh;
                zzgdn.zzr(listenableFutureZzh, new zzeyl(this, zzfhuVarZzh, zzfhjVarZzb, zzcpxVarZzk), this.zzb);
                return true;
            }
            zzeky zzekyVar3 = this.zzd;
            if (zzekyVar3 != null) {
                zzekyVar3.zzdD(zzfdx.zzd(7, null, null));
            }
        } else if (!this.zzk.zzV()) {
            this.zzm = true;
        }
        return false;
    }

    public final ViewGroup zzc() {
        return this.zzf;
    }

    public final zzfcu zzf() {
        return this.zzk;
    }

    public final void zzl() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzm() {
        this.zzh.zze(this.zzj.zzd());
    }

    public final void zzn(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        this.zze.zza(zzbhVar);
    }

    public final void zzo(zzcyp zzcypVar) {
        this.zzh.zzo(zzcypVar, this.zzb);
    }

    public final void zzp(zzbdz zzbdzVar) {
        this.zzg = zzbdzVar;
    }

    public final boolean zzs() {
        Object parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        Context context = view.getContext();
        Context applicationContext = context.getApplicationContext();
        KeyguardManager keyguardManager = null;
        PowerManager powerManager = applicationContext != null ? (PowerManager) applicationContext.getSystemService("power") : null;
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null && (systemService instanceof KeyguardManager)) {
            keyguardManager = (KeyguardManager) systemService;
        }
        return com.google.android.gms.ads.internal.util.zzs.zzT(view, powerManager, keyguardManager);
    }

    public final void zzq() {
        synchronized (this) {
            try {
                ListenableFuture listenableFuture = this.zzl;
                if (listenableFuture != null && listenableFuture.isDone()) {
                    try {
                        zzcos zzcosVar = (zzcos) this.zzl.get();
                        this.zzl = null;
                        ViewGroup viewGroup = this.zzf;
                        viewGroup.removeAllViews();
                        zzcosVar.zzd();
                        ViewParent parent = zzcosVar.zzd().getParent();
                        if (parent instanceof ViewGroup) {
                            String str = "Banner view provided from " + (zzcosVar.zzm() != null ? zzcosVar.zzm().zzg() : "") + " already has a parent view. Removing its old parent.";
                            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj(str);
                            ((ViewGroup) parent).removeView(zzcosVar.zzd());
                        }
                        zzbcv zzbcvVar = zzbde.zziA;
                        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                            zzdaj zzdajVarZzo = zzcosVar.zzo();
                            zzdajVarZzo.zza(this.zzd);
                            zzdajVarZzo.zzc(this.zze);
                        }
                        viewGroup.addView(zzcosVar.zzd());
                        zzeln zzelnVar = this.zzo;
                        if (zzelnVar != null) {
                            zzelnVar.zzb(zzcosVar);
                        }
                        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                            Executor executor = this.zzb;
                            final zzeky zzekyVar = this.zzd;
                            Objects.requireNonNull(zzekyVar);
                            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyj
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzekyVar.zzu();
                                }
                            });
                        }
                        if (zzcosVar.zza() >= 0) {
                            this.zzm = false;
                            zzcyv zzcyvVar = this.zzh;
                            zzcyvVar.zzd(zzcosVar.zza());
                            zzcyvVar.zze(zzcosVar.zzc());
                        } else {
                            this.zzm = true;
                            this.zzh.zzd(zzcosVar.zzc());
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        zzt();
                        com.google.android.gms.ads.internal.util.zze.zzb("Error occurred while refreshing the ad. Making a new ad request.", e);
                        this.zzm = true;
                        this.zzh.zza();
                    } catch (ExecutionException e2) {
                        e = e2;
                        zzt();
                        com.google.android.gms.ads.internal.util.zze.zzb("Error occurred while refreshing the ad. Making a new ad request.", e);
                        this.zzm = true;
                        this.zzh.zza();
                    }
                } else if (this.zzl != null) {
                    com.google.android.gms.ads.internal.util.zze.zza("Show timer went off but there is an ongoing ad request.");
                    this.zzm = true;
                } else {
                    com.google.android.gms.ads.internal.util.zze.zza(sgtsHsWT.vhwAEF);
                    this.zzm = true;
                    this.zzh.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
