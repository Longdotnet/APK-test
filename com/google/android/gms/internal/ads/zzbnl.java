package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbnl implements zzbnd, zzbnc {
    private final zzcfg zza;

    public zzbnl(Context context, VersionInfoParcel versionInfoParcel, zzavu zzavuVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzcfs {
        zzcft zzcftVar = com.google.android.gms.ads.internal.zzv.zza.zze;
        zzcfg zzcfgVarZza = zzcft.zza(context, zzchd.zza(), "", false, false, null, null, versionInfoParcel, null, null, null, zzbcc.zza(), null, null, null, null, null);
        this.zza = zzcfgVarZza;
        zzcfgVarZza.zzF().setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (com.google.android.gms.ads.internal.util.zzs.zza.post(runnable)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzj("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zza(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("invokeJavascript on adWebView from js");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.zza(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final /* synthetic */ void zzb(String str, String str2) {
        zzbnb.zzc(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzc() {
        this.zza.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final /* synthetic */ void zzd(String str, Map map) {
        zzbnb.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbnb.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzf(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtml on adWebView from html");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbni
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.loadData(str, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzg(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.loadUrl(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzh(String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        final String str2 = "<!DOCTYPE html><html><head><script src=\"" + str + "\"></script></head><body></body></html>";
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza.loadData(str2, "text/html", "UTF-8");
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final boolean zzi() {
        return this.zza.zzaE();
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final zzbok zzj() {
        return new zzbok(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbnd
    public final void zzk(final zzbno zzbnoVar) {
        zzcgy zzcgyVarZzN = this.zza.zzN();
        Objects.requireNonNull(zzbnoVar);
        zzcgyVarZzN.zzK(new zzcgx() { // from class: com.google.android.gms.internal.ads.zzbng
            @Override // com.google.android.gms.internal.ads.zzcgx
            public final void zza() {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                zzbno zzbnoVar2 = zzbnoVar;
                final long j = zzbnoVar2.zzc;
                final ArrayList arrayList = zzbnoVar2.zzb;
                arrayList.add(Long.valueOf(jCurrentTimeMillis - j));
                com.google.android.gms.ads.internal.util.zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + String.valueOf(arrayList.get(0)) + " ms.");
                com.google.android.gms.ads.internal.util.zzf zzfVar = com.google.android.gms.ads.internal.util.zzs.zza;
                final zzboi zzboiVar = zzbnoVar2.zza;
                final zzboh zzbohVar = zzbnoVar2.zzd;
                final zzbnd zzbndVar = zzbnoVar2.zze;
                zzfVar.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbnp
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzboi.zzi(zzboiVar, zzbohVar, zzbndVar, arrayList, j);
                    }
                }, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzc)).intValue());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final /* synthetic */ void zzp(String str, JSONObject jSONObject) {
        zzbnb.zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzboj
    public final void zzq(String str, zzbkf zzbkfVar) {
        this.zza.zzag(str, new zzbnk(this, zzbkfVar));
    }

    @Override // com.google.android.gms.internal.ads.zzboj
    public final void zzr(String str, final zzbkf zzbkfVar) {
        this.zza.zzaA(str, new Predicate() { // from class: com.google.android.gms.internal.ads.zzbne
            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzbkf zzbkfVar2 = (zzbkf) obj;
                if (zzbkfVar2 instanceof zzbnk) {
                    return ((zzbnk) zzbkfVar2).zzb.equals(zzbkfVar);
                }
                return false;
            }
        });
    }
}
