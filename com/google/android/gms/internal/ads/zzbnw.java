package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
final class zzbnw implements Runnable {
    final /* synthetic */ zzboh zza;
    final /* synthetic */ zzbnd zzb;
    final /* synthetic */ ArrayList zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ zzboi zze;

    public zzbnw(zzboi zzboiVar, zzboh zzbohVar, zzbnd zzbndVar, ArrayList arrayList, long j) {
        this.zza = zzbohVar;
        this.zzb = zzbndVar;
        this.zzc = arrayList;
        this.zzd = j;
        Objects.requireNonNull(zzboiVar);
        this.zze = zzboiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Trying to acquire lock");
        zzboi zzboiVar = this.zze;
        synchronized (zzboiVar.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock acquired");
                zzboh zzbohVar = this.zza;
                if (zzbohVar.zze() != -1 && zzbohVar.zze() != 1) {
                    zzbcv zzbcvVar = zzbde.zzhZ;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                    if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                        zzbohVar.zzh(new TimeoutException("Unable to fully load JS engine."), "SdkJavascriptFactory.loadJavascriptEngine.Runnable");
                    } else {
                        zzbohVar.zzg();
                    }
                    zzgdy zzgdyVar = zzcaf.zzf;
                    final zzbnd zzbndVar = this.zzb;
                    Objects.requireNonNull(zzbndVar);
                    zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnv
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzbndVar.zzc();
                        }
                    });
                    String strValueOf = String.valueOf(zzbdVar.zzd.zzb(zzbde.zzd));
                    int iZze = zzbohVar.zze();
                    int i = zzboiVar.zzi;
                    ArrayList arrayList = this.zzc;
                    String strConcat = arrayList.isEmpty() ? ". Still waiting for the engine to be loaded" : ". While waiting for the /jsLoaded gmsg, observed the loadNewJavascriptEngine latency is ".concat(String.valueOf(arrayList.get(0)));
                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                    com.google.android.gms.ads.internal.util.zze.zza("Could not finish the full JS engine loading in " + strValueOf + " ms. JS engine session reference status(fullLoadTimeout) is " + iZze + ". Update status(fullLoadTimeout) is " + i + strConcat + " ms. Total latency(fullLoadTimeout) is " + (System.currentTimeMillis() - this.zzd) + " ms at timeout. Rejecting.");
                    com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released");
                    return;
                }
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > ADMOB_UI_HANDLER.postDelayed: Lock released, the promise is already settled");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
