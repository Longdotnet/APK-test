package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzbsu {
    private final zzcfg zza;
    private final String zzb;

    public zzbsu(zzcfg zzcfgVar, String str) {
        this.zza = zzcfgVar;
        this.zzb = str;
    }

    public final void zzg(int i, int i2, int i3, int i4) {
        try {
            this.zza.zze("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzh(String str) {
        try {
            JSONObject jSONObjectPut = new JSONObject().put("message", str).put("action", this.zzb);
            zzcfg zzcfgVar = this.zza;
            if (zzcfgVar != null) {
                zzcfgVar.zze("onError", jSONObjectPut);
            }
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzi(String str) {
        try {
            this.zza.zze("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzj(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zza.zze("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", f).put("rotation", i5));
        } catch (JSONException e) {
            int i6 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while obtaining screen information.", e);
        }
    }

    public final void zzk(int i, int i2, int i3, int i4) {
        try {
            this.zza.zze("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            int i5 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzl(String str) {
        try {
            this.zza.zze("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while dispatching state change.", e);
        }
    }
}
