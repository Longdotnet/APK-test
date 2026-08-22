package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzzb implements zzxn {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzzb";
    private String zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzxn
    public final /* bridge */ /* synthetic */ zzxn zza(String str) throws zzvg {
        zzb(str);
        return this;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return !TextUtils.isEmpty(this.zzb);
    }

    public final zzzb zzb(String str) throws zzvg {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString("error"));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString("message");
            return this;
        } catch (NullPointerException | JSONException e) {
            Log.e(zza, "Failed to parse error for string [" + str + eoBKjVuj.ImkqiXIAT + e.getMessage());
            throw new zzvg(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Failed to parse error for string [", str, FETmZwrVHuasmL.UwISChCFZpu), e);
        }
    }
}
