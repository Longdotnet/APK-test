package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzeie implements zzedm {
    private final Context zza;
    private final zzdpj zzb;
    private final zzdos zzc;
    private final zzfcw zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzbki zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjo)).booleanValue();
    private final zzecl zzi;
    private final zzdsd zzj;
    private final zzdsj zzk;

    public zzeie(Context context, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar, Executor executor, zzdos zzdosVar, zzdpj zzdpjVar, zzbki zzbkiVar, zzecl zzeclVar, zzdsd zzdsdVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzd = zzfcwVar;
        this.zzc = zzdosVar;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdpjVar;
        this.zzg = zzbkiVar;
        this.zzi = zzeclVar;
        this.zzj = zzdsdVar;
        this.zzk = zzdsjVar;
    }

    public static ListenableFuture zzc(final zzeie zzeieVar, final zzfca zzfcaVar, zzfcn zzfcnVar, zzdpn zzdpnVar, Object obj) {
        zzbcv zzbcvVar = zzbde.zzct;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzeieVar.zzj.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_START.zza());
        }
        zzdpj zzdpjVar = zzeieVar.zzb;
        zzfcw zzfcwVar = zzeieVar.zzd;
        final zzcfg zzcfgVarZza = zzdpjVar.zza(zzfcwVar.zze, zzfcaVar, zzfcnVar.zzb.zzb);
        zzcfgVarZza.zzac(zzfcaVar.zzW);
        Context context = zzeieVar.zza;
        zzdpnVar.zza(context, zzcfgVarZza.zzF());
        zzbdc zzbdcVar = zzbdVar.zzd;
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzeieVar.zzj.zza(), zzdrr.RENDERING_WEBVIEW_CREATION_END.zza());
        }
        zzcak zzcakVar = new zzcak();
        zzdos zzdosVar = zzeieVar.zzc;
        zzcrq zzcrqVar = new zzcrq(zzfcnVar, zzfcaVar, null);
        VersionInfoParcel versionInfoParcel = zzeieVar.zzf;
        zzbki zzbkiVar = zzeieVar.zzg;
        boolean z = zzeieVar.zzh;
        zzecl zzeclVar = zzeieVar.zzi;
        zzdsd zzdsdVar = zzeieVar.zzj;
        final zzdoo zzdooVarZzd = zzdosVar.zzd(zzcrqVar, new zzdop(new zzeid(context, zzdpjVar, zzfcwVar, versionInfoParcel, zzfcaVar, zzcakVar, zzcfgVarZza, zzbkiVar, z, zzeclVar, zzdsdVar, zzeieVar.zzk), zzcfgVarZza));
        zzcakVar.zzc(zzdooVarZzd);
        if (((Boolean) zzbdcVar.zzb(zzbcvVar)).booleanValue()) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, zzdsdVar.zza(), zzdrr.RENDERING_AD_COMPONENT_CREATION_END.zza());
        }
        zzbkx.zzb(zzcfgVarZza, zzdooVarZzd.zzg());
        zzdooVarZzd.zzc().zzo(new zzcws() { // from class: com.google.android.gms.internal.ads.zzehx
            @Override // com.google.android.gms.internal.ads.zzcws
            public final void zzt() {
                zzcfg zzcfgVar = zzcfgVarZza;
                if (zzcfgVar.zzN() != null) {
                    zzcfgVar.zzN().zzs();
                }
            }
        }, zzcaf.zzg);
        zzdooVarZzd.zzl().zzi(zzcfgVarZza, true, true != z ? null : zzbkiVar, zzdsdVar.zza());
        zzfcf zzfcfVar = zzfcaVar.zzs;
        String strZzb = zzfcfVar.zza;
        if (((Boolean) zzbdcVar.zzb(zzbde.zzfC)).booleanValue() && zzdooVarZzd.zzm().zze(true)) {
            strZzb = zzcgr.zzb(strZzb, zzcgr.zza(zzfcaVar));
        }
        zzdooVarZzd.zzl();
        return zzgdn.zzm(zzdpi.zzj(zzcfgVarZza, zzfcfVar.zzb, strZzb, zzdsdVar.zza(), zzdosVar.zzg()), new zzfve(zzeieVar) { // from class: com.google.android.gms.internal.ads.zzehy
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj2) {
                zzcfg zzcfgVar = zzcfgVarZza;
                if (zzfcaVar.zzM) {
                    zzcfgVar.zzah();
                }
                zzdoo zzdooVar = zzdooVarZzd;
                zzcfgVar.zzab();
                zzcfgVar.onPause();
                return zzdooVar.zzi();
            }
        }, zzeieVar.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        final zzdpn zzdpnVar = new zzdpn();
        ListenableFuture listenableFutureZzh = zzgdn.zzh(null);
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzehz
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzeie.zzc(this.zza, zzfcaVar, zzfcnVar, zzdpnVar, obj);
            }
        };
        Executor executor = this.zze;
        ListenableFuture listenableFutureZzn = zzgdn.zzn(listenableFutureZzh, zzgcuVar, executor);
        listenableFutureZzn.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeia
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
