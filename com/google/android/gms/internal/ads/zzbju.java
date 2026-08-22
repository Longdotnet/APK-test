package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbju implements zzbkf {
    @Override // com.google.android.gms.internal.ads.zzbkf
    public final void zza(Object obj, Map map) {
        zzcfg zzcfgVar = (zzcfg) obj;
        try {
            JSONObject jSONObject = new JSONObject((String) map.get("args"));
            Iterator itKeys = jSONObject.keys();
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(zzcfgVar.getContext()).edit();
            while (itKeys.hasNext()) {
                String str = (String) itKeys.next();
                Object obj2 = jSONObject.get(str);
                if (obj2 instanceof Integer) {
                    editorEdit.putInt(str, ((Integer) obj2).intValue());
                } else if (obj2 instanceof Long) {
                    editorEdit.putLong(str, ((Long) obj2).longValue());
                } else if (obj2 instanceof Double) {
                    editorEdit.putFloat(str, ((Double) obj2).floatValue());
                } else if (obj2 instanceof Float) {
                    editorEdit.putFloat(str, ((Float) obj2).floatValue());
                } else if (obj2 instanceof Boolean) {
                    editorEdit.putBoolean(str, ((Boolean) obj2).booleanValue());
                } else if (obj2 instanceof String) {
                    editorEdit.putString(str, (String) obj2);
                }
            }
            editorEdit.apply();
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "GMSG write local storage KV pairs handler");
        }
    }
}
