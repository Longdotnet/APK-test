package com.google.firebase.auth.internal;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbe {
    public boolean zza;
    public String zzb;

    public static zzbe zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map mapZzb = zzaz.zzb(str);
        try {
            zzbe zzbeVar = new zzbe();
            Object obj = mapZzb.get("basicIntegrity");
            boolean z = false;
            if (obj != null && ((Boolean) obj).booleanValue()) {
                z = true;
            }
            zzbeVar.zza = z;
            String str2 = (String) mapZzb.get("advice");
            if (str2 == null) {
                str2 = "";
            }
            zzbeVar.zzb = str2;
            return zzbeVar;
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zza;
    }
}
