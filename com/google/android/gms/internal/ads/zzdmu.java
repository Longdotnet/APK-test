package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdmu {
    private final zzfcw zza;
    private final Executor zzb;
    private final zzdpj zzc;
    private final zzdoe zzd;
    private final Context zze;
    private final zzdsj zzf;
    private final zzfjy zzg;
    private final zzeca zzh;
    private final zzdsd zzi;

    public zzdmu(zzfcw zzfcwVar, Executor executor, zzdpj zzdpjVar, Context context, zzdsj zzdsjVar, zzfjy zzfjyVar, zzeca zzecaVar, zzdoe zzdoeVar, zzdsd zzdsdVar) {
        this.zza = zzfcwVar;
        this.zzb = executor;
        this.zzc = zzdpjVar;
        this.zze = context;
        this.zzf = zzdsjVar;
        this.zzg = zzfjyVar;
        this.zzh = zzecaVar;
        this.zzd = zzdoeVar;
        this.zzi = zzdsdVar;
    }

    public static ListenableFuture zza(zzdmu zzdmuVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, Object obj) {
        zzcfg zzcfgVarZza = zzdmuVar.zzc.zza(com.google.android.gms.ads.internal.client.zzr.zzc(), null, null);
        final zzcaj zzcajVarZza = zzcaj.zza((Object) zzcfgVarZza);
        zzdmuVar.zzh(zzcfgVarZza, zzbVar, zzbyaVar);
        zzcfgVarZza.zzN().zzK(new zzcgx() { // from class: com.google.android.gms.internal.ads.zzdmm
            @Override // com.google.android.gms.internal.ads.zzcgx
            public final void zza() {
                zzcajVarZza.zzb();
            }
        });
        zzcfgVarZza.loadUrl((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzeb));
        return zzcajVarZza;
    }

    public static /* synthetic */ ListenableFuture zzb(final zzdmu zzdmuVar, JSONObject jSONObject, final zzcfg zzcfgVar) {
        zzbmp zzbmpVar = zzdmuVar.zza.zzb;
        final zzcaj zzcajVarZza = zzcaj.zza((Object) zzcfgVar);
        if (zzbmpVar != null) {
            zzcfgVar.zzaj(zzchd.zzd());
        } else {
            zzcfgVar.zzaj(zzchd.zze());
        }
        zzcfgVar.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdml
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str, String str2) {
                zzdmu.zzg(this.zza, zzcfgVar, zzcajVarZza, z, i, str, str2);
            }
        });
        zzcfgVar.zzp("google.afma.nativeAds.renderVideo", jSONObject);
        return zzcajVarZza;
    }

    public static ListenableFuture zzc(final zzdmu zzdmuVar, com.google.android.gms.ads.internal.client.zzr zzrVar, zzfca zzfcaVar, zzfcd zzfcdVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, String str, String str2, Object obj) {
        final zzcfg zzcfgVarZza = zzdmuVar.zzc.zza(zzrVar, zzfcaVar, zzfcdVar);
        final zzcaj zzcajVarZza = zzcaj.zza((Object) zzcfgVarZza);
        if (zzdmuVar.zza.zzb != null) {
            zzdmuVar.zzh(zzcfgVarZza, zzbVar, zzbyaVar);
            zzcfgVarZza.zzaj(zzchd.zzd());
        } else {
            zzdob zzdobVarZzb = zzdmuVar.zzd.zzb();
            zzcgy zzcgyVarZzN = zzcfgVarZza.zzN();
            zzbcv zzbcvVar = zzbde.zznP;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            zzcgyVarZzN.zzX(zzdobVarZzb, zzdobVarZzb, zzdobVarZzb, zzdobVarZzb, zzdobVarZzb, false, null, !((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? new com.google.android.gms.ads.internal.zzb(zzdmuVar.zze, null) : zzbVar, null, true != ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? null : zzbyaVar, zzdmuVar.zzh, zzdmuVar.zzg, zzdmuVar.zzf, null, zzdobVarZzb, null, null, null, null);
            zzj(zzcfgVarZza);
        }
        zzcfgVarZza.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzdmj
            @Override // com.google.android.gms.internal.ads.zzcgw
            public final void zza(boolean z, int i, String str3, String str4) {
                zzdmu.zzf(this.zza, zzcfgVarZza, zzcajVarZza, z, i, str3, str4);
            }
        });
        zzcfgVarZza.zzae(str, str2, null);
        return zzcajVarZza;
    }

    public static /* synthetic */ void zzf(zzdmu zzdmuVar, zzcfg zzcfgVar, zzcaj zzcajVar, boolean z, int i, String str, String str2) {
        if (z) {
            com.google.android.gms.ads.internal.client.zzgc zzgcVar = zzdmuVar.zza.zza;
            if (zzgcVar != null && zzcfgVar.zzq() != null) {
                zzcfgVar.zzq().zzs(zzgcVar);
            }
            zzcajVar.zzb();
            return;
        }
        zzcajVar.zzd(new zzehf(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }

    public static void zzg(zzdmu zzdmuVar, zzcfg zzcfgVar, zzcaj zzcajVar, boolean z, int i, String str, String str2) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzej)).booleanValue()) {
            zzdmuVar.zzi(zzcfgVar, zzcajVar);
            return;
        }
        if (z) {
            zzdmuVar.zzi(zzcfgVar, zzcajVar);
            return;
        }
        zzcajVar.zzd(new zzehf(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }

    private final void zzi(zzcfg zzcfgVar, zzcaj zzcajVar) {
        com.google.android.gms.ads.internal.client.zzgc zzgcVar = this.zza.zza;
        if (zzgcVar != null && zzcfgVar.zzq() != null) {
            zzcfgVar.zzq().zzs(zzgcVar);
        }
        zzcajVar.zzb();
    }

    private static final void zzj(zzcfg zzcfgVar) {
        zzcfgVar.zzag("/videoClicked", zzbke.zzh);
        zzcfgVar.zzN().zzJ(true);
        zzcfgVar.zzag("/getNativeAdViewSignals", zzbke.zzs);
        zzcfgVar.zzag("/getNativeClickMeta", zzbke.zzt);
    }

    public final ListenableFuture zzd(final JSONObject jSONObject, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbya zzbyaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzi.zza(), zzdrr.zzae.zza());
        }
        ListenableFuture listenableFutureZzh = zzgdn.zzh(null);
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdmo
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmu.zza(this.zza, zzbVar, zzbyaVar, obj);
            }
        };
        Executor executor = this.zzb;
        return zzgdn.zzn(zzgdn.zzn(listenableFutureZzh, zzgcuVar, executor), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdmn
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmu.zzb(this.zza, jSONObject, (zzcfg) obj);
            }
        }, executor);
    }

    public final ListenableFuture zze(final String str, final String str2, final zzfca zzfcaVar, final zzfcd zzfcdVar, final com.google.android.gms.ads.internal.client.zzr zzrVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzbya zzbyaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcx)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, this.zzi.zza(), zzdrr.NATIVE_ASSETS_LOADING_VIDEO_COMPOSITION_START.zza());
        }
        return zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzdmk
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzdmu.zzc(this.zza, zzrVar, zzfcaVar, zzfcdVar, zzbVar, zzbyaVar, str, str2, obj);
            }
        }, this.zzb);
    }

    private final void zzh(zzcfg zzcfgVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2;
        zzj(zzcfgVar);
        zzcfgVar.zzag("/video", zzbke.zzl);
        zzcfgVar.zzag("/videoMeta", zzbke.zzm);
        zzcfgVar.zzag("/precache", new zzcdo());
        zzcfgVar.zzag(UUFMQdNK.UTUyNIpeQQS, zzbke.zzp);
        zzcfgVar.zzag(MnHfHMYQDPUO.coRwvZZK, zzbke.zzn);
        zzcfgVar.zzag("/log", zzbke.zzg);
        zzcfgVar.zzag("/click", new zzbjd(null, 0 == true ? 1 : 0));
        if (this.zza.zzb != null) {
            zzcfgVar.zzN().zzH(true);
            if (true != ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznP)).booleanValue()) {
                zzbVar2 = null;
            } else {
                zzbVar2 = zzbVar;
            }
            zzcfgVar.zzag("/open", new zzbkr(zzbVar2, null, null, null, null));
        } else {
            zzcfgVar.zzN().zzH(false);
        }
        if (com.google.android.gms.ads.internal.zzv.zza.zzB.zzp(zzcfgVar.getContext())) {
            Map map = new HashMap();
            if (zzcfgVar.zzD() != null) {
                map = zzcfgVar.zzD().zzaw;
            }
            zzcfgVar.zzag("/logScionEvent", new zzbkl(zzcfgVar.getContext(), map));
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznP)).booleanValue()) {
            zzcfgVar.zzN().zzD(zzbVar);
            zzcfgVar.zzN().zzL(zzbyaVar);
        }
    }
}
