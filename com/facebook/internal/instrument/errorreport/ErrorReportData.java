package com.facebook.internal.instrument.errorreport;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ErrorReportData {
    public String errorMessage;
    public String filename;
    public Long timestamp;

    public ErrorReportData(String str) {
        Long lValueOf = Long.valueOf(System.currentTimeMillis() / ((long) 1000));
        this.timestamp = lValueOf;
        this.errorMessage = str;
        StringBuffer stringBuffer = new StringBuffer("error_log_");
        stringBuffer.append(lValueOf.longValue());
        stringBuffer.append(".json");
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuffer()\n            .append(InstrumentUtility.ERROR_REPORT_PREFIX)\n            .append(timestamp as Long)\n            .append(\".json\")\n            .toString()");
        this.filename = string;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            Long l = this.timestamp;
            if (l != null) {
                jSONObject.put("timestamp", l);
            }
            jSONObject.put("error_message", this.errorMessage);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return super.toString();
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "params.toString()");
        return string;
    }
}
