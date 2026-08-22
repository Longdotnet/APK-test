package com.google.android.gms.internal.ads;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes.dex */
public final class zzare extends zzaqr {
    public zzare() {
        throw null;
    }

    public static List zzb(Map map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new zzapv((String) entry.getKey(), (String) it.next()));
                }
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzaqr
    public final zzarb zza(zzaqd zzaqdVar, Map map) throws Throwable {
        String strZzk = zzaqdVar.zzk();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(zzaqdVar.zzl());
        URL url = new URL(strZzk);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int iZzb = zzaqdVar.zzb();
        httpURLConnection.setConnectTimeout(iZzb);
        httpURLConnection.setReadTimeout(iZzb);
        boolean z = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url.getProtocol());
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            if (zzaqdVar.zza() != 0) {
                httpURLConnection.setRequestMethod("POST");
                byte[] bArrZzx = zzaqdVar.zzx();
                if (bArrZzx != null) {
                    httpURLConnection.setDoOutput(true);
                    if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                    }
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream.write(bArrZzx);
                    dataOutputStream.close();
                }
            } else {
                httpURLConnection.setRequestMethod("GET");
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            zzaqdVar.zza();
            if ((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) {
                zzarb zzarbVar = new zzarb(responseCode, zzb(httpURLConnection.getHeaderFields()), -1, null);
                httpURLConnection.disconnect();
                return zzarbVar;
            }
            try {
                return new zzarb(responseCode, zzb(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new zzarc(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public zzare(zzard zzardVar, SSLSocketFactory sSLSocketFactory) {
    }
}
