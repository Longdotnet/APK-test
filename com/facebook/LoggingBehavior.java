package com.facebook;

import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class LoggingBehavior {
    public static final /* synthetic */ LoggingBehavior[] $VALUES;
    public static final LoggingBehavior APP_EVENTS;
    public static final LoggingBehavior DEVELOPER_ERRORS;
    public static final LoggingBehavior GRAPH_API_DEBUG_WARNING;
    public static final LoggingBehavior INCLUDE_ACCESS_TOKENS;
    public static final LoggingBehavior REQUESTS;

    static {
        LoggingBehavior loggingBehavior = new LoggingBehavior("REQUESTS", 0);
        REQUESTS = loggingBehavior;
        LoggingBehavior loggingBehavior2 = new LoggingBehavior("INCLUDE_ACCESS_TOKENS", 1);
        INCLUDE_ACCESS_TOKENS = loggingBehavior2;
        LoggingBehavior loggingBehavior3 = new LoggingBehavior("INCLUDE_RAW_RESPONSES", 2);
        LoggingBehavior loggingBehavior4 = new LoggingBehavior("CACHE", 3);
        LoggingBehavior loggingBehavior5 = new LoggingBehavior("APP_EVENTS", 4);
        APP_EVENTS = loggingBehavior5;
        LoggingBehavior loggingBehavior6 = new LoggingBehavior(YcVWhnLsj.MbcGrhSqxwxYp, 5);
        DEVELOPER_ERRORS = loggingBehavior6;
        LoggingBehavior loggingBehavior7 = new LoggingBehavior("GRAPH_API_DEBUG_WARNING", 6);
        GRAPH_API_DEBUG_WARNING = loggingBehavior7;
        $VALUES = new LoggingBehavior[]{loggingBehavior, loggingBehavior2, loggingBehavior3, loggingBehavior4, loggingBehavior5, loggingBehavior6, loggingBehavior7, new LoggingBehavior("GRAPH_API_DEBUG_INFO", 7)};
    }

    public static LoggingBehavior valueOf(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (LoggingBehavior) Enum.valueOf(LoggingBehavior.class, value);
    }

    public static LoggingBehavior[] values() {
        return (LoggingBehavior[]) Arrays.copyOf($VALUES, 8);
    }
}
