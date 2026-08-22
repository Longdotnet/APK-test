package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class zzbcq extends zzbcv {
    public zzbcq(int i, String str, Integer num, Integer num2) {
        super(1, str, num, num2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zza(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(zzm(), ((Integer) zzl()).intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zzm())) ? Integer.valueOf(bundle.getInt("com.google.android.gms.ads.flag.".concat(zzm()))) : (Integer) zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ Object zzc(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(zzm(), ((Integer) zzl()).intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbcv
    public final /* bridge */ /* synthetic */ void zzd(SharedPreferences.Editor editor, Object obj) {
        editor.putInt(zzm(), ((Integer) obj).intValue());
    }
}
