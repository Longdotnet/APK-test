package com.google.android.gms.internal.ads;

import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.firebase.inject.PVS.jIKWv;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcgr {
    private static final Pattern zza = Pattern.compile(jIKWv.JfjWAvStms, 2);
    private static final Pattern zzb = Pattern.compile("^\\uFEFF?\\s*(\\s*<!--([^-]|(?!-->))*-->)*?\\s*<!DOCTYPE[^>]*>", 2);

    public static String zzb(String str, String... strArr) {
        String str2;
        StringBuilder sb = new StringBuilder();
        Matcher matcher = zza.matcher(str);
        if (matcher.find()) {
            int iEnd = matcher.end();
            sb.append(str.substring(0, iEnd));
            String str3 = strArr[0];
            if (str3 != null) {
                sb.append(str3);
            }
            sb.append(str.substring(iEnd));
        } else {
            if (!zzb.matcher(str).find() && (str2 = strArr[0]) != null) {
                sb.append(str2);
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static String zza(zzfca zzfcaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzfC)).booleanValue() && zzfcaVar.zzT) {
            zzfcz zzfczVar = zzfcaVar.zzV;
            if (zzfczVar.zzb() && zzfcaVar.zzb != 4) {
                zzedd zzeddVar = zzfczVar.zzc() == 1 ? zzedd.VIDEO : zzedd.HTML_DISPLAY;
                String str = zzfcaVar.zzal;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("creativeType", zzeddVar.toString());
                    jSONObject.put("contentUrl", str);
                    return "<script>Object.defineProperty(window,'GOOG_OMID_JAVASCRIPT_SESSION_SERVICE_ENV',{get:function(){return " + jSONObject.toString() + nYVxXTZQ.DfasO;
                } catch (JSONException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to build OMID ENV JSON", e);
                }
            }
        }
        return null;
    }
}
