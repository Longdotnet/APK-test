package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzefk implements zzedm {
    private final Context zza;
    private final zzdpj zzb;
    private final zzdgf zzc;
    private final zzfcw zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbki zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjo)).booleanValue();
    private final zzecl zzi;
    private final zzdsd zzj;
    private final zzdsj zzk;

    public zzefk(Context context, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar, Executor executor, zzdgf zzdgfVar, zzdpj zzdpjVar, zzbki zzbkiVar, zzecl zzeclVar, zzdsd zzdsdVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzd = zzfcwVar;
        this.zzc = zzdgfVar;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdpjVar;
        this.zzg = zzbkiVar;
        this.zzi = zzeclVar;
        this.zzj = zzdsdVar;
        this.zzk = zzdsjVar;
    }

    public static ListenableFuture zzc(zzefk zzefkVar, final zzfca zzfcaVar, zzfcn zzfcnVar, zzdpn zzdpnVar, Object obj) {
        final zzefk zzefkVar2;
        zzbcv zzbcvVar = zzbde.zzct;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzefkVar.zzj.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_START.zza());
        }
        zzdpj zzdpjVar = zzefkVar.zzb;
        zzfcw zzfcwVar = zzefkVar.zzd;
        final zzcfg zzcfgVarZza = zzdpjVar.zza(zzfcwVar.zze, zzfcaVar, zzfcnVar.zzb.zzb);
        zzcfgVarZza.zzac(zzfcaVar.zzW);
        Context context = zzefkVar.zza;
        zzdpnVar.zza(context, zzcfgVarZza.zzF());
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzefkVar.zzj.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_END.zza());
        }
        zzcak zzcakVar = new zzcak();
        zzdgf zzdgfVar = zzefkVar.zzc;
        zzcrq zzcrqVar = new zzcrq(zzfcnVar, zzfcaVar, null);
        VersionInfoParcel versionInfoParcel = zzefkVar.zzf;
        boolean z = zzefkVar.zzh;
        zzbki zzbkiVar = zzefkVar.zzg;
        final zzdfc zzdfcVarZzd = zzdgfVar.zzd(zzcrqVar, new zzdff(new zzefj(context, versionInfoParcel, zzcakVar, zzfcaVar, zzcfgVarZza, zzfcwVar, z, zzbkiVar, zzefkVar.zzi, zzefkVar.zzk), zzcfgVarZza));
        zzcakVar.zzc(zzdfcVarZzd);
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            zzefkVar2 = zzefkVar;
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzefkVar2.zzj.zza(), zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza());
        } else {
            zzefkVar2 = zzefkVar;
        }
        zzdfcVarZzd.zzc().zzo(new zzcws() { // from class: com.google.android.gms.internal.ads.zzefh
            @Override // com.google.android.gms.internal.ads.zzcws
            public final void zzt() {
                zzcfg zzcfgVar = zzcfgVarZza;
                if (zzcfgVar.zzN() != null) {
                    zzcfgVar.zzN().zzs();
                }
            }
        }, zzcaf.zzg);
        zzfcf zzfcfVar = zzfcaVar.zzs;
        String strZzb = zzfcfVar.zza;
        if (((Boolean) zzbdcVar.zzb(zzbde.zzfC)).booleanValue() && zzdfcVarZzd.zzl().zze(true)) {
            strZzb = zzcgr.zzb(strZzb, zzcgr.zza(zzfcaVar));
        }
        zzdpi zzdpiVarZzi = zzdfcVarZzd.zzi();
        zzbki zzbkiVar2 = true != z ? null : zzbkiVar;
        zzdsd zzdsdVar = zzefkVar2.zzj;
        zzdpiVarZzi.zzi(zzcfgVarZza, true, zzbkiVar2, zzdsdVar.zza());
        zzdfcVarZzd.zzi();
        return zzgdn.zzm(zzdpi.zzj(zzcfgVarZza, zzfcfVar.zzb, strZzb, zzdsdVar.zza(), zzdgfVar.zze()), new zzfve(zzefkVar2) { // from class: com.google.android.gms.internal.ads.zzefi
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj2) {
                zzcfg zzcfgVar = zzcfgVarZza;
                if (zzfcaVar.zzM) {
                    zzcfgVar.zzah();
                }
                zzdfc zzdfcVar = zzdfcVarZzd;
                zzcfgVar.zzab();
                zzcfgVar.onPause();
                return zzdfcVar.zzg();
            }
        }, zzefkVar2.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        final zzdpn zzdpnVar = new zzdpn();
        ListenableFuture listenableFutureZzh = zzgdn.zzh(null);
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeff
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzefk.zzc(this.zza, zzfcaVar, zzfcnVar, zzdpnVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFutureZzh, zzgcuVar, executor);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzefg
            @Override // java.lang.Runnable
            public final void run() {
                zzdpnVar.zzb();
            }
        }, executor);
        return listenableFutureZzn;
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        zzfcf zzfcfVar = zzfcaVar.zzs;
        return (zzfcfVar == null || zzfcfVar.zza == null) ? false : true;
    }
}
