package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class zzfcc {
    private String zza;

    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public zzfcc(JsonReader jsonReader) throws IOException {
        byte b;
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            int iHashCode = strNextName.hashCode();
            if (iHashCode != -1724546052) {
                if (iHashCode == 3059181 && strNextName.equals("code")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (strNextName.equals("description")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                jsonReader.nextInt();
            } else if (b != 1) {
                jsonReader.skipValue();
            } else {
                strNextString = jsonReader.nextString();
            }
        }
        jsonReader.endObject();
        this.zza = strNextString;
    }

    public final String zza() {
        return this.zza;
    }
}
