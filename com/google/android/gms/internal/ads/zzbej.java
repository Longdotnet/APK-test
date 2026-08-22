package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.loader.app.gv.DYYbQc;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbej {
    private final ScheduledExecutorService zza;
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzo zzb;
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzf zzc;
    private final zzdso zzd;
    private Runnable zze;
    private zzbeg zzf;
    private CustomTabsSession zzg;
    private String zzh;
    private long zzi = 0;
    private long zzj;
    private JSONArray zzk;
    private Context zzl;

    public zzbej(ScheduledExecutorService scheduledExecutorService, com.google.android.gms.ads.nonagon.signalgeneration.zzo zzoVar, com.google.android.gms.ads.nonagon.signalgeneration.zzf zzfVar, zzdso zzdsoVar) {
        this.zza = scheduledExecutorService;
        this.zzb = zzoVar;
        this.zzc = zzfVar;
        this.zzd = zzdsoVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:21:0x003e  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(com.google.android.gms.internal.ads.zzbde.zzkn)).booleanValue() != false) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzj() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbeg r0 = r6.zzf
            if (r0 != 0) goto Lc
            int r0 = com.google.android.gms.ads.internal.util.zze.$r8$clinit
            java.lang.String r0 = "PACT callback is not present, please initialize the PawCustomTabsImpl."
            com.google.android.gms.ads.internal.util.client.zzo.zzg(r0)
            return
        Lc:
            java.lang.Boolean r0 = r0.zza()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L17
            return
        L17:
            java.lang.String r0 = r6.zzh
            if (r0 == 0) goto L98
            androidx.browser.customtabs.CustomTabsSession r0 = r6.zzg
            if (r0 == 0) goto L98
            java.util.concurrent.ScheduledExecutorService r0 = r6.zza
            if (r0 == 0) goto L98
            long r1 = r6.zzi
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L2c
            goto L3e
        L2c:
            com.google.android.gms.ads.internal.zzv r1 = com.google.android.gms.ads.internal.zzv.zza
            com.google.android.gms.common.util.DefaultClock r1 = r1.zzl
            r1.getClass()
            long r1 = android.os.SystemClock.elapsedRealtime()
            long r3 = r6.zzi
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 > 0) goto L3e
            goto L50
        L3e:
            com.google.android.gms.internal.ads.zzbcv r1 = com.google.android.gms.internal.ads.zzbde.zzkn
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.zza
            com.google.android.gms.internal.ads.zzbdc r2 = r2.zzd
            java.lang.Object r1 = r2.zzb(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L98
        L50:
            androidx.browser.customtabs.CustomTabsSession r1 = r6.zzg
            java.lang.String r2 = r6.zzh
            android.net.Uri r2 = android.net.Uri.parse(r2)
            r1.getClass()
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            android.os.Bundle r4 = new android.os.Bundle     // Catch: android.os.RemoteException -> L80
            r4.<init>()     // Catch: android.os.RemoteException -> L80
            boolean r5 = r4.isEmpty()     // Catch: android.os.RemoteException -> L80
            if (r5 == 0) goto L6c
            r4 = 0
        L6c:
            androidx.browser.customtabs.CustomTabsClient$2 r5 = r1.mCallback
            android.support.customtabs.ICustomTabsService r1 = r1.mService
            if (r4 == 0) goto L7b
            r3.putAll(r4)     // Catch: android.os.RemoteException -> L80
            android.support.customtabs.ICustomTabsService$Stub$Proxy r1 = (android.support.customtabs.ICustomTabsService.Stub.Proxy) r1     // Catch: android.os.RemoteException -> L80
            r1.requestPostMessageChannelWithExtras(r5, r2, r3)     // Catch: android.os.RemoteException -> L80
            goto L80
        L7b:
            android.support.customtabs.ICustomTabsService$Stub$Proxy r1 = (android.support.customtabs.ICustomTabsService.Stub.Proxy) r1     // Catch: android.os.RemoteException -> L80
            r1.requestPostMessageChannel(r5, r2)     // Catch: android.os.RemoteException -> L80
        L80:
            java.lang.Runnable r1 = r6.zze
            com.google.android.gms.internal.ads.zzbcv r2 = com.google.android.gms.internal.ads.zzbde.zzko
            com.google.android.gms.ads.internal.client.zzbd r3 = com.google.android.gms.ads.internal.client.zzbd.zza
            com.google.android.gms.internal.ads.zzbdc r3 = r3.zzd
            java.lang.Object r2 = r3.zzb(r2)
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r2, r4)
            return
        L98:
            java.lang.String r0 = "PACT max retry connection duration timed out"
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbej.zzj():void");
    }

    private final void zzk(JSONObject jSONObject) {
        try {
            if (this.zzk == null) {
                this.zzk = new JSONArray((String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkq));
            }
            jSONObject.put("eids", this.zzk);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error fetching the PACT active eids JSON: ", e);
        }
    }

    public final CustomTabsSession zzb() {
        return this.zzg;
    }

    public final JSONObject zzd(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("signal", str2);
        jSONObject.put("sdk_ttl_ms", ((Boolean) zzbfj.zze.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L);
        zzk(jSONObject);
        if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
            jSONObject.put("as", this.zzc.zza());
        }
        return jSONObject;
    }

    public final void zzf() {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zzi = SystemClock.elapsedRealtime() + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzkm)).intValue());
        if (this.zze == null) {
            this.zze = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbeh
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzj();
                }
            };
        }
        zzj();
    }

    public final void zzg(Context context, CustomTabsClient customTabsClient, String str, CustomTabsCallback customTabsCallback) {
        if (context == null) {
            throw new IllegalArgumentException("App Context parameter is null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Origin parameter is empty or null");
        }
        if (customTabsClient == null) {
            throw new IllegalArgumentException("CustomTabsClient parameter is null");
        }
        this.zzl = context;
        this.zzh = str;
        zzdso zzdsoVar = this.zzd;
        zzbeg zzbegVar = new zzbeg(this, customTabsCallback, zzdsoVar);
        this.zzf = zzbegVar;
        CustomTabsSession customTabsSessionNewSession = customTabsClient.newSession(zzbegVar);
        this.zzg = customTabsSessionNewSession;
        if (customTabsSessionNewSession == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("CustomTabsClient failed to create new session.");
        }
        MediaType.Companion.zzd(zzdsoVar, "pact_action", new Pair("pe", "pact_init"));
    }

    public final void zzi(long j) {
        this.zzj = j;
    }

    public final JSONObject zzc(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paw_id", str);
        jSONObject.put("error", str2);
        jSONObject.put(DYYbQc.kRaK, ((Boolean) zzbfj.zze.zze()).booleanValue() ? ((Long) zzbfj.zzh.zze()).longValue() : 0L);
        zzk(jSONObject);
        if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
            jSONObject.put("as", this.zzc.zza());
        }
        return jSONObject;
    }

    public final void zzh(String str) {
        try {
            CustomTabsSession customTabsSession = this.zzg;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("gsppack", true);
            jSONObject.put("fpt", new Date(this.zzj).toString());
            zzk(jSONObject);
            if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
                jSONObject.put("as", this.zzc.zza());
            }
            customTabsSession.postMessage(jSONObject.toString());
            zzbei zzbeiVar = new zzbei(this, str);
            if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
                this.zzb.zzg(this.zzg, zzbeiVar);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("query_info_type", "requester_type_6");
            QueryInfo.generate(this.zzl, new AdRequest((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(bundle)), zzbeiVar);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh(RDFWIi.IVqFYGmnCrqhCG, e);
        }
    }
}
