package com.facebook.appevents.cloudbridge;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class AppEventType {
    public static final /* synthetic */ AppEventType[] $VALUES;
    public static final AppEventType CUSTOM;
    public static final AppEventType MOBILE_APP_INSTALL;
    public static final AppEventType OTHER;

    static {
        AppEventType appEventType = new AppEventType("MOBILE_APP_INSTALL", 0);
        MOBILE_APP_INSTALL = appEventType;
        AppEventType appEventType2 = new AppEventType("CUSTOM", 1);
        CUSTOM = appEventType2;
        AppEventType appEventType3 = new AppEventType("OTHER", 2);
        OTHER = appEventType3;
        $VALUES = new AppEventType[]{appEventType, appEventType2, appEventType3};
    }

    public static AppEventType valueOf(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (AppEventType) Enum.valueOf(AppEventType.class, value);
    }

    public static AppEventType[] values() {
        return (AppEventType[]) Arrays.copyOf($VALUES, 3);
    }
}
