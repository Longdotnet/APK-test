package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzcnj implements zzbop {
    private final Context zza;
    private final zzayz zzb;
    private final PowerManager zzc;

    public zzcnj(Context context, zzayz zzayzVar) {
        this.zza = context;
        this.zzb = zzayzVar;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* JADX WARN: Code duplicated, block: B:13:0x00ba  */
    @Override // com.google.android.gms.internal.ads.zzbop
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final JSONObject zzb(zzcnm zzcnmVar) {
        float f;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzazc zzazcVar = zzcnmVar.zzf;
        if (zzazcVar == null) {
            jSONObject = new JSONObject();
        } else {
            zzayz zzayzVar = this.zzb;
            if (zzayzVar.zzd() == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            boolean z = zzazcVar.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObjectPut = jSONObject3.put("afmaVersion", zzayzVar.zzb()).put("activeViewJSON", zzayzVar.zzd()).put("timestamp", zzcnmVar.zzd).put("adFormat", zzayzVar.zza()).put("hashCode", zzayzVar.zzc()).put("isMraid", false).put("isStopped", false).put("isPaused", zzcnmVar.zzb).put("isNative", zzayzVar.zze()).put("isScreenOn", this.zzc.isInteractive());
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            JSONObject jSONObjectPut2 = jSONObjectPut.put("appMuted", zzvVar.zzj.zze()).put("appVolume", zzvVar.zzj.zza());
            Context context = this.zza;
            AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
            if (audioManager == null) {
                f = 0.0f;
            } else {
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                int streamVolume = audioManager.getStreamVolume(3);
                if (streamMaxVolume != 0) {
                    f = streamVolume / streamMaxVolume;
                } else {
                    f = 0.0f;
                }
            }
            jSONObjectPut2.put("deviceVolume", f);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            JSONObject jSONObjectPut3 = jSONObject3.put("windowVisibility", zzazcVar.zzb).put("isAttachedToWindow", z);
            JSONObject jSONObject4 = new JSONObject();
            Rect rect = zzazcVar.zzc;
            JSONObject jSONObjectPut4 = jSONObjectPut3.put("viewBox", jSONObject4.put("top", rect.top).put("bottom", rect.bottom).put("left", rect.left).put("right", rect.right));
            JSONObject jSONObject5 = new JSONObject();
            Rect rect2 = zzazcVar.zzd;
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("adBox", jSONObject5.put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
            JSONObject jSONObject6 = new JSONObject();
            Rect rect3 = zzazcVar.zze;
            JSONObject jSONObjectPut6 = jSONObjectPut5.put("globalVisibleBox", jSONObject6.put("top", rect3.top).put("bottom", rect3.bottom).put("left", rect3.left).put("right", rect3.right)).put("globalVisibleBoxVisible", zzazcVar.zzf);
            JSONObject jSONObject7 = new JSONObject();
            Rect rect4 = zzazcVar.zzg;
            JSONObject jSONObjectPut7 = jSONObjectPut6.put("localVisibleBox", jSONObject7.put("top", rect4.top).put("bottom", rect4.bottom).put("left", rect4.left).put("right", rect4.right)).put("localVisibleBoxVisible", zzazcVar.zzh);
            JSONObject jSONObject8 = new JSONObject();
            Rect rect5 = zzazcVar.zzi;
            jSONObjectPut7.put("hitBox", jSONObject8.put("top", rect5.top).put("bottom", rect5.bottom).put("left", rect5.left).put("right", rect5.right)).put("screenDensity", displayMetrics.density);
            jSONObject3.put("isVisible", zzcnmVar.zza);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbC)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzazcVar.zzk;
                if (list != null) {
                    for (Rect rect6 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect6.top).put("bottom", rect6.bottom).put("left", rect6.left).put("right", rect6.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcnmVar.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
