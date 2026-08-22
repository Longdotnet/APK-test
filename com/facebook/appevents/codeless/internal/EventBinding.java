package com.facebook.appevents.codeless.internal;

import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class EventBinding {
    public final String activityName;
    public final String eventName;
    public final ArrayList parameters;
    public final ArrayList path;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public final class ActionType {
        public static final /* synthetic */ ActionType[] $VALUES = {new ActionType("CLICK", 0), new ActionType("SELECTED", 1), new ActionType("TEXT_CHANGED", 2)};

        /* JADX INFO: Fake field, exist only in values array */
        ActionType EF7;

        public static ActionType valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (ActionType) Enum.valueOf(ActionType.class, value);
        }

        public static ActionType[] values() {
            return (ActionType[]) Arrays.copyOf($VALUES, 3);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: loaded from: classes2.dex */
    public final class MappingMethod {
        public static final /* synthetic */ MappingMethod[] $VALUES = {new MappingMethod(MnHfHMYQDPUO.bmWDKzV, 0), new MappingMethod("INFERENCE", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        MappingMethod EF7;

        public static MappingMethod valueOf(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return (MappingMethod) Enum.valueOf(MappingMethod.class, value);
        }

        public static MappingMethod[] values() {
            return (MappingMethod[]) Arrays.copyOf($VALUES, 2);
        }
    }

    public EventBinding(String str, MappingMethod method, ActionType type, String str2, ArrayList arrayList, ArrayList arrayList2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(type, "type");
        this.eventName = str;
        this.path = arrayList;
        this.parameters = arrayList2;
        this.activityName = str5;
    }
}
