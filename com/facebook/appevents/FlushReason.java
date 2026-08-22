package com.facebook.appevents;

import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class FlushReason {
    public static final /* synthetic */ FlushReason[] $VALUES;
    public static final FlushReason EAGER_FLUSHING_EVENT;
    public static final FlushReason EVENT_THRESHOLD;
    public static final FlushReason EXPLICIT;
    public static final FlushReason TIMER;

    static {
        FlushReason flushReason = new FlushReason(DaWYVMJ.QWuB, 0);
        EXPLICIT = flushReason;
        FlushReason flushReason2 = new FlushReason("TIMER", 1);
        TIMER = flushReason2;
        FlushReason flushReason3 = new FlushReason("SESSION_CHANGE", 2);
        FlushReason flushReason4 = new FlushReason(eoBKjVuj.VrsJkhSLpEpaaZb, 3);
        FlushReason flushReason5 = new FlushReason("EVENT_THRESHOLD", 4);
        EVENT_THRESHOLD = flushReason5;
        FlushReason flushReason6 = new FlushReason("EAGER_FLUSHING_EVENT", 5);
        EAGER_FLUSHING_EVENT = flushReason6;
        $VALUES = new FlushReason[]{flushReason, flushReason2, flushReason3, flushReason4, flushReason5, flushReason6};
    }

    public static FlushReason valueOf(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return (FlushReason) Enum.valueOf(FlushReason.class, value);
    }

    public static FlushReason[] values() {
        return (FlushReason[]) Arrays.copyOf($VALUES, 6);
    }
}
