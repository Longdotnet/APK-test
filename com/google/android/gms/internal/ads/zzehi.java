package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzehi implements zzgcu {
    private final zzfha zza;
    private final zzcwa zzb;
    private final zzfju zzc;
    private final zzfjy zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcrd zzg;
    private final zzehb zzh;
    private final zzedr zzi;
    private final Context zzj;
    private final zzfhu zzk;
    private final zzegl zzl;
    private final zzdsd zzm;

    public zzehi(Context context, zzfha zzfhaVar, zzehb zzehbVar, zzcwa zzcwaVar, zzfju zzfjuVar, zzfjy zzfjyVar, zzcrd zzcrdVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzedr zzedrVar, zzfhu zzfhuVar, zzegl zzeglVar, zzdsd zzdsdVar) {
        this.zzj = context;
        this.zza = zzfhaVar;
        this.zzh = zzehbVar;
        this.zzb = zzcwaVar;
        this.zzc = zzfjuVar;
        this.zzd = zzfjyVar;
        this.zzg = zzcrdVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzedrVar;
        this.zzk = zzfhuVar;
        this.zzl = zzeglVar;
        this.zzm = zzdsdVar;
    }

    public static /* synthetic */ ListenableFuture zzb(zzehi zzehiVar, zzfca zzfcaVar, zzfcn zzfcnVar, zzedm zzedmVar, Throwable th) {
        zzfhj zzfhjVarZza = zzfhi.zza(zzehiVar.zzj, 12);
        zzfhjVarZza.zzd(zzfcaVar.zzE);
        zzfhjVarZza.zzi();
        ListenableFuture listenableFutureZzo = zzgdn.zzo(zzedmVar.zza(zzfcnVar, zzfcaVar), zzfcaVar.zzR, TimeUnit.MILLISECONDS, zzehiVar.zzf);
        zzehiVar.zzh.zzf(zzfcnVar, zzfcaVar, listenableFutureZzo, zzehiVar.zzc);
        zzfht.zza(listenableFutureZzo, zzehiVar.zzk, zzfhjVarZza);
        return listenableFutureZzo;
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final ListenableFuture zza(Object obj) {
        int i;
        Bundle bundle;
        final zzfcn zzfcnVar = (zzfcn) obj;
        zzbcv zzbcvVar = zzbde.zzcq;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() && (bundle = zzfcnVar.zzb.zzd) != null) {
            this.zzm.zza().putAll(bundle);
        }
        zzbcv zzbcvVar2 = zzbde.zzcr;
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzm.zza(), zzdrr.zzu.zza());
        }
        String strZzc = zzc(zzfcnVar);
        zzedr zzedrVar = this.zzi;
        zzfcm zzfcmVar = zzfcnVar.zzb;
        zzfcd zzfcdVar = zzfcmVar.zzb;
        zzedrVar.zzi(zzfcdVar);
        if (((Boolean) zzbdcVar.zzb(zzbde.zziI)).booleanValue() && (i = zzfcdVar.zzf) != 0 && (i < 200 || i >= 300)) {
            return zzgdn.zzg(new zzehf(3, strZzc));
        }
        String str = zzfcdVar.zzq;
        if (!((Boolean) zzbdcVar.zzb(zzbde.zzdR)).booleanValue() || TextUtils.isEmpty(str)) {
            for (zzfca zzfcaVar : zzfcmVar.zza) {
                zzedrVar.zzd(zzfcaVar);
                Iterator it = zzfcaVar.zza.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzedrVar.zzf(zzfcaVar, 0L, zzfdx.zzd(1, null, null));
                        break;
                    }
                    zzedm zzedmVarZza = this.zzg.zza(zzfcaVar.zzb, (String) it.next());
                    if (zzedmVarZza != null && zzedmVarZza.zzb(zzfcnVar, zzfcaVar)) {
                        break;
                    }
                }
            }
        } else {
            zzedrVar.zzh(str, zzfcmVar.zza);
        }
        zzcwa zzcwaVar = this.zzb;
        zzcmu zzcmuVar = new zzcmu(zzfcnVar, this.zzd, this.zzc);
        Executor executor = this.zze;
        zzcwaVar.zzo(zzcmuVar, executor);
        if (zzfcdVar.zzr > 1) {
            return this.zzl.zzb(zzfcnVar);
        }
        String strZzc2 = zzc(zzfcnVar);
        zzfha zzfhaVar = this.zza;
        zzfgu zzfguVar = zzfgu.RENDER_CONFIG_INIT;
        Objects.requireNonNull(zzfhaVar);
        zzfgg zzfggVarZza = zzfgk.zzc(zzgdn.zzg(new zzehf(3, strZzc2)), zzfguVar, zzfhaVar).zza();
        final zzehb zzehbVar = this.zzh;
        zzehbVar.zzl();
        int i2 = 0;
        for (final zzfca zzfcaVar2 : zzfcmVar.zza) {
            for (String str2 : zzfcaVar2.zza) {
                final zzedm zzedmVarZza2 = this.zzg.zza(zzfcaVar2.zzb, str2);
                if (zzedmVarZza2 != null && zzedmVarZza2.zzb(zzfcnVar, zzfcaVar2)) {
                    zzfggVarZza = zzfhaVar.zzb(zzfgu.RENDER_CONFIG_WATERFALL, zzfggVarZza).zzh("render-config-" + i2 + "-" + str2).zzc(Throwable.class, new zzgcu() { // from class: com.google.android.gms.internal.ads.zzehg
                        @Override // com.google.android.gms.internal.ads.zzgcu
                        public final ListenableFuture zza(Object obj2) {
                            return zzehi.zzb(this.zza, zzfcaVar2, zzfcnVar, zzedmVarZza2, (Throwable) obj2);
                        }
                    }).zza();
                    break;
                }
            }
            i2++;
        }
        zzfggVarZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzehh
            @Override // java.lang.Runnable
            public final void run() {
                zzehbVar.zzj();
            }
        }, executor);
        return zzfggVarZza;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x004b  */
    public static String zzc(zzfcn zzfcnVar) {
        zzbcv zzbcvVar = zzbde.zzfQ;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        String strM = "No fill.";
        String str = true != ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? YcVWhnLsj.vafilcE : "No fill.";
        zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
        int i = zzfcdVar.zzf;
        if (i == 0) {
            strM = str;
        } else if (i < 200 || i >= 300) {
            strM = (i < 300 || i >= 400) ? CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Received error HTTP response code: ") : "No location header to follow redirect or too many redirects.";
        } else {
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzfP)).booleanValue()) {
                strM = str;
            }
        }
        zzfcc zzfccVar = zzfcdVar.zzj;
        return zzfccVar != null ? zzfccVar.zza() : strM;
    }
}
