package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzbot {
    private static final Charset zzc = Charset.forName("UTF-8");
    public static final zzboq zza = new zzbos();
    public static final zzboo zzb = new zzboo() { // from class: com.google.android.gms.internal.ads.zzbor
        @Override // com.google.android.gms.internal.ads.zzboo
        public final Object zza(JSONObject jSONObject) {
            return zzbot.zza(jSONObject);
        }
    };

    public static /* synthetic */ InputStream zza(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
