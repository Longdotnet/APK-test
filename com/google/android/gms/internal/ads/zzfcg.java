package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfcg {
    private zzfcg(long j, int[] iArr) {
    }

    public static zzfyq zza(JsonReader jsonReader) {
        int i = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            zzfyq zzfyqVarZzn = zzfyq.zzn();
            jsonReader.beginObject();
            zzfcg zzfcgVar = null;
            Long lValueOf = null;
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                if (Objects.equals(strNextName, "id")) {
                    lValueOf = Long.valueOf(jsonReader.nextLong());
                } else if (Objects.equals(strNextName, RDFWIi.amhDMU)) {
                    zzfyn zzfynVar2 = new zzfyn();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        zzfynVar2.zzf(Integer.valueOf(jsonReader.nextInt()));
                    }
                    jsonReader.endArray();
                    zzfyqVarZzn = zzfynVar2.zzi();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (lValueOf != null && !zzfyqVarZzn.isEmpty()) {
                long jLongValue = lValueOf.longValue();
                int[] iArr = new int[zzfyqVarZzn.size()];
                for (int i2 = 0; i2 < zzfyqVarZzn.size(); i2++) {
                    iArr[i2] = ((Integer) zzfyqVarZzn.get(i2)).intValue();
                }
                zzfcgVar = new zzfcg(jLongValue, iArr);
            }
            if (zzfcgVar != null) {
                zzfynVar.zzf(zzfcgVar);
            }
        }
        jsonReader.endArray();
        return zzfynVar.zzi();
    }
}
