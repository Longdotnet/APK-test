package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdvp implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final JSONObject zza = new JSONObject();
    private List zzb;

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str != null && this.zzb.contains(str)) {
            try {
                Object obj = sharedPreferences.getAll().get(str);
                if (obj == null) {
                    this.zza.remove(str);
                } else {
                    this.zza.put(str, obj);
                }
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzv.zza.zzi.zzv(e, "InspectorSharedPreferenceCollector.onSharedPreferenceChanged");
            }
        }
    }

    public final JSONObject zza() {
        return this.zza;
    }

    public final void zzb(SharedPreferences sharedPreferences, List list) {
        this.zzb = list;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            onSharedPreferenceChanged(sharedPreferences, (String) it.next());
        }
    }
}
