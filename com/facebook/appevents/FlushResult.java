package com.facebook.appevents;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class FlushResult {
    public static final /* synthetic */ FlushResult[] $VALUES;
    public static final FlushResult NO_CONNECTIVITY;
    public static final FlushResult SERVER_ERROR;
    public static final FlushResult SUCCESS;

    static {
        FlushResult flushResult = new FlushResult("SUCCESS", 0);
        SUCCESS = flushResult;
        FlushResult flushResult2 = new FlushResult("SERVER_ERROR", 1);
        SERVER_ERROR = flushResult2;
        FlushResult flushResult3 = new FlushResult("NO_CONNECTIVITY", 2);
        NO_CONNECTIVITY = flushResult3;
        $VALUES = new FlushResult[]{flushResult, flushResult2, flushResult3, new FlushResult("UNKNOWN_ERROR", 3)};
    }

    public static FlushResult valueOf(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (FlushResult) Enum.valueOf(FlushResult.class, value);
    }

    public static FlushResult[] values() {
        return (FlushResult[]) Arrays.copyOf($VALUES, 4);
    }
}
