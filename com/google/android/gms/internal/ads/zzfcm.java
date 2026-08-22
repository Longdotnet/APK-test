package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.common.util.Hex;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.AsyncTimeout;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfcm {
    public final List zza;
    public final zzfcd zzb;
    public final List zzc;
    public final Bundle zzd;

    public static zzfcm zza(Reader reader, Bundle bundle) {
        try {
            try {
                zzfcm zzfcmVar = new zzfcm(new JsonReader(reader), bundle);
                Hex.closeQuietly(reader);
                return zzfcmVar;
            } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e) {
                throw new zzfce("unable to parse ServerResponse", e);
            }
        } catch (Throwable th) {
            Hex.closeQuietly(reader);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public zzfcm(JsonReader jsonReader, Bundle bundle) throws IOException {
        this.zzd = bundle;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcq)).booleanValue() && bundle != null) {
            CoroutineAdapterKt$$ExternalSyntheticLambda0.m(com.google.android.gms.ads.internal.zzv.zza.zzl, bundle, zzdrr.SERVER_RESPONSE_PARSE_START.zza());
        }
        ?? EmptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzfcd zzfcdVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("responses".equals(strNextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(strNextName2)) {
                        EmptyList = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            EmptyList.add(new zzfca(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (strNextName2.equals("common")) {
                        zzfcdVar = new zzfcd(jsonReader);
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcr)).booleanValue() && bundle != null) {
                            bundle.putLong(zzdrr.NORMALIZATION_AD_RESPONSE_START.zza(), zzfcdVar.zzs);
                            bundle.putLong(zzdrr.NORMALIZATION_AD_RESPONSE_END.zza(), zzfcdVar.zzt);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (strNextName.equals(QTaELkFI.FOVgiHp)) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String strNextString = null;
                    JSONObject jSONObjectZzi = null;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        if ("name".equals(strNextName3)) {
                            strNextString = jsonReader.nextString();
                        } else if ("info".equals(strNextName3)) {
                            jSONObjectZzi = AsyncTimeout.Companion.zzi(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (strNextString != null) {
                        arrayList.add(new zzfcl(strNextString, jSONObjectZzi));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzc = arrayList;
        this.zza = EmptyList;
        this.zzb = zzfcdVar == null ? new zzfcd(new JsonReader(new StringReader("{}"))) : zzfcdVar;
    }
}
