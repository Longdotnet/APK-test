package com.google.android.datatransport.runtime.util;

import android.util.SparseArray;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class PriorityMapping {
    public static final HashMap PRIORITY_INT_MAP;
    public static final SparseArray PRIORITY_MAP = new SparseArray();

    static {
        HashMap map = new HashMap();
        PRIORITY_INT_MAP = map;
        map.put(Priority.DEFAULT, 0);
        map.put(Priority.VERY_LOW, 1);
        map.put(Priority.HIGHEST, 2);
        for (Priority priority : map.keySet()) {
            PRIORITY_MAP.append(((Integer) PRIORITY_INT_MAP.get(priority)).intValue(), priority);
        }
    }

    public static int toInt(Priority priority) {
        Integer num = (Integer) PRIORITY_INT_MAP.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    public static Priority valueOf(int i) {
        Priority priority = (Priority) PRIORITY_MAP.get(i);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Unknown Priority for value "));
    }
}
