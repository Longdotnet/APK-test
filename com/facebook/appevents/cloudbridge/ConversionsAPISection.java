package com.facebook.appevents.cloudbridge;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class ConversionsAPISection {
    public static final /* synthetic */ ConversionsAPISection[] $VALUES;
    public static final ConversionsAPISection APP_DATA;
    public static final ConversionsAPISection CUSTOM_DATA;
    public static final ConversionsAPISection USER_DATA;

    static {
        ConversionsAPISection conversionsAPISection = new ConversionsAPISection("USER_DATA", 0);
        USER_DATA = conversionsAPISection;
        ConversionsAPISection conversionsAPISection2 = new ConversionsAPISection("APP_DATA", 1);
        APP_DATA = conversionsAPISection2;
        ConversionsAPISection conversionsAPISection3 = new ConversionsAPISection("CUSTOM_DATA", 2);
        CUSTOM_DATA = conversionsAPISection3;
        $VALUES = new ConversionsAPISection[]{conversionsAPISection, conversionsAPISection2, conversionsAPISection3, new ConversionsAPISection("CUSTOM_EVENTS", 3)};
    }

    public static ConversionsAPISection valueOf(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (ConversionsAPISection) Enum.valueOf(ConversionsAPISection.class, value);
    }

    public static ConversionsAPISection[] values() {
        return (ConversionsAPISection[]) Arrays.copyOf($VALUES, 4);
    }
}
