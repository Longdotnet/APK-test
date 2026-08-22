package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzcft {
    public static final zzcfg zza(final Context context, final zzchd zzchdVar, final String str, final boolean z, final boolean z2, final zzavu zzavuVar, final zzbel zzbelVar, final VersionInfoParcel versionInfoParcel, zzbdt zzbdtVar, final com.google.android.gms.ads.internal.zzn zznVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzbcc zzbccVar, final zzfca zzfcaVar, final zzfcd zzfcdVar, final zzecl zzeclVar, final zzfda zzfdaVar, final zzdsj zzdsjVar) throws zzcfs {
        zzbde.zza(context);
        try {
            final zzbdt zzbdtVar2 = null;
            zzfwh zzfwhVar = new zzfwh(context, zzchdVar, str, z, z2, zzavuVar, zzbelVar, versionInfoParcel, zzbdtVar2, zznVar, zzaVar, zzbccVar, zzfcaVar, zzfcdVar, zzfdaVar, zzdsjVar, zzeclVar) { // from class: com.google.android.gms.internal.ads.zzcfr
                public final /* synthetic */ Context zza;
                public final /* synthetic */ zzchd zzb;
                public final /* synthetic */ String zzc;
                public final /* synthetic */ boolean zzd;
                public final /* synthetic */ boolean zze;
                public final /* synthetic */ zzavu zzf;
                public final /* synthetic */ zzbel zzg;
                public final /* synthetic */ VersionInfoParcel zzh;
                public final /* synthetic */ com.google.android.gms.ads.internal.zzn zzi;
                public final /* synthetic */ com.google.android.gms.ads.internal.zza zzj;
                public final /* synthetic */ zzbcc zzk;
                public final /* synthetic */ zzfca zzl;
                public final /* synthetic */ zzfcd zzm;
                public final /* synthetic */ zzfda zzn;
                public final /* synthetic */ zzdsj zzo;
                public final /* synthetic */ zzecl zzp;

                {
                    this.zzi = zznVar;
                    this.zzj = zzaVar;
                    this.zzk = zzbccVar;
                    this.zzl = zzfcaVar;
                    this.zzm = zzfcdVar;
                    this.zzn = zzfdaVar;
                    this.zzo = zzdsjVar;
                    this.zzp = zzeclVar;
                }

                @Override // com.google.android.gms.internal.ads.zzfwh
                public final Object zza() {
                    zzchd zzchdVar2 = this.zzb;
                    String str2 = this.zzc;
                    boolean z3 = this.zzd;
                    zzbcc zzbccVar2 = this.zzk;
                    boolean z4 = this.zze;
                    zzavu zzavuVar2 = this.zzf;
                    zzfca zzfcaVar2 = this.zzl;
                    zzbel zzbelVar2 = this.zzg;
                    com.google.android.gms.ads.internal.zzn zznVar2 = this.zzi;
                    zzfcd zzfcdVar2 = this.zzm;
                    Context context2 = this.zza;
                    VersionInfoParcel versionInfoParcel2 = this.zzh;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.zzj;
                    zzfda zzfdaVar2 = this.zzn;
                    zzdsj zzdsjVar2 = this.zzo;
                    zzecl zzeclVar2 = this.zzp;
                    try {
                        TrafficStats.setThreadStatsTag(264);
                        int i = zzcgf.zza;
                        zzcfy zzcfyVar = new zzcfy(new zzcgf(new zzchc(context2), zzchdVar2, str2, z3, z4, zzavuVar2, zzbelVar2, versionInfoParcel2, null, zznVar2, zzaVar2, zzbccVar2, zzfcaVar2, zzfcdVar2, zzfdaVar2), zzdsjVar2);
                        com.google.android.gms.ads.internal.zzv.zza.zzg.getClass();
                        zzcfyVar.setWebViewClient(new zzcgp(zzcfyVar, zzbccVar2, z4, zzeclVar2));
                        zzcfyVar.setWebChromeClient(new zzcff(zzcfyVar));
                        return zzcfyVar;
                    } finally {
                        TrafficStats.clearThreadStatsTag();
                    }
                }
            };
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            try {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
                return (zzcfg) zzfwhVar.zza();
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        } catch (Throwable th) {
            throw new zzcfs("Webview initialization failed.", th);
        }
    }
}
