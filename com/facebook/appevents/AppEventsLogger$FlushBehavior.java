package com.facebook.appevents;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class AppEventsLogger$FlushBehavior {
    public static final /* synthetic */ AppEventsLogger$FlushBehavior[] $VALUES;
    public static final AppEventsLogger$FlushBehavior AUTO;
    public static final AppEventsLogger$FlushBehavior EXPLICIT_ONLY;

    static {
        AppEventsLogger$FlushBehavior appEventsLogger$FlushBehavior = new AppEventsLogger$FlushBehavior("AUTO", 0);
        AUTO = appEventsLogger$FlushBehavior;
        AppEventsLogger$FlushBehavior appEventsLogger$FlushBehavior2 = new AppEventsLogger$FlushBehavior("EXPLICIT_ONLY", 1);
        EXPLICIT_ONLY = appEventsLogger$FlushBehavior2;
        $VALUES = new AppEventsLogger$FlushBehavior[]{appEventsLogger$FlushBehavior, appEventsLogger$FlushBehavior2};
    }

    public static AppEventsLogger$FlushBehavior valueOf(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (AppEventsLogger$FlushBehavior) Enum.valueOf(AppEventsLogger$FlushBehavior.class, value);
    }

    public static AppEventsLogger$FlushBehavior[] values() {
        return (AppEventsLogger$FlushBehavior[]) Arrays.copyOf($VALUES, 2);
    }
}
