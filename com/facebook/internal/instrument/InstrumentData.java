package com.facebook.internal.instrument;

import android.os.Build;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class InstrumentData {
    public String appVersion;
    public String cause;
    public JSONArray featureNames;
    public String filename;
    public String stackTrace;
    public Long timestamp;
    public Type type;

    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            iArr[1] = 1;
            iArr[2] = 2;
            iArr[3] = 3;
            iArr[4] = 4;
            iArr[5] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final boolean isValid() {
        Type type = this.type;
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        Long l = this.timestamp;
        if (i != 1) {
            String str = this.stackTrace;
            if (i != 2) {
                if ((i != 3 && i != 4 && i != 5) || str == null || l == null) {
                    return false;
                }
            } else if (str == null || this.cause == null || l == null) {
                return false;
            }
        } else if (this.featureNames == null || l == null) {
            return false;
        }
        return true;
    }

    public final void save() {
        if (isValid()) {
            Headers.Companion.writeFile(this.filename, toString());
        }
    }

    public final String toString() {
        Type type = this.type;
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        Long l = this.timestamp;
        JSONObject jSONObject = null;
        try {
            if (i == 1) {
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray = this.featureNames;
                if (jSONArray != null) {
                    jSONObject2.put("feature_names", jSONArray);
                }
                if (l != null) {
                    jSONObject2.put("timestamp", l);
                }
                jSONObject = jSONObject2;
            } else if (i == 2 || i == 3 || i == 4 || i == 5) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("device_os_version", Build.VERSION.RELEASE);
                jSONObject3.put("device_model", Build.MODEL);
                String str = this.appVersion;
                if (str != null) {
                    jSONObject3.put("app_version", str);
                }
                if (l != null) {
                    jSONObject3.put("timestamp", l);
                }
                String str2 = this.cause;
                if (str2 != null) {
                    jSONObject3.put("reason", str2);
                }
                String str3 = this.stackTrace;
                if (str3 != null) {
                    jSONObject3.put("callstack", str3);
                }
                if (type != null) {
                    jSONObject3.put("type", type);
                }
                jSONObject = jSONObject3;
            }
        } catch (JSONException unused) {
        }
        if (jSONObject == null) {
            String string = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONObject().toString()");
            return string;
        }
        String string2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "params.toString()");
        return string2;
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class Type extends Enum {
        public static final /* synthetic */ Type[] $VALUES;
        public static final Type Analysis;
        public static final Type AnrReport;
        public static final Type CrashReport;
        public static final Type CrashShield;
        public static final Type ThreadCheck;
        public static final Type Unknown;

        static {
            Type type = new Type("Unknown", 0);
            Unknown = type;
            Type type2 = new Type("Analysis", 1);
            Analysis = type2;
            Type type3 = new Type("AnrReport", 2);
            AnrReport = type3;
            Type type4 = new Type("CrashReport", 3);
            CrashReport = type4;
            Type type5 = new Type("CrashShield", 4);
            CrashShield = type5;
            Type type6 = new Type("ThreadCheck", 5);
            ThreadCheck = type6;
            $VALUES = new Type[]{type, type2, type3, type4, type5, type6};
        }

        public static Type valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (Type) Enum.valueOf(Type.class, value);
        }

        public static Type[] values() {
            return (Type[]) Arrays.copyOf($VALUES, 6);
        }

        @Override // java.lang.Enum
        public final String toString() {
            int iOrdinal = ordinal();
            if (iOrdinal == 1) {
                return MnHfHMYQDPUO.gsMgTXntQjo;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        if (iOrdinal != 5) {
                            return "Unknown";
                        }
                        return "ThreadCheck";
                    }
                    return "CrashShield";
                }
                return "CrashReport";
            }
            return "AnrReport";
        }
    }
}
