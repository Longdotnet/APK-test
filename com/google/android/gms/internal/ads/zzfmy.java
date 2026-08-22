package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import com.google.android.gms.ads.rewarded.zQ.yzwzcWHcnH;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zzfmy {
    private final String zza;
    private zzfoa zzb;
    private long zzc;
    private int zzd;

    public zzfmy(String str) {
        zzb();
        this.zza = str;
        this.zzb = new zzfoa(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebView zza() {
        return (WebView) this.zzb.get();
    }

    public final void zzb() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }

    public void zzc() {
        this.zzb.clear();
    }

    public final void zzd(String str, long j) {
        if (j < this.zzc || this.zzd == 3) {
            return;
        }
        this.zzd = 3;
        zzfmp.zza().zzh(zza(), this.zza, str);
    }

    public final void zze() {
        zzfmp.zza().zzc(zza(), this.zza);
    }

    public final void zzf(zzflm zzflmVar) {
        zzfmp.zza().zzd(zza(), this.zza, zzflmVar.zzb());
    }

    public final void zzg(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzfne.zze(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzfmp.zza().zzf(zza(), jSONObject);
    }

    public final void zzh(String str, long j) {
        if (j >= this.zzc) {
            this.zzd = 2;
            zzfmp.zza().zzh(zza(), this.zza, str);
        }
    }

    public void zzi(zzflp zzflpVar, zzfln zzflnVar) {
        zzj(zzflpVar, zzflnVar, null);
    }

    public final void zzk(boolean z) {
        if (zzp()) {
            zzfmp.zza().zzi(zza(), this.zza, true != z ? "backgrounded" : "foregrounded");
        }
    }

    public final void zzl(float f) {
        zzfmp.zza().zze(zza(), this.zza, f);
    }

    public final void zzm(boolean z) {
        if (zzp()) {
            zzfmp.zza().zzg(zza(), this.zza, true != z ? "unlocked" : "locked");
        }
    }

    public final void zzn(WebView webView) {
        this.zzb = new zzfoa(webView);
    }

    public void zzo() {
    }

    public final boolean zzp() {
        return this.zzb.get() != 0;
    }

    public final void zzj(zzflp zzflpVar, zzfln zzflnVar, JSONObject jSONObject) {
        String strZzh = zzflpVar.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfne.zze(jSONObject2, "environment", "app");
        zzfne.zze(jSONObject2, "adSessionType", zzflnVar.zzd());
        JSONObject jSONObject3 = new JSONObject();
        zzfne.zze(jSONObject3, "deviceType", Build.MANUFACTURER + "; " + Build.MODEL);
        zzfne.zze(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfne.zze(jSONObject3, "os", "Android");
        zzfne.zze(jSONObject2, "deviceInfo", jSONObject3);
        zzfne.zze(jSONObject2, "deviceCategory", zzfnd.zza().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(yzwzcWHcnH.XKJtBpvZUiW);
        jSONArray.put("vlid");
        zzfne.zze(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfne.zze(jSONObject4, "partnerName", zzflnVar.zze().zzb());
        zzfne.zze(jSONObject4, "partnerVersion", zzflnVar.zze().zzc());
        zzfne.zze(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfne.zze(jSONObject5, "libraryVersion", "1.5.2-google_20241009");
        zzfne.zze(jSONObject5, "appId", zzfmn.zzb().zza().getApplicationContext().getPackageName());
        zzfne.zze(jSONObject2, "app", jSONObject5);
        if (zzflnVar.zzf() != null) {
            zzfne.zze(jSONObject2, "contentUrl", zzflnVar.zzf());
        }
        if (zzflnVar.zzg() != null) {
            zzfne.zze(jSONObject2, "customReferenceData", zzflnVar.zzg());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzflnVar.zzh().iterator();
        if (!it.hasNext()) {
            zzfmp.zza().zzj(zza(), strZzh, jSONObject2, jSONObject6, jSONObject);
        } else {
            throw null;
        }
    }
}
