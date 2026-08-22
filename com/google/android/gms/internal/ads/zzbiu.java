package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;
import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbiu implements zzbkf {
    private final zzbiv zza;

    public zzbiu(zzbiv zzbivVar) {
        this.zza = zzbivVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        if (this.zza == null) {
            return;
        }
        String str = (String) map.get("name");
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleZza = null;
        if (map.containsKey("info")) {
            try {
                bundleZza = AsyncTimeout.Companion.zza(new JSONObject((String) map.get("info")));
            } catch (JSONException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Failed to convert ad metadata to JSON.", e);
            }
        }
        if (bundleZza != null) {
            this.zza.zza(str, bundleZza);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to convert ad metadata to Bundle.");
        }
    }
}
