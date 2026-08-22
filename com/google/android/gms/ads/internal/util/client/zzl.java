package com.google.android.gms.ads.internal.util.client;

import android.util.JsonWriter;
import androidx.sqlite.db.SimpleSQLiteQuery;
import com.android.billingclient.api.zzda;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class zzl {
    public static boolean zzc = false;
    public static boolean zzd = false;
    public final List zzg;
    public static final Object zzb = new Object();
    public static final HashSet zzf = new HashSet(Arrays.asList(new String[0]));

    public zzl() {
        this.zzg = !zzk() ? new ArrayList() : Arrays.asList("network_request_".concat(String.valueOf(UUID.randomUUID().toString())));
    }

    public static boolean zzk() {
        boolean z;
        synchronized (zzb) {
            try {
                z = false;
                if (zzc && zzd) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public static void zzr(JsonWriter jsonWriter, Map map) {
        if (map == null) {
            return;
        }
        jsonWriter.name("headers").beginArray();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!zzf.contains(str)) {
                if (!(entry.getValue() instanceof List)) {
                    if (!(entry.getValue() instanceof String)) {
                        zzo.zzg("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                        break;
                    }
                    jsonWriter.beginObject();
                    jsonWriter.name("name").value(str);
                    jsonWriter.name(FirebaseAnalytics.Param.VALUE).value((String) entry.getValue());
                    jsonWriter.endObject();
                } else {
                    for (String str2 : (List) entry.getValue()) {
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(str);
                        jsonWriter.name(FirebaseAnalytics.Param.VALUE).value(str2);
                        jsonWriter.endObject();
                    }
                }
            }
        }
        jsonWriter.endArray();
    }

    public final void zzc(HttpURLConnection httpURLConnection, byte[] bArr) {
        if (zzk()) {
            zzn("onNetworkRequest", new Dispatcher(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), httpURLConnection.getRequestProperties() == null ? null : new HashMap(httpURLConnection.getRequestProperties()), bArr));
        }
    }

    public final void zze(HttpURLConnection httpURLConnection, int i) {
        if (zzk()) {
            String responseMessage = null;
            zzn("onNetworkResponse", new zzda(i, httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields())));
            if (i < 200 || i >= 300) {
                try {
                    responseMessage = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    zzo.zzj("Can not get error message from error HttpURLConnection\n".concat(String.valueOf(e.getMessage())));
                }
                zzn("onNetworkRequestError", new SimpleSQLiteQuery(responseMessage));
            }
        }
    }

    public final void zzn(String str, zzk zzkVar) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(System.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            Iterator it = this.zzg.iterator();
            while (it.hasNext()) {
                jsonWriter.value((String) it.next());
            }
            jsonWriter.endArray();
            zzkVar.zza(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzo.zzh("unable to log", e);
        }
        String string = stringWriter.toString();
        synchronized (zzl.class) {
            try {
                zzo.zzi("GMA Debug BEGIN");
                int i = 0;
                while (i < string.length()) {
                    int i2 = i + 4000;
                    zzo.zzi("GMA Debug CONTENT ".concat(String.valueOf(string.substring(i, Math.min(i2, string.length())))));
                    i = i2;
                }
                zzo.zzi("GMA Debug FINISH");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
