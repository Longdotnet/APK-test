package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzdpi {
    private final zzcvw zza;
    private final zzdeb zzb;
    private final zzcxf zzc;
    private final zzcxs zzd;
    private final zzcye zze;
    private final zzdaz zzf;
    private final Executor zzg;
    private final zzddx zzh;
    private final zzcnn zzi;
    private final com.google.android.gms.ads.internal.zzb zzj;
    private final zzbya zzk;
    private final zzavu zzl;
    private final zzdaq zzm;
    private final zzeca zzn;
    private final zzfjy zzo;
    private final zzdsj zzp;
    private final zzcmq zzq;
    private final zzdpo zzr;

    public zzdpi(zzcvw zzcvwVar, zzcxf zzcxfVar, zzcxs zzcxsVar, zzcye zzcyeVar, zzdaz zzdazVar, Executor executor, zzddx zzddxVar, zzcnn zzcnnVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, zzavu zzavuVar, zzdaq zzdaqVar, zzeca zzecaVar, zzfjy zzfjyVar, zzdsj zzdsjVar, zzdeb zzdebVar, zzcmq zzcmqVar, zzdpo zzdpoVar) {
        this.zza = zzcvwVar;
        this.zzc = zzcxfVar;
        this.zzd = zzcxsVar;
        this.zze = zzcyeVar;
        this.zzf = zzdazVar;
        this.zzg = executor;
        this.zzh = zzddxVar;
        this.zzi = zzcnnVar;
        this.zzj = zzbVar;
        this.zzk = zzbyaVar;
        this.zzl = zzavuVar;
        this.zzm = zzdaqVar;
        this.zzn = zzecaVar;
        this.zzo = zzfjyVar;
        this.zzp = zzdsjVar;
        this.zzb = zzdebVar;
        this.zzq = zzcmqVar;
        this.zzr = zzdpoVar;
    }

    public static void zze(zzdpi zzdpiVar, View view) {
        zzdpiVar.zzj.zzb = true;
    }

    public static boolean zzh(zzdpi zzdpiVar, View view, MotionEvent motionEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkx)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            zzdpiVar.zzr.zzb(motionEvent);
        }
        zzdpiVar.zzj.zzb = true;
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    public static final ListenableFuture zzj(zzcfg zzcfgVar, String str, String str2, final Bundle bundle, zzfhu zzfhuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzct)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.RENDERING_WEBVIEW_LOAD_HTML_START.zza());
        }
        final zzcak zzcakVar = new zzcak();
        if (((Boolean) zzbex.zzf.zze()).booleanValue()) {
            zzfhj zzfhjVarZza = zzfhi.zza(zzcfgVar.getContext(), 112);
            zzfhjVarZza.zzi();
            zzfht.zza(zzcakVar, zzfhuVar, zzfhjVarZza);
        }
        zzcfgVar.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdpg
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str3, String str4) {
                zzcak zzcakVar2 = zzcakVar;
                if (z) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzct)).booleanValue()) {
                        CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.RENDERING_WEBVIEW_LOAD_HTML_END.zza());
                    }
                    zzcakVar2.zzc(null);
                    return;
                }
                zzcakVar2.zzd(new Exception("Ad Web View failed to load. Error code: " + i + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcfgVar.zzae(str, str2, null);
        return zzcakVar;
    }

    public final void zzi(final zzcfg zzcfgVar, boolean z, zzbki zzbkiVar, Bundle bundle) {
        zzavp zzavpVarZzc;
        zzbcv zzbcvVar = zzbde.zzct;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.RENDERING_CONFIGURE_WEBVIEW_START.zza());
        }
        zzcfgVar.zzN().zzX(new com.google.android.gms.ads.internal.client.zza() { // from class: com.google.android.gms.internal.ads.zzdoz
            @Override // com.google.android.gms.ads.internal.client.zza
            public final void onAdClicked() {
                this.zza.zza.onAdClicked();
            }
        }, this.zzd, this.zze, new zzbix() { // from class: com.google.android.gms.internal.ads.zzdpa
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zzb(String str, String str2) {
                this.zza.zzf.zzb(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzad() { // from class: com.google.android.gms.internal.ads.zzdpb
            @Override // com.google.android.gms.ads.internal.overlay.zzad
            public final void zzg() {
                this.zza.zzc.zzb();
            }
        }, z, zzbkiVar, this.zzj, new zzdph(this), this.zzk, this.zzn, this.zzo, this.zzp, null, this.zzb, null, null, null, this.zzq);
        zzcfgVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.internal.ads.zzdpc
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                zzdpi.zzh(this.zza, view, motionEvent);
                return false;
            }
        });
        zzcfgVar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzdpd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                zzdpi.zze(this.zza, view);
            }
        });
        zzbcv zzbcvVar2 = zzbde.zzcT;
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar2)).booleanValue() && (zzavpVarZzc = this.zzl.zzc()) != null) {
            zzavpVarZzc.zzo(zzcfgVar.zzF());
        }
        zzddx zzddxVar = this.zzh;
        Executor executor = this.zzg;
        zzddxVar.zzo(zzcfgVar, executor);
        zzddxVar.zzo(new zzazd() { // from class: com.google.android.gms.internal.ads.zzdpe
            @Override // com.google.android.gms.internal.ads.zzazd
            public final void zzdr(zzazc zzazcVar) {
                zzcgy zzcgyVarZzN = zzcfgVar.zzN();
                Rect rect = zzazcVar.zzd;
                zzcgyVarZzN.zzr(rect.left, rect.top, false);
            }
        }, executor);
        zzddxVar.zza(zzcfgVar.zzF());
        zzcfgVar.zzag("/trackActiveViewUnit", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzdpf
            @Override // com.google.android.gms.internal.ads.zzbkf
            public final void zza(Object obj, Map map) {
                this.zza.zzi.zzh(zzcfgVar);
            }
        });
        this.zzi.zzi(zzcfgVar);
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.RENDERING_CONFIGURE_WEBVIEW_END.zza());
        }
    }
}
