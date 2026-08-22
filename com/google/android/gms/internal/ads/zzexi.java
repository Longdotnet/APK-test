package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzexi implements zzelo {
    protected final zzche zza;
    private final Context zzb;
    private final Executor zzc;
    private final zzexy zzd;
    private final zzezr zze;
    private final VersionInfoParcel zzf;
    private final ViewGroup zzg;
    private final zzfhx zzh;
    private final zzfcu zzi;
    private ListenableFuture zzj;

    public zzexi(Context context, Executor executor, zzche zzcheVar, zzezr zzezrVar, zzexy zzexyVar, zzfcu zzfcuVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcheVar;
        this.zze = zzezrVar;
        this.zzd = zzexyVar;
        this.zzi = zzfcuVar;
        this.zzf = versionInfoParcel;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcheVar.zzy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized zzcvd zzm(zzezp zzezpVar) {
        zzexg zzexgVar = (zzexg) zzezpVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zziB)).booleanValue()) {
            zzcop zzcopVar = new zzcop(this.zzg);
            zzcvf zzcvfVar = new zzcvf();
            zzcvfVar.zzf(this.zzb);
            zzcvfVar.zzk(zzexgVar.zza);
            zzcvh zzcvhVarZzl = zzcvfVar.zzl();
            zzdbu zzdbuVar = new zzdbu();
            zzexy zzexyVar = this.zzd;
            Executor executor = this.zzc;
            zzdbuVar.zzc(zzexyVar, executor);
            zzdbuVar.zzl(zzexyVar, executor);
            return zze(zzcopVar, zzcvhVarZzl, zzdbuVar.zzn());
        }
        zzexy zzexyVarZzi = zzexy.zzi(this.zzd);
        zzdbu zzdbuVar2 = new zzdbu();
        Executor executor2 = this.zzc;
        zzdbuVar2.zzb(zzexyVarZzi, executor2);
        zzdbuVar2.zzg(zzexyVarZzi, executor2);
        zzdbuVar2.zzh(zzexyVarZzi, executor2);
        zzdbuVar2.zzi(zzexyVarZzi, executor2);
        zzdbuVar2.zzc(zzexyVarZzi, executor2);
        zzdbuVar2.zzl(zzexyVarZzi, executor2);
        zzdbuVar2.zzm(zzexyVarZzi);
        zzcop zzcopVar2 = new zzcop(this.zzg);
        zzcvf zzcvfVar2 = new zzcvf();
        zzcvfVar2.zzf(this.zzb);
        zzcvfVar2.zzk(zzexgVar.zza);
        return zze(zzcopVar2, zzcvfVar2.zzl(), zzdbuVar2.zzn());
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzj;
        return (listenableFuture == null || listenableFuture.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzelo
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzelm zzelmVar, zzeln zzelnVar) {
        zzfhu zzfhuVar;
        zzcoc zzcocVar;
        try {
            if (!zzmVar.zzb()) {
                boolean z = ((Boolean) zzbfc.zzd.zze()).booleanValue() && ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlE)).booleanValue();
                if (this.zzf.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzlF)).intValue() || !z) {
                    com.google.android.gms.common.internal.zzah.checkMainThread$1("loadAd must be called on the main UI thread.");
                }
            }
            if (str == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Ad unit ID should not be null for app open ad.");
                this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zza.zzd.zzdD(zzfdx.zzd(6, null, null));
                    }
                });
                return false;
            }
            if (this.zzj != null) {
                return false;
            }
            if (!((Boolean) zzbex.zzc.zze()).booleanValue() || (zzcocVar = (zzcoc) this.zze.zzd()) == null) {
                zzfhuVar = null;
            } else {
                zzfhu zzfhuVarZzg = zzcocVar.zzg();
                zzfhuVarZzg.zzi(7);
                zzfhuVarZzg.zzb(zzmVar.zzp);
                zzfhuVarZzg.zzf(zzmVar.zzm);
                zzfhuVar = zzfhuVarZzg;
            }
            Context context = this.zzb;
            boolean z2 = zzmVar.zzf;
            zzfdt.zza(context, z2);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjp)).booleanValue() && z2) {
                this.zza.zzk().zzo(true);
            }
            Pair pair = new Pair(zzdrr.PUBLIC_API_CALL.zza(), Long.valueOf(zzmVar.zzz));
            String strZza = zzdrr.DYNAMITE_ENTER.zza();
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            Bundle bundleZza = zzdrt.zza(pair, new Pair(strZza, Long.valueOf(System.currentTimeMillis())));
            zzfcu zzfcuVar = this.zzi;
            zzfcuVar.zzu(str);
            zzfcuVar.zzt(com.google.android.gms.ads.internal.client.zzr.zzb());
            zzfcuVar.zzJ(zzmVar);
            zzfcuVar.zzB(bundleZza);
            zzfcw zzfcwVarZzL = zzfcuVar.zzL();
            zzfhj zzfhjVarZzb = zzfhi.zzb(context, zzfht.zzf(zzfcwVarZzL), 7, zzmVar);
            zzexg zzexgVar = new zzexg(null);
            zzexgVar.zza = zzfcwVarZzL;
            ListenableFuture listenableFutureZzc = this.zze.zzc(new zzezs(zzexgVar, null), new zzezq() { // from class: com.google.android.gms.internal.ads.zzexd
                @Override // com.google.android.gms.internal.ads.zzezq
                public final zzcvd zza(zzezp zzezpVar) {
                    return this.zza.zzm(zzezpVar);
                }
            }, null);
            this.zzj = listenableFutureZzc;
            zzgdn.zzr(listenableFutureZzc, new zzexf(this, zzelnVar, zzfhuVar, zzfhjVarZzb, zzexgVar), this.zzc);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public abstract zzcvd zze(zzcop zzcopVar, zzcvh zzcvhVar, zzdbw zzdbwVar);

    public final void zzl(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi.zzv(zzxVar);
    }
}
