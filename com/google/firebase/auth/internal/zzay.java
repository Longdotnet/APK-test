package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzqx;
import com.google.firebase.auth.GetTokenResult;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzay {
    public static final Logger zza = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zza(String str) {
        Map map;
        try {
            map = zzaz.zzb(str);
        } catch (zzqx e) {
            zza.e("Error parsing token claims", e, new Object[0]);
            map = new HashMap();
        }
        return new GetTokenResult(str, map);
    }
}
