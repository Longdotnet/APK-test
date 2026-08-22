package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzboi {
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    private final zzfhx zze;
    private final com.google.android.gms.ads.internal.util.zzbd zzf;
    private final com.google.android.gms.ads.internal.util.zzbd zzg;
    private zzboh zzh;
    private final Object zza = new Object();
    private int zzi = 1;

    public zzboi(Context context, VersionInfoParcel versionInfoParcel, String str, com.google.android.gms.ads.internal.util.zzbd zzbdVar, com.google.android.gms.ads.internal.util.zzbd zzbdVar2, zzfhx zzfhxVar) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = versionInfoParcel;
        this.zze = zzfhxVar;
        this.zzf = zzbdVar;
        this.zzg = zzbdVar2;
    }

    public static /* synthetic */ void zzg(zzboi zzboiVar, zzbnd zzbndVar) {
        if (zzbndVar.zzi()) {
            zzboiVar.zzi = 1;
        }
    }

    public static void zzh(zzboi zzboiVar, zzavu zzavuVar, zzboh zzbohVar) {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            zzbnl zzbnlVar = new zzbnl(zzboiVar.zzb, zzboiVar.zzd, null, null);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbnlVar.zzk(new zzbno(zzboiVar, arrayList, jCurrentTimeMillis, zzbohVar, zzbnlVar));
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbnlVar.zzq("/jsLoaded", new zzbnt(zzboiVar, jCurrentTimeMillis, zzbohVar, zzbnlVar));
            com.google.android.gms.ads.internal.util.zzby zzbyVar = new com.google.android.gms.ads.internal.util.zzby();
            zzbnu zzbnuVar = new zzbnu(zzboiVar, null, zzbnlVar, zzbyVar);
            zzbyVar.zza = zzbnuVar;
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbnlVar.zzq("/requestReload", zzbnuVar);
            String str = zzboiVar.zzc;
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(str)));
            if (str.endsWith(".js")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbnlVar.zzh(str);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (str.startsWith("<html>")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbnlVar.zzf(str);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbnlVar.zzg(str);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new zzbnw(zzboiVar, zzbohVar, zzbnlVar, arrayList, jCurrentTimeMillis), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzd)).intValue());
        } catch (Throwable th) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error creating webview.", th);
            zzbcv zzbcvVar = zzbde.zzhZ;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                zzbohVar.zzh(th, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            if (((Boolean) zzbdVar.zzd.zzb(zzbde.zzib)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbohVar.zzg();
            } else {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbohVar.zzg();
            }
        }
    }

    public static void zzi(zzboi zzboiVar, zzboh zzbohVar, final zzbnd zzbndVar, ArrayList arrayList, long j) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (zzboiVar.zza) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
                if (zzbohVar.zze() != -1 && zzbohVar.zze() != 1) {
                    zzbcv zzbcvVar = zzbde.zzhZ;
                    com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                    if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                        zzbohVar.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                    } else {
                        zzbohVar.zzg();
                    }
                    zzgdy zzgdyVar = zzcaf.zzf;
                    Objects.requireNonNull(zzbndVar);
                    zzgdyVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnn
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzbndVar.zzc();
                        }
                    });
                    String strValueOf = String.valueOf(zzbdVar.zzd.zzb(zzbde.zzc));
                    int iZze = zzbohVar.zze();
                    int i = zzboiVar.zzi;
                    String strValueOf2 = String.valueOf(arrayList.get(0));
                    com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                    com.google.android.gms.ads.internal.util.zze.zza("Could not receive /jsLoaded in " + strValueOf + " ms. JS engine session reference status(onEngLoadedTimeout) is " + iZze + ". Update status(onEngLoadedTimeout) is " + i + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + strValueOf2 + " ms. Total latency(onEngLoadedTimeout) is " + (System.currentTimeMillis() - j) + " ms. Rejecting.");
                    com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                    return;
                }
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzboc zzb(zzavu zzavuVar) {
        com.google.android.gms.ads.internal.util.zze.zza("getEngine: Trying to acquire lock");
        Object obj = this.zza;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("getEngine: Lock acquired");
                com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Trying to acquire lock");
                synchronized (obj) {
                    try {
                        com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock acquired");
                        zzboh zzbohVar = this.zzh;
                        if (zzbohVar != null && this.zzi == 0) {
                            zzbohVar.zzj(new zzcao() { // from class: com.google.android.gms.internal.ads.zzbnq
                                @Override // com.google.android.gms.internal.ads.zzcao
                                public final void zza(Object obj2) {
                                    zzboi.zzg(this.zza, (zzbnd) obj2);
                                }
                            }, new zzcam() { // from class: com.google.android.gms.internal.ads.zzbnr
                                @Override // com.google.android.gms.internal.ads.zzcam
                                public final void zza() {
                                }
                            });
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock released");
        zzboh zzbohVar2 = this.zzh;
        if (zzbohVar2 != null && zzbohVar2.zze() != -1) {
            int i = this.zzi;
            if (i == 0) {
                com.google.android.gms.ads.internal.util.zze.zza("getEngine (NO_UPDATE): Lock released");
                return this.zzh.zza();
            }
            if (i != 1) {
                com.google.android.gms.ads.internal.util.zze.zza("getEngine (UPDATING): Lock released");
                return this.zzh.zza();
            }
            this.zzi = 2;
            zzd(null);
            com.google.android.gms.ads.internal.util.zze.zza("getEngine (PENDING_UPDATE): Lock released");
            return this.zzh.zza();
        }
        this.zzi = 2;
        this.zzh = zzd(null);
        com.google.android.gms.ads.internal.util.zze.zza("getEngine (NULL or REJECTED): Lock released");
        return this.zzh.zza();
    }

    public final zzboh zzd(zzavu zzavuVar) {
        zzfhj zzfhjVarZza = zzfhi.zza(this.zzb, 6);
        zzfhjVarZza.zzi();
        final zzboh zzbohVar = new zzboh(this.zzg);
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        final zzavu zzavuVar2 = null;
        zzcaf.zzf.execute(new Runnable(zzavuVar2, zzbohVar) { // from class: com.google.android.gms.internal.ads.zzbns
            public final /* synthetic */ zzboh zzb;

            {
                this.zzb = zzbohVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzboi.zzh(this.zza, null, this.zzb);
            }
        });
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine: Promise created");
        zzbohVar.zzj(new zzbnx(this, zzbohVar, zzfhjVarZza), new zzbny(this, zzbohVar, zzfhjVarZza));
        return zzbohVar;
    }
}
