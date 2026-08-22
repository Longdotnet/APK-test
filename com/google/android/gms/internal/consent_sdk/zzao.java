package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzao implements zzd {
    private final Application zza;
    private final zzaq zzb;
    private final zzl zzc;
    private final Executor zzd;

    public zzao(Application application, zzaq zzaqVar, zzl zzlVar, Executor executor) {
        this.zza = application;
        this.zzb = zzaqVar;
        this.zzd = executor;
        this.zzc = zzlVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final Executor zza() {
        return this.zzd;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025  */
    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final boolean zzb(String str, JSONObject jSONObject) {
        byte b;
        int iHashCode = str.hashCode();
        if (iHashCode != 94746189) {
            if (iHashCode == 113399775 && str.equals("write")) {
                b = 0;
            } else {
                b = -1;
            }
        } else if (str.equals("clear")) {
            b = 1;
        } else {
            b = -1;
        }
        if (b != 0) {
            if (b != 1) {
                return false;
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keys");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                Log.d("UserMessagingPlatform", "Action[clear]: wrong args.".concat(String.valueOf(jSONObject.toString())));
            } else {
                HashSet hashSet = new HashSet();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (TextUtils.isEmpty(strOptString)) {
                        Log.d("UserMessagingPlatform", "Action[clear]: empty key at index: " + i);
                    } else {
                        hashSet.add(strOptString);
                    }
                }
                zzcp.zzb(this.zza, hashSet);
            }
            return true;
        }
        zzco zzcoVar = new zzco(this.zza);
        Iterator itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String str2 = (String) itKeys.next();
            Object objOpt = jSONObject.opt(str2);
            Log.d("UserMessagingPlatform", "Writing to storage: [" + str2 + "] " + String.valueOf(objOpt));
            if (zzcoVar.zze(str2, objOpt)) {
                this.zzb.zzd().add(str2);
            } else {
                Log.d("UserMessagingPlatform", "Failed writing key: ".concat(String.valueOf(str2)));
            }
        }
        this.zzb.zzf();
        zzcoVar.zzc();
        Map mapZzb = zzcoVar.zzb();
        if (mapZzb.size() > 1) {
            this.zzc.zza(mapZzb);
            zzcoVar.zzd();
        }
        return true;
    }
}
