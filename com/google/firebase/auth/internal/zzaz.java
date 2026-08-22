package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzqx;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaz {
    public static final Logger zza = new Logger("JSONParser", new String[0]);

    public static ArrayList zza(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objZzd = jSONArray.get(i);
            if (objZzd instanceof JSONArray) {
                objZzd = zza((JSONArray) objZzd);
            } else if (objZzd instanceof JSONObject) {
                objZzd = zzd((JSONObject) objZzd);
            }
            arrayList.add(objZzd);
        }
        return arrayList;
    }

    public static Map zzb(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        List listZzd = com.google.android.gms.internal.p002firebaseauthapi.zzaf.zzb('.').zzd(str);
        int size = listZzd.size();
        Logger logger = zza;
        if (size < 2) {
            logger.e("Invalid idToken ".concat(String.valueOf(str)), new Object[0]);
            return new HashMap();
        }
        String str2 = (String) listZzd.get(1);
        try {
            ArrayMap arrayMapZzc = zzc(new String(str2 == null ? null : Base64.decode(str2, 11), "UTF-8"));
            return arrayMapZzc == null ? new HashMap() : arrayMapZzc;
        } catch (UnsupportedEncodingException e) {
            logger.e("Unable to decode token", e, new Object[0]);
            return new HashMap();
        }
    }

    public static ArrayMap zzc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return zzd(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzqx(e);
        }
    }

    public static ArrayMap zzd(JSONObject jSONObject) throws JSONException {
        ArrayMap arrayMap = new ArrayMap();
        Iterator itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String str = (String) itKeys.next();
            Object objZzd = jSONObject.get(str);
            if (objZzd instanceof JSONArray) {
                objZzd = zza((JSONArray) objZzd);
            } else if (objZzd instanceof JSONObject) {
                objZzd = zzd((JSONObject) objZzd);
            }
            arrayMap.put(str, objZzd);
        }
        return arrayMap;
    }
}
