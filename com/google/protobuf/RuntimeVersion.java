package com.google.protobuf;

import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN;
    public static final int MAJOR = 4;
    private static final int MAX_WARNING_COUNT = 20;
    public static final int MINOR = 29;
    public static final RuntimeDomain OSS_DOMAIN;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 29;
    public static final int OSS_PATCH = 5;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 5;
    public static final String SUFFIX = "";
    private static final String VERSION_STRING;
    private static final Logger logger;
    static int majorWarningLoggedCount;
    static int minorWarningLoggedCount;

    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String str) {
            super(str);
        }
    }

    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    static {
        RuntimeDomain runtimeDomain = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = runtimeDomain;
        DOMAIN = runtimeDomain;
        majorWarningLoggedCount = 0;
        minorWarningLoggedCount = 0;
        VERSION_STRING = versionString(4, 29, 5, "");
        logger = Logger.getLogger(RuntimeVersion.class.getName());
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String str = System.getenv("TEMPORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        return str != null && str.equals("true");
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain runtimeDomain, int i, int i2, int i3, String str, String str2) {
        if (checkDisabled()) {
            return;
        }
        validateProtobufGencodeVersionImpl(runtimeDomain, i, i2, i3, str, str2);
    }

    private static String versionString(int i, int i2, int i3, String str) {
        return String.format("%d.%d.%d%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain runtimeDomain, int i, int i2, int i3, String str, String str2) {
        if (checkDisabled()) {
            return;
        }
        String strVersionString = versionString(i, i2, i3, str);
        if (i >= 0 && i2 >= 0 && i3 >= 0) {
            RuntimeDomain runtimeDomain2 = DOMAIN;
            if (runtimeDomain == runtimeDomain2) {
                if (i != 4) {
                    if (i == 3 && majorWarningLoggedCount < 20) {
                        Logger logger2 = logger;
                        StringBuilder sbM22m = CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m(" Protobuf gencode version ", strVersionString, " is exactly one major version older than the runtime version ", VERSION_STRING, MnHfHMYQDPUO.RwSxAHpp);
                        sbM22m.append(str2);
                        sbM22m.append(". Please update the gencode to avoid compatibility violations in the next runtime release.");
                        logger2.warning(sbM22m.toString());
                        majorWarningLoggedCount++;
                    } else {
                        throw new ProtobufRuntimeVersionException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m(FETmZwrVHuasmL.elfFoaJxcwIQkAQ, str2, ": gencode ", strVersionString, ", runtime "), VERSION_STRING, ". Same major version is required."));
                    }
                }
                if (29 >= i2 && (i2 != 29 || 5 >= i3)) {
                    if (str.equals("")) {
                        return;
                    }
                    throw new ProtobufRuntimeVersionException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading ", str2, ": gencode ", strVersionString, ", runtime "), VERSION_STRING, ". Version suffixes must be the same."));
                }
                throw new ProtobufRuntimeVersionException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(CoroutineAdapterKt$$ExternalSyntheticLambda0.m22m("Detected incompatible Protobuf Gencode/Runtime versions when loading ", str2, ": gencode ", strVersionString, ", runtime "), VERSION_STRING, ". Runtime version cannot be older than the linked gencode version."));
            }
            throw new ProtobufRuntimeVersionException("Detected mismatched Protobuf Gencode/Runtime domains when loading " + str2 + ": gencode " + runtimeDomain + ", runtime " + runtimeDomain2 + ". Cross-domain usage of Protobuf is not supported.");
        }
        throw new ProtobufRuntimeVersionException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("Invalid gencode version: ", strVersionString));
    }
}
