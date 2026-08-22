package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeen implements zzedm {
    private final zzcpx zza;
    private final Context zzb;
    private final zzdpj zzc;
    private final zzfcw zzd;
    private final Executor zze;
    private final zzfve zzf;
    private final zzdsd zzg;

    public zzeen(zzcpx zzcpxVar, Context context, Executor executor, zzdpj zzdpjVar, zzfcw zzfcwVar, zzfve zzfveVar, zzdsd zzdsdVar) {
        this.zzb = context;
        this.zza = zzcpxVar;
        this.zze = executor;
        this.zzc = zzdpjVar;
        this.zzd = zzfcwVar;
        this.zzf = zzfveVar;
        this.zzg = zzdsdVar;
    }

    public static ListenableFuture zzc(final zzeen zzeenVar, zzfcn zzfcnVar, zzfca zzfcaVar, Object obj) {
        zzbcv zzbcvVar = zzbde.zzct;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzeenVar.zzg.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_START.zza());
        }
        Context context = zzeenVar.zzb;
        com.google.android.gms.ads.internal.client.zzr zzrVarZza = zzfdc.zza(context, zzfcaVar.zzu);
        final zzcfg zzcfgVarZza = zzeenVar.zzc.zza(zzrVarZza, zzfcaVar, zzfcnVar.zzb.zzb);
        zzcfgVarZza.zzac(zzfcaVar.zzW);
        zzbcv zzbcvVar2 = zzbde.zzij;
        zzbdc zzbdcVar = zzbdVar.zzd;
        View viewZza = (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue() && zzfcaVar.zzag) ? zzcqm.zza(context, zzcfgVarZza.zzF(), zzfcaVar) : new zzdpm(context, zzcfgVarZza.zzF(), (com.google.android.gms.ads.internal.util.zzau) zzeenVar.zzf.apply(zzfcaVar));
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzeenVar.zzg.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_END.zza());
        }
        zzcpx zzcpxVar = zzeenVar.zza;
        final zzcot zzcotVarZza = zzcpxVar.zza(new zzcrq(zzfcnVar, zzfcaVar, null), new zzcoz(viewZza, zzcfgVarZza, new zzcqy() { // from class: com.google.android.gms.internal.ads.zzeeh
            @Override // com.google.android.gms.internal.ads.zzcqy
            public final com.google.android.gms.ads.internal.client.zzed zza() {
                return zzcfgVarZza.zzq();
            }
        }, zzfdc.zzb(zzrVarZza)));
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzeenVar.zzg.zza(), zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza());
        }
        zzdpi zzdpiVarZzi = zzcotVarZza.zzi();
        zzdsd zzdsdVar = zzeenVar.zzg;
        zzdpiVarZzi.zzi(zzcfgVarZza, false, null, zzdsdVar.zza());
        zzcwq zzcwqVarZzc = zzcotVarZza.zzc();
        zzcws zzcwsVar = new zzcws() { // from class: com.google.android.gms.internal.ads.zzeei
            @Override // com.google.android.gms.internal.ads.zzcws
            public final void zzt() {
                zzcfg zzcfgVar = zzcfgVarZza;
                if (zzcfgVar.zzN() != null) {
                    zzcfgVar.zzN().zzs();
                }
            }
        };
        zzgdy zzgdyVar = zzcaf.zzg;
        zzcwqVarZzc.zzo(zzcwsVar, zzgdyVar);
        zzfcf zzfcfVar = zzfcaVar.zzs;
        String strZzb = zzfcfVar.zza;
        if (((Boolean) zzbdcVar.zzb(zzbde.zzfC)).booleanValue() && zzcotVarZza.zzl().zze(true)) {
            strZzb = zzcgr.zzb(strZzb, zzcgr.zza(zzfcaVar));
        }
        zzcotVarZza.zzi();
        ListenableFuture listenableFutureZzj = zzdpi.zzj(zzcfgVarZza, zzfcfVar.zzb, strZzb, zzdsdVar.zza(), zzcpxVar.zzh());
        if (zzfcaVar.zzM) {
            listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeej
                @Override // java.lang.Runnable
                public final void run() {
                    zzcfgVarZza.zzah();
                }
            }, zzeenVar.zze);
        }
        listenableFutureZzj.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeek
            @Override // java.lang.Runnable
            public final void run() {
                zzeen.zzd(this.zza, zzcfgVarZza);
            }
        }, zzeenVar.zze);
        return zzgdn.zzm(listenableFutureZzj, new zzfve() { // from class: com.google.android.gms.internal.ads.zzeel
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj2) {
                return zzcotVarZza.zza();
            }
        }, zzgdyVar);
    }

    public static void zzd(zzeen zzeenVar, zzcfg zzcfgVar) {
        zzcfgVar.zzab();
        zzfcw zzfcwVar = zzeenVar.zzd;
        zzcgi zzcgiVarZzq = zzcfgVar.zzq();
        com.google.android.gms.ads.internal.client.zzgc zzgcVar = zzfcwVar.zza;
        if (zzgcVar != null && zzcgiVarZzq != null) {
            zzcgiVarZzq.zzs(zzgcVar);
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbv)).booleanValue() || zzcfgVar.isAttachedToWindow()) {
            return;
        }
        zzcfgVar.onPause();
        zzcfgVar.zzav(true);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        return zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeem
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzeen.zzc(this.zza, zzfcnVar, zzfcaVar, obj);
            }
        }, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzfcf zzfcfVar = zzfcaVar.zzs;
        return (zzfcfVar == null || zzfcfVar.zza == null) ? false : true;
    }
}
