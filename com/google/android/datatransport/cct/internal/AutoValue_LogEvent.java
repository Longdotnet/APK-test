package com.google.android.datatransport.cct.internal;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_LogEvent extends LogEvent {
    public final Integer eventCode;
    public final long eventTimeMs;
    public final long eventUptimeMs;
    public final AutoValue_NetworkConnectionInfo networkConnectionInfo;
    public final byte[] sourceExtension;
    public final String sourceExtensionJsonProto3;
    public final long timezoneOffsetSeconds;

    public AutoValue_LogEvent(long j, Integer num, long j2, byte[] bArr, String str, long j3, AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo) {
        this.eventTimeMs = j;
        this.eventCode = num;
        this.eventUptimeMs = j2;
        this.sourceExtension = bArr;
        this.sourceExtensionJsonProto3 = str;
        this.timezoneOffsetSeconds = j3;
        this.networkConnectionInfo = autoValue_NetworkConnectionInfo;
    }

    public final boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        AutoValue_LogEvent autoValue_LogEvent = (AutoValue_LogEvent) logEvent;
        if (this.eventTimeMs == autoValue_LogEvent.eventTimeMs && ((num = this.eventCode) != null ? num.equals(autoValue_LogEvent.eventCode) : autoValue_LogEvent.eventCode == null)) {
            if (this.eventUptimeMs == autoValue_LogEvent.eventUptimeMs) {
                if (Arrays.equals(this.sourceExtension, logEvent instanceof AutoValue_LogEvent ? ((AutoValue_LogEvent) logEvent).sourceExtension : autoValue_LogEvent.sourceExtension)) {
                    String str = autoValue_LogEvent.sourceExtensionJsonProto3;
                    String str2 = this.sourceExtensionJsonProto3;
                    if (str2 != null ? str2.equals(str) : str == null) {
                        if (this.timezoneOffsetSeconds == autoValue_LogEvent.timezoneOffsetSeconds) {
                            AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo = autoValue_LogEvent.networkConnectionInfo;
                            AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo2 = this.networkConnectionInfo;
                            if (autoValue_NetworkConnectionInfo2 == null) {
                                if (autoValue_NetworkConnectionInfo == null) {
                                    return true;
                                }
                            } else if (autoValue_NetworkConnectionInfo2.equals(autoValue_NetworkConnectionInfo)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.eventTimeMs;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.eventCode;
        int iHashCode = (i ^ (num == null ? 0 : num.hashCode())) * 1000003;
        long j2 = this.eventUptimeMs;
        int iHashCode2 = (((iHashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.sourceExtension)) * 1000003;
        String str = this.sourceExtensionJsonProto3;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j3 = this.timezoneOffsetSeconds;
        int i2 = (iHashCode3 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        AutoValue_NetworkConnectionInfo autoValue_NetworkConnectionInfo = this.networkConnectionInfo;
        return i2 ^ (autoValue_NetworkConnectionInfo != null ? autoValue_NetworkConnectionInfo.hashCode() : 0);
    }

    public final String toString() {
        return "LogEvent{eventTimeMs=" + this.eventTimeMs + ", eventCode=" + this.eventCode + ", eventUptimeMs=" + this.eventUptimeMs + ", sourceExtension=" + Arrays.toString(this.sourceExtension) + ", sourceExtensionJsonProto3=" + this.sourceExtensionJsonProto3 + ", timezoneOffsetSeconds=" + this.timezoneOffsetSeconds + ", networkConnectionInfo=" + this.networkConnectionInfo + "}";
    }
}
