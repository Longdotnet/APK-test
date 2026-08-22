package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
public final class ProtobufToStringOutput {
    private static final ThreadLocal<OutputMode> outputMode = new ThreadLocal<OutputMode>() { // from class: com.google.protobuf.ProtobufToStringOutput.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public OutputMode initialValue() {
            return OutputMode.TEXT_FORMAT;
        }
    };

    public enum OutputMode {
        DEBUG_FORMAT,
        TEXT_FORMAT
    }

    private ProtobufToStringOutput() {
    }

    public static void callWithDebugFormat(Runnable runnable) {
        callWithSpecificFormat(runnable, OutputMode.DEBUG_FORMAT);
    }

    private static void callWithSpecificFormat(Runnable runnable, OutputMode outputMode2) {
        OutputMode outputMode3 = setOutputMode(outputMode2);
        try {
            runnable.run();
        } finally {
            setOutputMode(outputMode3);
        }
    }

    public static void callWithTextFormat(Runnable runnable) {
        callWithSpecificFormat(runnable, OutputMode.TEXT_FORMAT);
    }

    private static OutputMode setOutputMode(OutputMode outputMode2) {
        ThreadLocal<OutputMode> threadLocal = outputMode;
        OutputMode outputMode3 = threadLocal.get();
        threadLocal.set(outputMode2);
        return outputMode3;
    }

    public static boolean shouldOutputDebugFormat() {
        return outputMode.get() == OutputMode.DEBUG_FORMAT;
    }
}
