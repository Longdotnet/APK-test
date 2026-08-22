package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ClientMetrics {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final String app_namespace_;
    public final GlobalMetrics global_metrics_;
    public final List log_source_metrics_;
    public final TimeWindow window_;

    static {
        Collections.unmodifiableList(new ArrayList());
    }

    public ClientMetrics(TimeWindow timeWindow, List list, GlobalMetrics globalMetrics, String str) {
        this.window_ = timeWindow;
        this.log_source_metrics_ = list;
        this.global_metrics_ = globalMetrics;
        this.app_namespace_ = str;
    }
}
