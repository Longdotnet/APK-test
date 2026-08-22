package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Base64;
import com.google.android.gms.common.internal.zzah;
import java.io.UnsupportedEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaaa {
    public static long zza(String str) {
        zzah.checkNotEmpty(str);
        List listZzd = zzaf.zzb('.').zzd(str);
        if (listZzd.size() < 2) {
            throw new RuntimeException("Invalid idToken ".concat(String.valueOf(str)));
        }
        String str2 = (String) listZzd.get(1);
        try {
            zzaab zzaabVarZza = zzaab.zza(new String(str2 == null ? null : Base64.decode(str2, 11), "UTF-8"));
            return zzaabVarZza.zzb().longValue() - zzaabVarZza.zzc().longValue();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unable to decode token", e);
        }
    }
}
