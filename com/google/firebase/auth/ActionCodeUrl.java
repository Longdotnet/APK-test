package com.google.firebase.auth;

import android.net.Uri;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.auth.IJ.gZrKCJ;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ActionCodeUrl {
    private static final Map zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    public static ActionCodeUrl parseLink(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        try {
            return new ActionCodeUrl(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static String zzb(String str, String str2) {
        Uri uri = Uri.parse(str);
        try {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return uri.getQueryParameter(str2);
            }
            if (!queryParameterNames.contains("link")) {
                return null;
            }
            String queryParameter = uri.getQueryParameter("link");
            com.google.android.gms.common.internal.zzah.checkNotEmpty(queryParameter);
            return Uri.parse(queryParameter).getQueryParameter(str2);
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    public String getApiKey() {
        return this.zzb;
    }

    public String getCode() {
        return this.zzc;
    }

    public String getContinueUrl() {
        return this.zze;
    }

    public String getLanguageCode() {
        return this.zzf;
    }

    public int getOperation() {
        Map map = zza;
        if (map.containsKey(this.zzd)) {
            return ((Integer) map.get(this.zzd)).intValue();
        }
        return 3;
    }

    public final String zza() {
        return this.zzg;
    }

    static {
        HashMap map = new HashMap();
        map.put("recoverEmail", 2);
        map.put(gZrKCJ.EXNFIfCyHgZC, 0);
        map.put("signIn", 4);
        map.put("verifyEmail", 1);
        map.put("verifyBeforeChangeEmail", 5);
        map.put("revertSecondFactorAddition", 6);
        zza = Collections.unmodifiableMap(map);
    }

    private ActionCodeUrl(String str) {
        String strZzb = zzb(str, QTaELkFI.rvuPz);
        String strZzb2 = zzb(str, "oobCode");
        String strZzb3 = zzb(str, "mode");
        if (strZzb != null && strZzb2 != null && strZzb3 != null) {
            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzb);
            this.zzb = strZzb;
            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzb2);
            this.zzc = strZzb2;
            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzb3);
            this.zzd = strZzb3;
            this.zze = zzb(str, "continueUrl");
            this.zzf = zzb(str, "languageCode");
            this.zzg = zzb(str, "tenantId");
            return;
        }
        throw new IllegalArgumentException("apiKey, oobCode and mode are required in a valid action code URL");
    }
}
