package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzedx implements zzedm {
    private final zzcog zza;
    private final Context zzb;
    private final zzdpj zzc;
    private final zzfcw zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbki zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjo)).booleanValue();
    private final zzecl zzi;
    private final zzdsd zzj;
    private final zzdsj zzk;

    public zzedx(zzcog zzcogVar, Context context, Executor executor, zzdpj zzdpjVar, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel, zzbki zzbkiVar, zzecl zzeclVar, zzdsd zzdsdVar, zzdsj zzdsjVar) {
        this.zzb = context;
        this.zza = zzcogVar;
        this.zze = executor;
        this.zzc = zzdpjVar;
        this.zzd = zzfcwVar;
        this.zzf = versionInfoParcel;
        this.zzg = zzbkiVar;
        this.zzi = zzeclVar;
        this.zzj = zzdsdVar;
        this.zzk = zzdsjVar;
    }

    public static ListenableFuture zzc(zzedx zzedxVar, final zzfca zzfcaVar, zzfcn zzfcnVar, zzdpn zzdpnVar, Object obj) {
        final zzedx zzedxVar2;
        zzbcv zzbcvVar = zzbde.zzct;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzedxVar.zzj.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_START.zza());
        }
        zzdpj zzdpjVar = zzedxVar.zzc;
        zzfcw zzfcwVar = zzedxVar.zzd;
        final zzcfg zzcfgVarZza = zzdpjVar.zza(zzfcwVar.zze, zzfcaVar, zzfcnVar.zzb.zzb);
        zzcfgVarZza.zzac(zzfcaVar.zzW);
        zzdpnVar.zza(zzedxVar.zzb, zzcfgVarZza.zzF());
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzedxVar.zzj.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_END.zza());
        }
        zzcak zzcakVar = new zzcak();
        zzcog zzcogVar = zzedxVar.zza;
        zzcrq zzcrqVar = new zzcrq(zzfcnVar, zzfcaVar, null);
        VersionInfoParcel versionInfoParcel = zzedxVar.zzf;
        boolean z = zzedxVar.zzh;
        zzbki zzbkiVar = zzedxVar.zzg;
        final zzcod zzcodVarZza = zzcogVar.zza(zzcrqVar, new zzdff(new zzedz(versionInfoParcel, zzcakVar, zzfcaVar, zzcfgVarZza, zzfcwVar, z, zzbkiVar, zzedxVar.zzi, zzedxVar.zzk), zzcfgVarZza), new zzcoe(zzfcaVar.zzaa));
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            zzedxVar2 = zzedxVar;
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzedxVar2.zzj.zza(), zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza());
        } else {
            zzedxVar2 = zzedxVar;
        }
        zzdpi zzdpiVarZzh = zzcodVarZza.zzh();
        zzbki zzbkiVar2 = true != z ? null : zzbkiVar;
        zzdsd zzdsdVar = zzedxVar2.zzj;
        zzdpiVarZzh.zzi(zzcfgVarZza, false, zzbkiVar2, zzdsdVar.zza());
        zzcakVar.zzc(zzcodVarZza);
        zzcodVarZza.zzc().zzo(new zzcws() { // from class: com.google.android.gms.internal.ads.zzedv
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
        if (((Boolean) zzbdcVar.zzb(zzbde.zzfC)).booleanValue() && zzcodVarZza.zzi().zze(true)) {
            strZzb = zzcgr.zzb(strZzb, zzcgr.zza(zzfcaVar));
        }
        zzcodVarZza.zzh();
        return zzgdn.zzm(zzdpi.zzj(zzcfgVarZza, zzfcfVar.zzb, strZzb, zzdsdVar.zza(), zzcogVar.zzg()), new zzfve(zzedxVar2) { // from class: com.google.android.gms.internal.ads.zzedw
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj2) {
                zzcfg zzcfgVar = zzcfgVarZza;
                if (zzfcaVar.zzM) {
                    zzcfgVar.zzah();
                }
                zzcod zzcodVar = zzcodVarZza;
                zzcfgVar.zzab();
                zzcfgVar.onPause();
                return zzcodVar.zza();
            }
        }, zzedxVar2.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        final zzdpn zzdpnVar = new zzdpn();
        ListenableFuture listenableFutureZzh = zzgdn.zzh(null);
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzedt
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzedx.zzc(this.zza, zzfcaVar, zzfcnVar, zzdpnVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFutureZzh, zzgcuVar, executor);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedu
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
