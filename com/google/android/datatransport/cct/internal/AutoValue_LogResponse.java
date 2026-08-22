package com.google.android.datatransport.cct.internal;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_LogResponse {
    public final long nextRequestWaitMillis;

    public AutoValue_LogResponse(long j) {
        this.nextRequestWaitMillis = j;
    }

    public static AutoValue_LogResponse fromJson(BufferedReader bufferedReader) throws IOException {
        JsonReader jsonReader = new JsonReader(bufferedReader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        AutoValue_LogResponse autoValue_LogResponse = new AutoValue_LogResponse(Long.parseLong(jsonReader.nextString()));
                        jsonReader.close();
                        return autoValue_LogResponse;
                    }
                    AutoValue_LogResponse autoValue_LogResponse2 = new AutoValue_LogResponse(jsonReader.nextLong());
                    jsonReader.close();
                    return autoValue_LogResponse2;
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } catch (Throwable th) {
            jsonReader.close();
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_LogResponse) {
            return this.nextRequestWaitMillis == ((AutoValue_LogResponse) obj).nextRequestWaitMillis;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((int) ((j >>> 32) ^ j)) ^ 1000003;
    }

    public final String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }
}
