package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbcp extends zzbcv {
    public zzbcp(int i, String str, Boolean bool, Boolean bool2) {
        super(i, str, bool, bool2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(zzm(), ((Boolean) zzl()).booleanValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzm())) ? Boolean.valueOf(bundle.getBoolean("com.google.android.gms.ads.flag.".concat(zzm()))) : (Boolean) zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(zzm(), ((Boolean) zzl()).booleanValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putBoolean(zzm(), ((Boolean) obj).booleanValue());
    }
}
